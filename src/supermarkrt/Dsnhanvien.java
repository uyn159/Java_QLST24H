package supermarkrt;

import java.util.Arrays;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Dsnhanvien implements Mang {
	Scanner sc = new Scanner(System.in);
	private int n;
	Nhanvien[] dsnv = new Nhanvien[1];
	KiemLoi kt = new KiemLoi();

	public Dsnhanvien() {
		this.docFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhanvien.txt");
	}

	public Dsnhanvien(Nhanvien[] dsnv) {
		this.dsnv = dsnv;
	}

	public Nhanvien[] getDsnv() {
		return dsnv;
	}

	public void setDsnv(Nhanvien[] dsnv) {
		this.dsnv = dsnv;
	}

	public void nhap() {
		System.out.println("* nhập số lượng nhân viên");
		n = Integer.parseInt(sc.nextLine());
		dsnv = Arrays.copyOf(dsnv, n);
		for (int i = 0; i < n; i++) {
			System.out.println("* nhập nhân viên thứ " + (i + 1) + " *");
			dsnv[i] = new Nhanvien();
			dsnv[i].nhap();
		}
	}

	public void xuat() {
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.println(
					"+------------------------------------- Danh sách nhân viên -----------------------------------------+");
			System.out.printf("%-15s%-20s%-12s%-15s%-15s%-15s%-15s%-12s%-7s%-5s\n", "Mã nhân viên", "Tên", "mã quản lý", "phường","quận","thành phố",
					"sdt", "phái", "tuổi","lương");
			System.out.println("");
			int i;
			for (i = 0; i < n; i++) {
				dsnv[i].xuat();
			}
		}
	}

	public Nhanvien layNhanVien(String manv) {
		for (int i = 0; i < n; i++) {
			if (dsnv[i].getManv().equals(manv) == true) {
				return dsnv[i];
			}
		}
		return null;
	}

	public int layVtNhanVien(String manv) {
		for (int i = 0; i < n; i++) {
			if (dsnv[i].getManv().equals(manv) == true) {
				return i;
			}
		}
		return -1;
	}

	public boolean kiemTraNhanVien(String manv) {
		for (int i = 0; i < n; i++) {
			if (dsnv[i].getManv().equals(manv) == true)
				return true;
		}
		return false;
	}

	public boolean kiemTraNhanVienTheoTen(String ten) {
		for (int i = 0; i < n; i++) {
			if (dsnv[i].getTen().equals(ten) == true) {
				return true;
			}
		}
		return false;
	}

	public void timKiemTheoMa() {
		System.out.println(
				"+--- Danh sách nhân viên ---+");
		System.out.printf("%-15s%-20s\n", "Mã nhân viên", "Tên");
		System.out.println("");
		int j;
		for (j = 0; j < n; j++) {
			dsnv[j].xuat();
		}
		String manv;
		System.out.println("* Vui lòng nhập mã nhân viên bạn cần tìm *");
		while(true) {
			manv=kt.kiemTraMa();
			if(kiemTraNhanVien(manv)==true) {
				int dem = 0;
				int i;
				for (i = 0; i < n; i++) {
					if (dsnv[i].getManv().equals(manv) == true) {
						dem++;
						dsnv[i].xuat();
					}
				}
				if (dem == 0)
					System.out.println("Tim khong thay!!!");
				break;
			}else {
				System.out.println("** Không có mã bạn cần tìm. Nhập lại **");
			}
		}
		
	}

	public void timKiemTheoTen() {
		System.out.println(
				"+--- Danh sách nhân viên ---+");
		System.out.printf("%-15s%-20s\n", "Mã nhân viên", "Tên");
		System.out.println("");
		int j;
		for (j = 0; j < n; j++) {
			dsnv[j].xuat();
		}
		String ten;
		System.out.println("** Vui lòng nhập tên nhân viên bạn cần tìm **");
		while(true) {
			ten = kt.kiemTraTen();
			if(kiemTraNhanVienTheoTen(ten)==true) {
				int dem = 0;
				int i;
				for (i = 0; i < n; i++) {
					if (dsnv[i].getTen().equals(ten) == true) {
						dem++;
						dsnv[i].xuat();
					}
				}
				if (dem == 0)
					System.out.println("Tim khong thay!!!");
			}else {
				System.out.println("* Không có tên nhân viên bạn muốn tìm *");
			}
		}
		
	}

	public void sapXepTheoMa() {
		
		Nhanvien temp = dsnv[0];
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (dsnv[j].getManv().compareTo(dsnv[i].getManv()) < 0) {
					temp = dsnv[i];
					dsnv[i] = dsnv[j];
					dsnv[j] = temp;
				}
			}
	}

	public void sapXepTheoTen() {
		Nhanvien temp = dsnv[0];
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (dsnv[j].getTen().compareTo(dsnv[i].getTen()) < 0) {
					temp = dsnv[i];
					dsnv[i] = dsnv[j];
					dsnv[j] = temp;
				}
			}
	}

	public void xoa() {
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.println("* Nhập mã mà bạn muốn xóa *");
			System.out.println(
					"+--- Danh sách nhân viên ---+");
			System.out.printf("%-15s%-20s\n", "Mã nhân viên", "Tên");
			System.out.println("");
			int j;
			for (j = 0; j < n; j++) {
				dsnv[j].xuat();
			}
			// boolean k=true;
			String x;
			
			while (true) {
				x = kt.kiemTraMa();
				if (kiemTraNhanVien(x) == true) {
					int k = 0;
					for (int i = 0; i < n; i++) {
						if (dsnv[i].getManv().equals(x) == false)
							dsnv[k++] = dsnv[i];
					}
					n--;
					break;
				} else {
					System.out.println("** Không tìm thấy mã bạn cần xoá. Nhập lại **");
				}
			}
			System.out.println("** Bạn đã xóa thành công **");
		}
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhacungcap.txt");
		
	}

	public void them() {
			System.out.println("* Thêm bao nhiêu nhân viên ? *");
			int m = n;
			int soluong;
			soluong = Integer.parseInt(sc.nextLine());
			this.n = n + soluong;
			dsnv = Arrays.copyOf(dsnv, n);
			for (int i = m; i < n; i++) {
				dsnv[i] = new Nhanvien();
				dsnv[i].nhap();
			}
			System.out.println("** Bạn đã nhập thành công **");
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhanvien.txt");
	}

	public void Sua() {
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.print("* Nhập mã nhân viên bạn muốn sửa *");
			System.out.println(
					"+------------------------------------- Danh sách nhân viên -----------------------------------------+");
			System.out.printf("%-15s%-20s%-12s%-15s%-15s%-15s%-15s%-12s%-7s%-5s\n", "Mã nhân viên", "Tên", "mã quản lý", "phường","quận","thành phố",
					"sdt", "phái", "tuổi","lương");
			System.out.println("");
			int j;
			for (j = 0; j < n; j++) {
				dsnv[j].xuat();
			}
		
		String manv = sc.nextLine(); // KT xem ma nay co o trong mang ko?
		int vt = layVtNhanVien(manv);
		if (vt == -1)
			System.out.print("* Mã nhân viên bạn nhập không có *");
		else {
			System.out.println(
					"+------------------------------------- Danh sách nhân viên -----------------------------------------+");
			System.out.printf("%-15s%-20s%-12s%-15s%-15s%-15s%-15s%-12s%-7s%-5s\n", "Mã nhân viên", "Tên", "mã quản lý", "phường","quận","thành phố",
					"sdt", "phái", "tuổi","lương");
			System.out.println("");
				dsnv[vt].xuat();
				dsnv[vt] = MenuSua(dsnv[vt]);
		}
			
		
		}
		
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhanvien.txt");
	}

	public Nhanvien MenuSua(Nhanvien nv) {
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
			System.out.println("8. Mã nhân viên");
			System.out.println("9. Mã quản lý");
			System.out.println("10. Lương");
			System.out.println("11. Thoát");
			System.out.print("* Nhập lựa chọn của bạn *");

			switch (kt.kiemTraMenu(11)) {
			case 1: {
				System.out.print("* Nhập họ tên mới *");
				nv.setTen(kt.kiemTraTen()); // Co the kt Ten truoc khi nhap
				System.out.println("** Bạn đã nhập sửa công **");
				break;
			}
			case 2: {
				System.out.print("* Nhập lại giới tính *");
				nv.setPhai(kt.ktPhai()); // Kiem tra la Nam / Nu
				System.out.println("** Bạn đã nhập sửa công **");
				break;
			}
			case 3: {
				System.out.print("* Nhập lại sdt *");
				nv.setSdt(kt.kiemTraSdt()); // KT Chuoi theo kieu so
				System.out.println("** Bạn đã nhập sửa công **");
				break;
			}
			case 4: {
				System.out.print("* Nhập lại tuổi *");
				nv.setTuoi(kt.kiemTraTuoi()); // KT so . ( Nhap ki tu se bao sai)
				System.out.println("** Bạn đã nhập sửa công **");
				break;
			}
			case 5: {
				System.out.print("* Nhập lại phường *");
				nv.getDiachi().setPhuong(kt.kiemTraTen());
				System.out.println("** Bạn đã nhập sửa công **");
				break;
			}
			case 6: {
				System.out.print("* Nhập lại quận*");
				nv.getDiachi().setQuan(kt.kiemTraTen());
				System.out.println("** Bạn đã nhập sửa công **");
				break;
			}
			case 7: {
				System.out.print("* Nhập lại thành phố *");
				nv.getDiachi().setQuan(kt.kiemTraTen());
				System.out.println("** Bạn đã nhập sửa công **");
				break;
			}
			case 8: {
				System.out.print("* Nhập lại mã nhân viên *");
				nv.setManv(kt.kiemTraMa());
				System.out.println("** Bạn đã nhập sửa công **");
				break;
			}
			case 9: {
				System.out.println("* Nhập lại mã quản lý *");
				nv.setMaql(kt.kiemTraMa());
				System.out.println("** Bạn đã nhập sửa công **");
				break;
			}
			case 10: {
				System.out.println("* Nhập lại lương *");
				nv.setLuong(kt.kiemTraFloat());
				System.out.println("** Bạn đã nhập sửa công **");
				break;
			}
			case 11: {
				this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhacungcap.txt");
				
				flag = false;
				System.out.println("* Bạn đã thoát *");
				break;
			}
			}
		} while (flag);

		return nv;
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
			PrintWriter pw = new PrintWriter((fw));
			int i;
			for (i = 0; i < n; i++) {
				pw.println(dsnv[i].getManv() + ";" + dsnv[i].getTen() + ";" + dsnv[i].getPhai() + ";" + dsnv[i].getSdt()
						+ ";" + dsnv[i].getTuoi() + ";" + dsnv[i].getDiachi().getThanhpho() + ";"
						+ dsnv[i].getDiachi().getPhuong() + ";" + dsnv[i].getDiachi().getQuan() + ";"
						+ dsnv[i].getMaql() + ";" + dsnv[i].getLuong());
			}
			pw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("** Lỗi file **");
		}
	}

	public void docFile(String name) {
		try {

			int i = 0;

			Scanner scanFile = new Scanner(Paths.get(name));
			n = demDong(name);
			dsnv = Arrays.copyOf(dsnv, n);

			while (scanFile.hasNextLine()) {
				String row = scanFile.nextLine();
				if (row.equals("") != true) {
					String[] data = row.split("\\;");
					Nhanvien temp = new Nhanvien();
					temp.setManv(data[0]);
					temp.setTen(data[1]);
					temp.setPhai(data[2]);
					temp.setSdt(data[3]);
					temp.setTuoi(Integer.parseInt(data[4]));
					Diachi diachi = new Diachi(data[5], data[6], data[7]);
					temp.setDiachi(diachi);
					temp.setMaql(data[8]);
					temp.setLuong(Float.parseFloat(data[9]));

					dsnv[i] = new Nhanvien();
					this.dsnv[i] = temp;
					i++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("** Lỗi file **");
		}
	}

	@Override
	public void xoa(String ma) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timKiemTheoMa(String ma) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timKiemTheoTen(String ten) {
		// TODO Auto-generated method stub
		
	}

}
