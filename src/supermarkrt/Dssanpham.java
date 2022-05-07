package supermarkrt;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.nio.file.*;
import java.io.PrintWriter;

public class Dssanpham implements Mang {
	Scanner sc = new Scanner(System.in);
	private int n;
	Sanpham[] dssp = new Sanpham[1];
	KiemLoi kt = new KiemLoi();

	public Dssanpham() {
		this.docFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\sanpham.txt");
	}

	public Dssanpham(Sanpham[] dssp) {
		this.dssp = dssp;
	}

	public Sanpham[] getDssp() {
		return dssp;
	}

	public void setDssp(Sanpham[] dssp) {
		this.dssp = dssp;
	}

	public void nhap() {
		System.out.println("Nhập số lượng sản phẩm");
		n = Integer.parseInt(sc.nextLine());
		dssp = Arrays.copyOf(dssp, n);
		for (int i = 0; i < n; i++) {
			dssp[i] = new Sanpham();
			dssp[i].nhap();
		}
	}

	public void xuat() {
		if (n == 0)
			System.out.println("** Danh sách rỗng **");
		else {
			System.out.println(
					"+----------------------------------- Danh mục sản phẩm -------------------------------------+");
			System.out.printf("%-15s%-20s%-15s%-10s%-10s\n", "mã sản phẩm", "tên", "loại", "số lượng", "đơn giá");
			for (int i = 0; i < n; i++) {
				dssp[i].xuat();
			}
		}
	}

	public Sanpham laySanPham(String masp) {
		for (int i = 0; i < n; i++) {
			if (dssp[i].getMasp().equals(masp) == true) {
				return dssp[i];
			}
		}
		return null;
	}

	public int layVtSanPham(String masp) {
		for (int i = 0; i < n; i++) {
			if (dssp[i].getMasp().equals(masp) == true) {
				return i;
			}
		}
		return -1;
	}

