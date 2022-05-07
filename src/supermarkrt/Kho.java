package supermarkrt;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Kho implements Mang {
	private Sanpham[] kho = new Sanpham[1];
	private int n;
	Scanner sc = new Scanner(System.in);
	KiemLoi kt = new KiemLoi();

	public Kho() {
		this.docFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\kho.txt");
	}

	public Kho(Sanpham[] kho) {
		this.kho = kho;
	}

	public Sanpham[] getKho() {
		return kho;
	}

	public void setKho(Sanpham[] kho) {
		this.kho = kho;
	}

	public void nhap() {
		System.out.println("* Nhập số lượng phần tử cho Kho *");
		n = Integer.parseInt(sc.nextLine());
		kho = Arrays.copyOf(kho, n);
		kho = new Sanpham[n];
		for (int i = 0; i < n; i++) {
			kho[i] = new Sanpham();
			kho[i].nhap();
		}
	}

	public void xuat() {
		if (n == 0)
			System.out.println("** Kho rỗng **");
		else {
			System.out.println(
					"+----------------------------------- Danh mục sản phẩm trong Kho -------------------------------------+");
			System.out.printf("%-15s%-20s%-15s%-10s%-10s\n", "mã sản phẩm", "tên", "loại", "số lượng", "đơn giá");
			for (int i = 0; i < n; i++) {
				kho[i].xuat();
			}
		}
		System.out.println();
	}

	public Sanpham laySanPham(String masp) {
		for (int i = 0; i < n; i++) {
			if (kho[i].getMasp().equals(masp) == true) {
				return kho[i];
			}
		}
		return null;
	}

	public int layVtSanPham(String masp) {
		for (int i = 0; i < n; i++) {
			if (kho[i].getMasp().equals(masp) == true) {
				return i;
			}
		}
		return -1;
	}

	public boolean kiemTraSanPham(String masp) {
		for (int i = 0; i < n; i++) {
			if (kho[i].getMasp().equals(masp) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean kiemTraSanPhamTheoTen(String ten) {
		for (int i = 0; i < n; i++) {
			if (kho[i].getTensp().equals(ten) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean kiemTraSanPhamTheoLoai(String loai) {
		for (int i = 0; i < n; i++) {
			if (kho[i].getLoai().equals(loai) == true) {
				return true;
			}
		}
		return false;
	}

	public void timKiemTheoMa(String masp) {
		int dem = 0;
		for (int i = 0; i < n; i++) {
			if (kho[i].getMasp().equals(masp) == true) {
				dem++;
				kho[i].xuat();
			}
		}
		if (dem == 0)
			System.out.println("* Tìm không thấy!!! *");
	}

	public void timKiemTheoTen(String ten) {
		int dem = 0;
		for (int i = 0; i < n; i++) {
			if (kho[i].getTensp().equals(ten) == true) {
				dem++;
				kho[i].xuat();
			}
		}
		if (dem == 0)
			System.out.println("* Tìm không thấy!!! *");
	}

	public void sapXepTheoMa() {
		Sanpham temp = kho[0];
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (kho[j].getMasp().compareTo(kho[i].getMasp()) < 0) {
					temp = kho[i];
					kho[i] = kho[j];
					kho[j] = temp;
				}
			}
	}

	public void sapXepTheoTen() {
		Sanpham temp = kho[0];
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (kho[j].getTensp().compareTo(kho[i].getTensp()) < 0) {
					temp = kho[i];
					kho[i] = kho[j];
					kho[j] = temp;
				}
			}
	}

	public void xoa(String masp) {
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (kho[i].getMasp().equals(masp) == false)
				kho[k++] = kho[i];
		}
		n--;
	}

	public void them() {
		System.out.println("* Thêm bao nhiêu sản phẩm ? *");
		int m = n;
		int soluong;
		soluong = kt.kiemTraInt();
		this.n = n + soluong;
		kho = Arrays.copyOf(kho, n);
		for (int i = m; i < n; i++) {
			kho[i] = new Sanpham();
			kho[i].nhap();
		}
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\kho.txt");
	}

	public void them(String masp, int soluong, String tensp, String loai, int dongia) {
		int m = n;
		this.n = n + 1;
		kho = Arrays.copyOf(kho, n);
		for (int i = m; i < n; i++) {
			kho[i] = new Sanpham(masp, tensp, loai, soluong, dongia);
		}
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\kho.txt");
	}

	public void timKiemTheoLoai(String loai) {
		int dem = 0;
		for (int i = 0; i < n; i++) {
			if (kho[i].getLoai().equalsIgnoreCase(loai) == true) {
				dem++;
				kho[i].xuat();
			}
		}
		if (dem == 0)
			System.out.println("* Tìm không thấy!!! *");
	}

	public void tangSoLuong(int soluong, String masp) {
		int vt = this.layVtSanPham(masp);
		kho[vt].setSoluong(kho[vt].getSoluong() + soluong);
	}

	public void Sua() {
		System.out.print("* Nhập mã sản phẩm bạn muốn sửa *");
		String masp = kt.kiemTraMa(); // KT xem ma nay co o trong mang ko?
		int vt = layVtSanPham(masp);
		if (vt == -1)
			System.out.print("* Mã sản phẩm bạn nhập không có *");
		else
			kho[vt] = MenuSua(kho[vt]);
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
			System.out.print("* Nhập lựa ch�?n của bạn *");

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
				if (row.length() != 1) {
					dem++;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("** Lỗi file **");
		}
		return dem;
	}

	public void ghiFile(String name) {
		try {
			FileWriter fw = new FileWriter(name);
			PrintWriter pw = new PrintWriter(fw);
			for (int i = 0; i < n; i++) {
				pw.println(kho[i].getMasp() + ";" + kho[i].getTensp() + ";" + kho[i].getLoai() + ";"
						+ kho[i].getSoluong() + ";" + kho[i].getDongia());
			}
			fw.close();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("** Lỗi file **");
		}
	}

	public void docFile(String name) {
		try {
			int i = 0;
			this.n = demDong(name);
			Scanner scanFile = new Scanner(Paths.get(name));
			kho = Arrays.copyOf(kho, n);
			while (scanFile.hasNextLine()) {
				String row = scanFile.nextLine();
				if (row.equals("") != true) {
					String[] data = row.split("\\;");
//					kho[i++] = new Sanpham(data[0], data[1], data[2], Integer.parseInt(data[3]),
//							Integer.parseInt(data[4]));
					Sanpham temp = new Sanpham();
					temp.setMasp(data[0]);
					temp.setTensp(data[1]);
					temp.setLoai(data[2]);
					temp.setDongia(Integer.parseInt(data[3]));
					temp.setSoluong(Integer.parseInt(data[4]));

					kho[i] = new Sanpham();
					this.kho[i] = temp;
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("** Lỗi file **");
		}
	}
}
