package supermarkrt;

import java.util.Arrays;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.*;
import java.io.FileWriter;

public class Dskhachhang implements Mang {
	Scanner sc = new Scanner(System.in);
	private int n;
	Khachhang[] dskh = new Khachhang[1];
	KiemLoi kt = new KiemLoi();

	public Dskhachhang() {
		this.docFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\khachhang.txt");
	}

	public Dskhachhang(Khachhang[] dskh) {
		this.dskh = dskh;
	}

	public Khachhang[] getDskh() {
		return dskh;
	}

	public void setDskh(Khachhang[] dskh) {
		this.dskh = dskh;
	}

	public void nhap() {
		System.out.println("* nhập số lượng khách hàng *");
		n = Integer.parseInt(sc.nextLine());
		dskh = Arrays.copyOf(dskh, n);
		for (int i = 0; i < n; i++) {
			System.out.println("* nhập khách hàng thứ " + (i + 1) + " *");
			dskh[i] = new Khachhang();
			dskh[i].nhap();
		}
	}

	public void xuat() {
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.println(
					"+------------------------------------- Danh sách khách hàng --------------------------------+");
			System.out.printf("%-15s%-20s%-15s%-15s%-15s%-15s%-12s%-15s\n", "mã khách hàng", "tên", "phường","quận","thành phố", "phái", "sdt",
					"tuổi");
			//System.out.println("");
			for (int i = 0; i < n; i++) {
				dskh[i].xuat();
			}
		}
	}

	public Khachhang layKhachHang(String makh) {
		for (int i = 0; i < n; i++) {
			if (dskh[i].getMakh().equals(makh) == true) {
				return dskh[i];
			}
		}
		return null;
	}

	public int layVtKhachHang(String makh) {
		for (int i = 0; i < n; i++) {
			if (dskh[i].getMakh().equals(makh) == true) {
				return i;
			}
		}
		return -1;
	}

	public boolean kiemTraKhachHang(String makh) {
		for (int i = 0; i < n; i++) {
			if (dskh[i].getMakh().equals(makh) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean kiemTraKhachHangTheoTen(String ten) {
		for (int i = 0; i < n; i++) {
			if (dskh[i].getTen().equals(ten) == true) {
				return true;
			}
		}
		return false;
	}

	public void timKiemTheoMa() {
		System.out.println(
				"+--- Danh sách khách hàng ---+");
		System.out.printf("%-15s%-20s\n", "mã khách hàng", "tên");
		//System.out.println("");
		for (int i = 0; i < n; i++) {
			dskh[i].xuatmavaten();
		}
		String makh;
		System.out.println("* Vui lòng nhập mã khách hàng cần xoá *");
		while(true) {
			makh=kt.kiemTraMa();
			if(kiemTraKhachHang(makh)==true) {
				int dem = 0;
				for (int i = 0; i < n; i++) {
					if (dskh[i].getMakh().equals(makh) == true) {
						dem++;
						dskh[i].xuat();
					}
				}
				if (dem == 0)
					System.out.println("Tim khong thay!!!");
			}else {
				System.out.println("** Mã bạn cần xoá không tồn tại. Nhập lại **");
			}
		}
		
		
	}

	public void timKiemTheoTen() {
		System.out.println(
				"+--- Danh sách khách hàng ---+");
		System.out.printf("%-15s%-20s\n", "mã khách hàng", "tên");
		//System.out.println("");
		for (int i = 0; i < n; i++) {
			dskh[i].xuatmavaten();
		}
		String makh;
		System.out.println("* Vui lòng nhập mã khách hàng cần tìm *");
		while(true) {
			makh=kt.kiemTraMa();
			if(kiemTraKhachHang(makh)==true) {
				int dem = 0;
				for (int i = 0; i < n; i++) {
					if (dskh[i].getTen().equals(makh) == true) {
						dem++;
						dskh[i].xuat();
					}
				}
				if (dem == 0)
					System.out.println("Tim khong thay!!!");
			}else {
				System.out.println("** Mã khách hàng bạn tìm không tồn tại. Nhập lại **");
			}
		}
		
	}

	public void sapXepTheoMa() {
		Khachhang temp = dskh[0];
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (dskh[j].getMakh().compareTo(dskh[i].getMakh()) < 0) {
					temp = dskh[i];
					dskh[i] = dskh[j];
					dskh[j] = temp;
				}
			}
		System.out.println(
				"+------------------------------------- Danh sách khách hàng --------------------------------+");
		System.out.printf("%-15s%-20s%-15s%-15s%-15s%-15s%-12s%-15s\n", "mã khách hàng", "tên", "phường","quận","thành phố", "phái", "sdt",
				"tuổi");
		//System.out.println("");
		for (int i = 0; i < n; i++) {
			dskh[i].xuat();
		}
	}

	public void sapXepTheoTen() {
		Khachhang temp = dskh[0];
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (dskh[j].getTen().compareTo(dskh[i].getTen()) < 0) {
					temp = dskh[i];
					dskh[i] = dskh[j];
					dskh[j] = temp;
				}
			}
		System.out.println(
				"+------------------------------------- Danh sách khách hàng --------------------------------+");
		System.out.printf("%-15s%-20s%-15s%-15s%-15s%-15s%-12s%-15s\n", "mã khách hàng", "tên", "phường","quận","thành phố", "phái", "sdt",
				"tuổi");
		//System.out.println("");
		for (int i = 0; i < n; i++) {
			dskh[i].xuat();
		}
	}

	public void xoa() {
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.println("* Vui lòng nhập mã khách hàng cần xoá *");
			System.out.println(
					"+--- Danh sách mã và tên khách hàng ---+");
			System.out.printf("%-12s%-20s\n", "Mã khách hàng", "Tên");
			System.out.printf("");
			for (int i = 0; i < n; i++) {
				dskh[i].xuat();
			}
			String makh;
			int k = 0;
			makh=kt.kiemTraMa();
			if(kiemTraKhachHang(makh)==true) {
				for (int i = 0; i < n; i++) {
					if (dskh[i].getMakh().equals(makh) == false)
						dskh[k++] = dskh[i];
				}
				n--;
				System.out.println("* Bạn đã xóa thành công *");
			}else {
				System.out.println("** Mã bạn cần xoá không tồn tại. Nhập lại **");
			}
		}
		
	}

	public void them() {
		System.out.println("Thêm bao nhiêu khách hàng");
		int m = n;
		int soluong;
		soluong = Integer.parseInt(sc.nextLine());
		this.n = n + soluong;
		dskh = Arrays.copyOf(dskh, n);
		for (int i = m; i < n; i++) {
			dskh[i] = new Khachhang();
			dskh[i].nhap();
		}
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\khachhang.txt");
	}

	public void Sua() {
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.println(
					"+------------------------------------- Danh sách khách hàng --------------------------------+");
			System.out.printf("%-15s%-20s%-15s%-15s%-15s%-15s%-12s%-15s\n", "mã khách hàng", "tên", "phường","quận","thành phố", "phái", "sdt",
					"tuổi");
			//System.out.println("");
			for (int i = 0; i < n; i++) {
				dskh[i].xuat();
			}
			System.out.print("* Nhập mã khách hàng bạn muốn sửa *");
			String makh = sc.nextLine(); // KT xem ma nay co o trong mang ko?
			int vt = layVtKhachHang(makh);
			if (vt == -1)
				System.out.print("* Mã khách hàng bạn nhập không có *");
			else
				{
					System.out.println(
							"+------------------------------------- Danh sách khách hàng --------------------------------+");
					System.out.printf("%-15s%-20s%-50s%-7s%-12s%-5s\n", "mã khách hàng", "tên", "phường","quận","thành phố", "phái", "sdt",
							"tuổi");
					dskh[vt].xuat();
					dskh[vt] = MenuSua(dskh[vt]);
					
				}
			}
	}

	public Khachhang MenuSua(Khachhang kh) {
		boolean flag = true;
		do {
			System.out.println("=========MENU=========");
			System.out.println("1. Họ tên");
			System.out.println("2. Phái");
			System.out.println("3. Số điện thoại");
			System.out.println("4. Tuổi");
			System.out.println("5. Phường");
			System.out.println("6. Quận");
			System.out.println("7. Thành phố");
			System.out.println("8. Mã khách hàng");
			System.out.println("9. Thoát");
			System.out.print("* Nhập lựa chọn của bạn *");
			switch (kt.kiemTraMenu(9)) {
			case 1: {
				System.out.print("* Nhập họ tên mới *");
				kh.setTen(kt.kiemTraTen()); // Co the kt Ten truoc khi nhap
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 2: {
				System.out.print("* Nhập lại giới tính *");
				kh.setPhai(kt.ktPhai()); // Kiem tra la Nam / Nu
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 3: {
				System.out.print("* Nhập lại sdt *");
				kh.setSdt(kt.kiemTraSdt()); // KT Chuoi theo kieu so
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 4: {
				System.out.print("* Nhập lại tuổi *");
				kh.setTuoi(kt.kiemTraTuoi()); // KT so . ( Nhap ki tu se bao sai)
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 5: {
				System.out.print("* Nhập lại phường *");
				kh.getDiachi().setPhuong(kt.kiemTraTen());
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 6: {
				System.out.print("* Nhập lại quận*");
				kh.getDiachi().setQuan(kt.kiemTraTen());
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 7: {
				System.out.print("* Nhập lại thành phố *");
				kh.getDiachi().setQuan(kt.kiemTraTen());
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 8: {
				System.out.print("* Nhập lại mã khách hàng *");
				kh.setMakh(kt.kiemTraMa());
				System.out.println("* Bạn đã sửa thành công *");
				break;
			}
			case 9: {
				this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\khachhang.txt");
				flag = false;
				System.out.println("* Bạn đã thoát *");
				break;
			}
			}
		} while (flag);

		return kh;
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
				pw.println(dskh[i].getMakh() + ";" + dskh[i].getTen() + ";" + dskh[i].getPhai() + ";" + dskh[i].getSdt()
						+ ";" + dskh[i].getTuoi() + ";" + dskh[i].getDiachi().getPhuong() + ";"
						+ dskh[i].getDiachi().getQuan() + ";" + dskh[i].getDiachi().getThanhpho());

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
			dskh = Arrays.copyOf(dskh, n);
			while (scanFile.hasNextLine()) {
				String row = scanFile.nextLine();

				if (row.equals("") != true) {
					String[] data = row.split("\\;");
					Khachhang temp = new Khachhang();

					temp.setMakh(data[0]);
					temp.setTen(data[1]);
					temp.setPhai(data[2]);
					temp.setSdt(data[3]);
					temp.setTuoi(Integer.parseInt(data[4]));
					Diachi diachi = new Diachi(data[5], data[6], data[7]);
					temp.setDiachi(diachi);

					dskh[i] = new Khachhang();
					this.dskh[i] = temp;
					i++;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void timKiemTheoMa(String ma) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timKiemTheoTen(String ten) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoa(String ma) {
		// TODO Auto-generated method stub
		
	}
}