	public boolean kiemTraSanPham(String masp) {
		for (int i = 0; i < n; i++) {
			if (dssp[i].getMasp().equals(masp) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean kiemTraSanPhamTheoTen(String ten) {
		for (int i = 0; i < n; i++) {
			if (dssp[i].getTensp().equals(ten) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean kiemTraSanPhamTheoLoai(String loai) {
		for (int i = 0; i < n; i++) {
			if (dssp[i].getLoai().equals(loai) == true) {
				return true;
			}
		}
		return false;
	}

	public void timKiemTheoMa() {
		System.out.println(
				"+--- Danh mục sản phẩm ---+");
		System.out.printf("%-15s%-20s\n", "mã sản phẩm", "tên");
		for (int i = 0; i < n; i++) {
			dssp[i].xuatmavaten();
		}
		String masp;
		System.out.println("* Vui lòng nhập mã cần tìm *");
		while (true) {
			masp = kt.kiemTraMa();
			if (kiemTraSanPham(masp) == true) {
				int dem = 0;
				for (int i = 0; i < n; i++) {
					if (dssp[i].getMasp().equals(masp) == true) {
						dem++;
						dssp[i].xuat();
					}
				}
				if (dem == 0)
					System.out.println("* Tìm không thấy!!! *");
				break;
			} else {
				System.out.println("** Mã sản phẩm cần tìm không tồn tại **");
			}
		}
		
	}

	public void timKiemTheoTen() {
		System.out.println(
				"+--- Danh mục sản phẩm ---+");
		System.out.printf("%-15s%-20s\n", "mã sản phẩm", "tên");
		for (int i = 0; i < n; i++) {
			dssp[i].xuatmavaten();
		}
		String ten;
		System.out.println("* Vui lòng nhập tên cần tìm");
		while (true) {
			ten = kt.kiemTraTen();
			if (kiemTraSanPhamTheoTen(ten) == true) {
				int dem = 0;
				for (int i = 0; i < n; i++) {
					if (dssp[i].getTensp().equals(ten) == true) {
						dem++;
						dssp[i].xuat();
					}
				}
				if (dem == 0)
					System.out.println("* Tìm không thấy!!! *");
				break;
			} else {
				System.out.println("** Tên cần tìm không tồn tại **");
			}
		}
		
	}
	public void timKiemTheoLoai() 
	{
		System.out.println(
				"+--- Danh mục sản phẩm ---+");
		System.out.printf("%-15s\n", "Loại");
		for (int i = 0; i < n; i++) {
			dssp[i].xuatloai();
		}
		String loai;
		System.out.println("* Vui lòng nhập loại sản phẩm cần tìm *");
		while (true) {
			loai = kt.kiemTraTen();
			if (kiemTraSanPhamTheoLoai(loai) == true) {
				int dem = 0;
				for (int i = 0; i < n; i++) {
					if (dssp[i].getLoai().equalsIgnoreCase(loai) == true) {
						dem++;
						dssp[i].xuat();
					}
				}
				if (dem == 0)
					System.out.println("* Tìm không thấy!!! *");
				break;
			} else {
				System.out.println("** Loại sản phẩm cần tìm không tồn tại **");
			}
		}
		
	}

	public void sapXepTheoMa() {
		Sanpham temp = dssp[0];
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (dssp[j].getMasp().compareTo(dssp[i].getMasp()) < 0) {
					temp = dssp[i];
					dssp[i] = dssp[j];
					dssp[j] = temp;
				}
			}
		System.out.println(
				"+----------------------------------- Danh mục sản phẩm -------------------------------------+");
		System.out.printf("%-15s%-20s%-15s%-10s%-10s\n", "mã sản phẩm", "tên", "loại", "số lượng", "đơn giá");
		for (int i = 0; i < n; i++) {
			dssp[i].xuat();
		}
	}

	public void sapXepTheoTen() {
		Sanpham temp = dssp[0];
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (dssp[j].getTensp().compareTo(dssp[i].getTensp()) < 0) {
					temp = dssp[i];
					dssp[i] = dssp[j];
					dssp[j] = temp;
				}
			}
	}

	public void xoa() {
		System.out.println("* Vui lòng nhập mã sản phẩm cần xoá *");
		System.out.println(
				"+--- Danh mục sản phẩm ---+");
		System.out.printf("%-15s%-20s\n", "mã sản phẩm", "tên");
		for (int i = 0; i < n; i++) {
			dssp[i].xuatmavaten();
		}
		String masp;
		
		while (true) {
			masp = kt.kiemTraMa();
			if (kiemTraSanPham(masp) == true) {
				int k = 0;
				for (int i = 0; i < n; i++) {
					if (dssp[i].getMasp().equals(masp) == false)
						dssp[k++] = dssp[i];
				}
				n--;
			} else {
				System.out.println("** Mã sản phẩm bạn cần xoá không tồn tại. Nhập lại **");
			}
		}
		
	}

	public void them() {
		System.out.println("* Thêm bao nhiêu sản phẩm? *");
		int m = n;
		int soluong;
		soluong = Integer.parseInt(sc.nextLine());
		this.n = n + soluong;
		dssp = Arrays.copyOf(dssp, n);
		for (int i = m; i < n; i++) {
			dssp[i] = new Sanpham();
			dssp[i].nhap();
		}
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\sanpham.txt");
	}

	public void them(String masp, String tensp, String loai, int soluong, int dongia) {
		int m = n;
		this.n = n + 1;
		dssp = Arrays.copyOf(dssp, n);
		for (int i = m; i < n; i++) {
			dssp[i] = new Sanpham(masp, tensp, loai, soluong, dongia);
		}
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\sanpham.txt");
	}

	public void giamSoLuong(int soluong, String masp) {
		int vt = this.layVtSanPham(masp);
		if (dssp[vt].getSoluong() < soluong) {
			System.out.println("** Số lượng sản phẩm không đủ **");
		} else {
			dssp[vt].setSoluong(dssp[vt].getSoluong() - soluong);
		}
	}

	public void Sua() {
		if (n == 0)
			System.out.println("** Danh sách rỗng **");
		else {
			System.out.print("* Nhập mã sản phẩm bạn muốn sửa *");
			System.out.println(
					"+----------------------------------- Danh mục sản phẩm -------------------------------------+");
			System.out.printf("%-15s%-20s%-15s%-10s%-10s\n", "mã sản phẩm", "tên", "loại", "số lượng", "đơn giá");
			for (int i = 0; i < n; i++) {
				dssp[i].xuat();
			}
			
			String masp = kt.kiemTraMa(); // KT xem ma nay co o trong mang ko?
			int vt = layVtSanPham(masp);
			if (vt == -1)
				System.out.print("* Mã sản phẩm bạn nhập không có *");
			else
				System.out.println(
						"+----------------------------------- Danh mục sản phẩm -------------------------------------+");
				System.out.printf("%-15s%-20s%-15s%-10s%-10s\n", "mã sản phẩm", "tên", "loại", "số lượng", "đơn giá");
					dssp[vt].xuat();
					dssp[vt] = MenuSua(dssp[vt]);
		}
		
	}

	public Sanpham MenuSua(Sanpham sp) {
		boolean flag = true;
		do {
			System.out.println("=========MENU=========");
			System.out.println("1. Mã sản phẩm");
			System.out.println("2. Tên sản phẩm");
			System.out.println("3. Loại");
			System.out.println("4. Số lượng");
			System.out.println("5. Đơn giả");
			System.out.println("6. Thoát");
			System.out.print("* Nhập lựa chọn của bạn *");

			switch (kt.kiemTraMenu(6)) {
			case 2: {
				System.out.print("* Nhập tên sản phẩm mới *");
				sp.setTensp(kt.kiemTraTen()); // Co the kt Ten truoc khi nhap
				break;
			}
			case 4: {
				System.out.print("* Nhập lại số lượng *");
				sp.setSoluong(kt.kiemTraTuoi()); // KT so . ( Nhap ki tu se bao sai)
				break;
			}
			case 3: {
				System.out.print("* Nhập lại loại *");
				sp.setLoai(kt.kiemTraTen());
				break;
			}
			case 1: {
				System.out.print("* Nhập lại mã sản phẩm *");
				sp.setMasp(kt.kiemTraMa());
				break;
			}
			case 5: {
				System.out.println("* Nhập lại đơn giá *");
				sp.setDongia(kt.kiemTraInt());
				break;
			}
			case 6: {
				this.ghiFile("");
				flag = false;
				System.out.println("* Bạn đã thoát *");
				break;
			}
			}
		} while (flag);

		return sp;
	}

	public int demDong(String name) {
		int dem = 0;
		try {
			Scanner scanFile = new Scanner(Paths.get(name));
			while (scanFile.hasNextLine()) {

				String row = scanFile.nextLine();
				if (row.equals("") != true) {
					dem++;
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
				pw.println(dssp[i].getMasp() + ";" + dssp[i].getTensp() + ";" + dssp[i].getLoai() + ";"
						+ dssp[i].getSoluong() + ";" + dssp[i].getDongia());
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
			this.n = demDong(name);
			Scanner scanFile = new Scanner(Paths.get(name));
			dssp = Arrays.copyOf(dssp, n);
			while (scanFile.hasNextLine()) {
				String row = scanFile.nextLine();
				if (row.equals("") == true) {
					break;
				}
				String[] data = row.split("\\;");
//					dssp[i++] = new Sanpham(data[0], data[1], data[2], Integer.parseInt(data[3]),
//							Integer.parseInt(data[4]));
				Sanpham temp = new Sanpham();
				temp.setMasp(data[0]);
				temp.setTensp(data[1]);
				temp.setLoai(data[2]);
				temp.setDongia(Integer.parseInt(data[3]));
				temp.setSoluong(Integer.parseInt(data[4]));

				dssp[i] = new Sanpham();
				this.dssp[i] = temp;
				i++;
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
