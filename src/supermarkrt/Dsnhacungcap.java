package supermarkrt;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Dsnhacungcap {
	Scanner sc = new Scanner(System.in);
	private int n;
	Nhacungcap[] dsncc = new Nhacungcap[1];
	KiemLoi kt = new KiemLoi();

	public Dsnhacungcap() {
		this.docFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhacungcap.txt");
	}

	public Dsnhacungcap(Nhacungcap[] dsncc) {
		this.dsncc = dsncc;
	}

	public Nhacungcap[] getDsncc() {
		return dsncc;
	}

	public void setDsncc(Nhacungcap[] dsncc) {
		this.dsncc = dsncc;
	}

	public void nhap() {
		System.out.println("* nhập số lượng nhà cung *");
		n = Integer.parseInt(sc.nextLine());
		dsncc = Arrays.copyOf(dsncc, n);
		for (int i = 0; i < n; i++) {
			System.out.println("* nhập nhà cung thứ " + (i + 1) + " *");
			dsncc[i] = new Nhacungcap();
			dsncc[i].nhap();
		}
	}

	public void xuat() {
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.println(
					"+------------------------------------- Danh sách nhà cung --------------------------------+");
			System.out.printf("%-12s%-20s%-15s%-15s%-15s%-12s\n", "mã nhà cung", "tên","Phường","quận","Thành phố", "sdt");
			System.out.printf("");
			for (int i = 0; i < n; i++) {
				dsncc[i].xuat();
			}
		}
	}

	public Nhacungcap layNhaCung(String mancc) {
		for (int i = 0; i < n; i++) {
			if (dsncc[i].getMacc().equals(mancc) == true)
				return dsncc[i];
		}
		return null;
	}

	public int layVtNhaCung(String mancc) {
		for (int i = 0; i < n; i++) {
			if (dsncc[i].getMacc().equals(mancc) == true) {
				return i;
			}
		}
		return -1;
	}

	public boolean kiemTraNhaCung(String mancc) {
		for (int i = 0; i < n; i++) {
			if (dsncc[i].getMacc().equals(mancc) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean kiemTraNhaCungTheoTen(String ten) {
		for (int i = 0; i < n; i++) {
			if (dsncc[i].getTen().equals(ten) == true) {
				return true;
			}
		}
		return false;
	}

	public void timKiemTheoMa() {
		System.out.println(
				"+--- Danh sách mã và tên nhà cung cấo ---+");
		System.out.printf("%-12s%-20s\n", "Mã nhà cung", "Tên");
		System.out.printf("");
		for (int i = 0; i < n; i++) 
			{
				dsncc[i].xuatmavaten();
			}
		String mancc;
		System.out.println("* Vui lòng nhập mã nhà cung cần tìm *");
		while(true) {
			mancc=kt.kiemTraMa();
			if(kiemTraNhaCung(mancc)==true) {
				int dem = 0;
				for (int i = 0; i < n; i++) {
					if (dsncc[i].getMacc().equals(mancc) == true) {
						dem++;
						dsncc[i].xuat();
					}
				}
				if (dem == 0)
					System.out.println("** Tìm không thấy!!! **");
				break;
			}else {
				System.out.println("** Mã khách hàng bạn tìm không tồn tại. Nhập lại **");
			}
		}
		
	}

	public void timKiemTheoTen() {
		System.out.println(
				"+--- Danh sách mã và tên nhà cung cấo ---+");
		System.out.printf("%-12s%-20s\n", "Mã nhà cung", "Tên");
		System.out.printf("");
		for (int i = 0; i < n; i++) 
			{
				dsncc[i].xuatmavaten();
			}
		String ten;
		System.out.println("* Vui lòng nhập tên nhà cung cần tìm *");
		while(true) {
			ten=kt.kiemTraTen();
			if(kiemTraNhaCungTheoTen(ten)==true) {
				int dem = 0;
				for (int i = 0; i < n; i++) {
					if (dsncc[i].getTen().equals(ten) == true) {
						dem++;
						dsncc[i].xuat();
					}
				}
				if (dem == 0)
					System.out.println("** Tìm không thấy!!! **");
				break;
			}else {
				System.out.println("** Tên bạn tìm không tồn tại. Nhập lại **");
			}
		}
		
	}

	public void sapXepTheoMa() {
		Nhacungcap temp = dsncc[0];
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (dsncc[j].getMacc().compareTo(dsncc[i].getMacc()) < 0) {
					temp = dsncc[i];
					dsncc[i] = dsncc[j];
					dsncc[j] = temp;
				}
			}
	}

	public void sapXepTheoTen() {
		Nhacungcap temp = dsncc[0];
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (dsncc[j].getTen().compareTo(dsncc[i].getTen()) < 0) {
					temp = dsncc[i];
					dsncc[i] = dsncc[j];
					dsncc[j] = temp;
				}
			}
	}

	public void xoa() {
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.println("* Vui lòng nhập mã nhà cung cần xoá *");
			System.out.println(
					"+--- Danh sách mã và tên nhà cung cấo ---+");
			System.out.printf("%-12s%-20s\n", "Mã nhà cung", "Tên");
			System.out.printf("");
			for (int i = 0; i < n; i++) 
				{
					dsncc[i].xuatmavaten();
				}
				String mancc;
				
						mancc=kt.kiemTraMa();
						if(kiemTraNhaCung(mancc)==true) {
							int k = 0;
							for (int j = 0; j < n; j++) {
								if (dsncc[j].getMacc().equals(mancc) == false)
									dsncc[k++] = dsncc[j];
							}
							n--;
							System.out.println("* Bạn đã xóa thành công *");
							
						}else {
							System.out.println("** Mã bạn cần xoá không tồn tại. Nhập lại **");
						}
					
				}
			
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhacungcap.txt");
		
	}

	public void them() {
		System.out.println("* Thêm bao nhiêu nhà cung *");
		int m = n;
		int soluong;
		soluong = Integer.parseInt(sc.nextLine());
		this.n = n + soluong;
		dsncc = Arrays.copyOf(dsncc, n);
		for (int i = m; i < n; i++) {
			dsncc[i] = new Nhacungcap();
			dsncc[i].nhap();
		}
		System.out.println("** Bạn đã nhập thành công **");
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhacungcap.txt");
	}

	public void Sua() {
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.println("* Nhập mã nhà cung bạn muốn sửa *");
			System.out.println(
					"+------------------------------------- Danh sách nhà cung --------------------------------+");
			System.out.printf("%-12s%-20s%-15s%-15s%-15s%-12s\n", "mã nhà cung", "tên","Phường","quận","Thành phố", "SĐT");
			System.out.printf("");
			for (int i = 0; i < n; i++) {
				dsncc[i].xuat();
			}
			//228
			}
			String mancc = kt.kiemTraMa(); // KT xem ma nay co o trong mang ko?
			int vt = layVtNhaCung(mancc);
			if (vt == -1)
				System.out.println("* Mã nhà cung bạn nhập không có *");
			else {
				System.out.println(
						"+------------------------------------- Danh sách nhà cung --------------------------------+");
				System.out.printf("%-12s%-20s%-15s%-15s%-15s%-12s\n", "mã nhà cung", "tên","Phường","quận","Thành phố", "SĐT");
				System.out.printf("");
				dsncc[vt].xuat();
				dsncc[vt] = MenuSua(dsncc[vt]);
				
			}
	}

	public Nhacungcap MenuSua(Nhacungcap nc) {
		boolean flag = true;
		do {
			System.out.println("=========MENU=========");
			System.out.println("1. Mã cung cấp");
			System.out.println("2. Tên công ty");
			System.out.println("3. Số điện thoại");
			System.out.println("4. Phường");
			System.out.println("5. Quận");
			System.out.println("6. Thành phố");
			System.out.println("7. Thoát");
			System.out.print("* Nhập lựa chọn của bạn *");

			switch (kt.kiemTraMenu(7)) {
			case 1: {
				System.out.print("* Nhập mã nhà cung cấp mới *");
				nc.setMacc(kt.kiemTraMa());
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 2: {
				System.out.print("* Nhập lại tên công ty *");
				nc.setTen(kt.kiemTraTen());
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 3: {
				System.out.print("* Nhập lại SĐT *");
				nc.setSdt(kt.kiemTraSdt()); // KT Chuoi theo kieu so
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 4: {
				System.out.print("* Nhập lại phường *");
				nc.getDiachi().setPhuong(kt.kiemTraTen());
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 5: {
				System.out.print("* Nhập lại quận*");
				nc.getDiachi().setQuan(kt.kiemTraTen());
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 6: {
				System.out.print("* Nhập lại thành phố *");
				nc.getDiachi().setQuan(kt.kiemTraTen());
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 7: {
				this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhacungcap.txt");
				flag = false;
				System.out.println("* Bạn đã thoát *");
				break;
			}
			}
		} while (flag);

		return nc;
	}

	public int demDong(String name) {
		int dem = 0;
		try {
			Scanner scanFile = new Scanner(Paths.get(name));
			while (scanFile.hasNextLine()) {
				dem++;
				String row = scanFile.nextLine();
				if (row.equals("")) {
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem;
	}

	public void ghiFile(String name) {
		try {
			FileWriter fw = new FileWriter(name);
			PrintWriter pw = new PrintWriter(fw);
			for (int i = 0; i < n; i++) {
				pw.println(dsncc[i].getMacc() + ";" + dsncc[i].getTen() + ";" + dsncc[i].getDiachi().getPhuong() + ";"
						+ dsncc[i].getDiachi().getQuan() + ";" + dsncc[i].getDiachi().getThanhpho() + ";"
						+ dsncc[i].getSdt());

			}
			fw.close();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void docFile(String name) {
		try {
			int i = 0;
			n = demDong(name);
			Scanner scanFile = new Scanner(Paths.get(name), "UTF-8");
			dsncc = Arrays.copyOf(dsncc, n);
			while (scanFile.hasNextLine()) {
				String row = scanFile.nextLine();

				if (row.equals("") != true) {
					String[] data = row.split("\\;");
					Nhacungcap temp = new Nhacungcap();

					temp.setMacc(data[0]);
					temp.setTen(data[1]);
					Diachi diachi = new Diachi(data[2], data[3], data[4]);
					temp.setDiachi(diachi);
					temp.setSdt(data[5]);

					dsncc[i] = new Nhacungcap();
					this.dsncc[i] = temp;
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
