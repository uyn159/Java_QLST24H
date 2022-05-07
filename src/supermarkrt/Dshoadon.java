package supermarkrt;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.file.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Dshoadon {
	Scanner sc = new Scanner(System.in);
	private int n;
	Hoadon[] dshd = new Hoadon[1];
	KiemLoi kt = new KiemLoi();
	// private final String filename = "hoadon.txt";

	public Dshoadon() {
		this.docFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\hoadon.txt");
	}

	public Dshoadon(Hoadon[] dshd) {
		this.dshd = dshd;
	}

	public Hoadon[] getDshd() {
		return dshd;
	}

	public void setDshd(Hoadon[] dshd) {
		this.dshd = dshd;
	}

	public void nhap() {
		System.out.println("* nhập số lượng *");
		n = Integer.parseInt(sc.nextLine());
		dshd = Arrays.copyOf(dshd, n);
		for (int i = 0; i < n; i++) {
			System.out.println("* nhập hóa đơn " + (i + 1) + " *");
			dshd[i] = new Hoadon();
			dshd[i].nhap();
		}
	}

	public void xuat() {
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.println("+------------------------------------- Danh sách hoá đơn --------------------------------+");
			System.out.printf("%-12s%-12s%-20s\n", "mã hoá đơn", "mã đối tác", "ngày ra hoá đơn");
			System.out.printf("");
			for (int i = 0; i < n; i++) {
				dshd[i].xuat();
			}
		}
				
		
	}

	public Hoadon layHoaDon(String mahd) {
		for (int i = 0; i < n; i++) {
			if (dshd[i].getMahd().equals(mahd) == true)
				return dshd[i];
		}
		return null;
	}

	public int layVtHoaDon(String mahd) {
		for (int i = 0; i < n; i++) {
			if (dshd[i].getMahd().equals(mahd) == true) {
				return i;
			}
		}
		return -1;
	}

	public void xuatdt() {
		System.out.println(
				"+--- Danh sách mã và tên nhà cung cấo ---+");
		System.out.printf("%-12s%-20s\n","Mã hóa đơn", "Mã nhà cung");
		System.out.printf("");
		for (int i = 0; i < n; i++) 
			{
				dshd[i].xuatmavamnc();
			}
		String madt;
		System.out.println("* Vui lòng nhập tên nhà cung cần tìm *");
		while(true) {
			madt=kt.kiemTraTen();
			if(KiemTraMaNhaCung(madt)==true) {
				int dem = 0;
				for (int i = 0; i < n; i++) {
					if (dshd[i].getMa().equals(madt) == true) {
						dem++;
						dshd[i].xuat();
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
	public boolean KiemTraMaNhaCung(String manc) {
		for (int i = 0; i < n; i++) {
			if (dshd[i].getMa().equals(manc) == true) {
				return true;
			}
		}
		return false;
	}
	

	public void them() {
		System.out.println("* Thêm bao nhiêu hóa đơn *");
		int m = n;
		int soluong;
		soluong = Integer.parseInt(sc.nextLine());
		this.n = n + soluong;
		dshd = Arrays.copyOf(dshd, n);
		for (int i = m; i < n; i++) {
			dshd[i] = new Hoadon();
			dshd[i].nhap();
		}
		System.out.println("** Bạn đã nhập thành công **");
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\hoadon.txt");
	}

	public void timKiemTheoMa() {
		System.out.println("+------------------------------------- Danh sách hoá đơn --------------------------------+");
		System.out.printf("%-12s%-12s%-20s\n", "mã hoá đơn", "mã đối tác", "ngày ra hoá đơn");
		for (int i = 0; i < n; i++) 
			{
				dshd[i].xuatma();
			}
		String mahd;
		System.out.println("* Vui lòng nhập mã hóa đơn cần tìm *");
		while(true) {
			mahd=kt.kiemTraMa();
			if(kiemTraHoaDon(mahd)==true) {
				int dem = 0;
				for (int i = 0; i < n; i++) {
					if (dshd[i].getMahd().equals(mahd) == true) {
						dem++;
						dshd[i].xuat();
					}
				}
				if (dem == 0)
					System.out.println("** Tìm không thấy!!! **");
				break;
			}else {
				System.out.println("** Mã hóa đơn bạn tìm không tồn tại. Nhập lại **");
			}
		}
		
	}

	public void xoa() {
		
		if (n == 0)
			System.out.println("* Danh sách rỗng *");
		else {
			System.out.println("* Vui lòng nhập mã cần xoá *");
			System.out.println(
					"+--- Danh sách mã hóa đơn và mã cung ---+");
			System.out.printf("%-12s%-20s\n", "Mã hóa đơn", "mã cung");
			System.out.printf("");
			for (int i = 0; i < n; i++) 
				{
					dshd[i].xuatma();
				}
				String mahd;
				
						mahd=kt.kiemTraMa();
						if(kiemTraHoaDon(mahd)==true) {
							int k = 0;
							for (int j = 0; j < n; j++) {
								if (dshd[j].getMahd().equals(mahd) == false)
									dshd[k++] = dshd[j];
							}
							n--;
							System.out.println("* Bạn đã xóa thành công *");
							
						}else {
							System.out.println("** Mã bạn cần xoá không tồn tại. Nhập lại **");
						}
					
				}
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\hoadon.txt");
		
	}

//	public static Comparator<Hoadon> MahdComparator = new Comparator<Hoadon>() {
//		@Override
//		public int compare(Hoadon h1, Hoadon h2) {
//			String Ma1 = h1.getMahd().toUpperCase();
//			String Ma2 = h2.getMahd().toUpperCase();
//
//			return Ma1.compareTo(Ma2);
//		}
//	};
//
//	public void SortMa() {
//		Collections.sort(dshd, MahdComparator);
//	}

	public boolean kiemTraDoiTac(String madt) {
		for (int i = 0; i < n; i++) {
			if (dshd[i].getMa().equals(madt) == true) {
				return true;
			}
		}
		return false;
	}

//	

//	public void tinhSoLuongXuat(String mahd) {
//		Dssanpham sp = new Dssanpham();
//		for (int i = 0; i < dshd.size(); i++) {
//			if (dshd.get(i).getMahd().equals(mahd) == true) {
//				for (int j = 0; dshd.get(i).getCthd().getChitiet().length > j; j++) {
//					String matam = dshd.get(i).getCthd().layPhanTu(j).getMasp();
//					int soluong = dshd.get(i).getCthd().layPhanTu(j).getSoluong();
//					sp.giamSoLuong(soluong, matam);
//				}
//			}
//		}
//	}

	public boolean kiemTraHoaDon(String mahd) {
		for (int i = 0; i < n; i++) {
			if (dshd[i].getMahd().equals(mahd) == true) {
				return true;
			}
		}
		return false;
	}

	public void ghiFile(String name) {
		try {
			FileWriter fw = new FileWriter(name);
			PrintWriter pw = new PrintWriter(fw);
			for (int i = 0; i < n; i++) {
				pw.println(dshd[i].getMahd() + ";" + dshd[i].getMa() + ";" + dshd[i].getNgayrahd());
			}
			pw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("** Lỗi file **");
			e.printStackTrace();
		}
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
	public void docFile(String name) {
		try {
			int i = 0;
			n = demDong(name);
			Scanner scanFile = new Scanner(Paths.get(name), "UTF-8");
			dshd = Arrays.copyOf(dshd, n);
			while (scanFile.hasNextLine()) {
				String row = scanFile.nextLine();

				if (row.equals("") != true) {
					String[] data = row.split("\\;");
					Hoadon temp = new Hoadon();

					temp.setMahd(data[0]);
					temp.setMa(data[1]);
					temp.setNgayrahd(data[2]);

					dshd[i] = new Hoadon();
					this.dshd[i] = temp;
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
