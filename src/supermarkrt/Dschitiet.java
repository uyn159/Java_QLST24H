package supermarkrt;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Dschitiet {
	private Chitiethoadon[] chitiet = new Chitiethoadon[1];
	private int n;
	Scanner sc = new Scanner(System.in);
	KiemLoi kt = new KiemLoi();

	public Dschitiet() { // Constructor
		this.docFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\chitiet.txt");
	}

	public Dschitiet(Chitiethoadon[] chitiet) { // Constructor
		this.chitiet = chitiet;
	}

	public Chitiethoadon[] getChitiet() { // Getter
		return chitiet;
	}

	public void setChitiet(Chitiethoadon[] chitiet) { // Setter
		this.chitiet = chitiet;
	}

	public void nhap() {
		System.out.println("* nhập số lượng sản phẩm có trong hóa đơn *");
		n = Integer.parseInt(sc.nextLine());
		chitiet = Arrays.copyOf(chitiet, n);
		chitiet = new Chitiethoadon[n];
		for (int i = 0; i < n; i++) {
			chitiet[i] = new Chitiethoadon();
			chitiet[i].nhap();
		}
	}

	public void xuat() {
		if (n == 0)
			System.out.println("** Danh sách không có chi tiết hoá đơn **");
		else {
			System.out.println("* Danh sách chi tiết hoá đơn trong hóa đơn *");
			System.out.println("+-------------------------------------------------------------------+");
			System.out.printf("%-12s%-14s%-20s%-15s%-10s%-12s%-12s\n", "Mã hoá đơn", "Mã sản phẩm", "Tên sản phẩm",
					"Loại", "Số lượng", "Thành tiền", "Trạng thái");
			for (int i = 0; i < n; i++) {
				chitiet[i].xuat();
			}
		}
	}

	public void xuat(String mahd) {
		System.out.println("* Danh sách chi tiết hoá đơn trong hóa đơn *");
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-12s%-14s%-20s%-15s%-10s%-12s%-12s", "Mã hoá đơn", "Mã sản phẩm", "Tên sản phẩm", "Loại",
				"Số lượng", "Thành tiền", "Trạng thái");
		for (int i = 0; i < n; i++) {
			if (chitiet[i].getMahd().equals(mahd) == true) {
				chitiet[i].xuat();
			}
		}
	}

	public Sanpham laySanPham(String masp) {
		for (int i = 0; i < n; i++) {
			if (chitiet[i].getMasp().equals(masp) == true) {
				return chitiet[i];
			}
		}
		return null;
	}

	public Sanpham layPhanTu(int vt) {
		return chitiet[vt];
	}

	public int layVtSanpham(String masp) {
		for (int i = 0; i < n; i++) {
			if (chitiet[i].getMasp().equals(masp) == true) {
				return i;
			}
		}
		return -1;
	}

	public void tinhSoLuongNhap(String mahd, String status) {
		Kho kho = new Kho();

		for (int i = 0; i < n; i++) {
			if (kho.kiemTraSanPham(chitiet[i].getMasp()) == true && chitiet[i].getStatus().equals("1") == true) { // ktra
																													// xem
																													// coi
																													// sản
																													// phẩm
																													// có
																													// trong
																													// kho
																													// ko
																													// và
																													// trạng
																													// thái
																													// có
																													// phải
																													// là
																													// nhập
																													// hàng
																													// ko
				kho.tangSoLuong(chitiet[i].getSoluong(), chitiet[i].getMasp());
			} else if (chitiet[i].getStatus().equals("1") == true) { // Nếu ko thì h�?i ngư�?i dùng có muốn thêm không
				/* Kiem tra trạng thái lần nữa để xem có phải đây là sản phẩm để nhập */
				System.out.println("** Bạn có muốn thêm sản phẩm này không ? (y/n)");
				String rep = kt.kiemTraYN();
				if (kt.equals("y") == true) { // Nếu ng dùng thêm
					kho.them(chitiet[i].getMasp(), chitiet[i].getSoluong(), chitiet[i].getTensp(), chitiet[i].getLoai(),
							chitiet[i].getDongia());
				}
			}
		}
	}

	public void tinhSoLuongXuat(String mahd, String status) {
		Dssanpham sp = new Dssanpham();

		for (int i = 0; i < n; i++) {
			if (sp.kiemTraSanPham(chitiet[i].getMasp()) == true && chitiet[i].getStatus().equals("0") == true) { // ktra
																													// xem
																													// coi
																													// sản
																													// phẩm
																													// có
																													// trong
																													// kho
																													// ko
																													// và
																													// trạng
																													// thái
																													// có
																													// phải
																													// là
																													// nhập
																													// hàng
																													// ko
				sp.giamSoLuong(chitiet[i].getSoluong(), chitiet[i].getMasp());
			} else if (chitiet[i].getStatus().equals("0") == true) { // Nếu ko thì h�?i ngư�?i dùng có muốn thêm không
				/* kiểm tra lần nữa để xem sản phẩm này có phải là để bán ra ko */
				System.out.println("** Bạn có muốn thêm sản phẩm này không ? (y/n)");
				String rep = kt.kiemTraYN();
				if (kt.equals("y") == true) { // Nếu ng dùng thêm
					sp.them(chitiet[i].getMasp(), chitiet[i].getTensp(), chitiet[i].getLoai(), chitiet[i].getSoluong(),
							chitiet[i].getDongia());
				}
			}
		}
	}

	public boolean kiemTraHoaDon(String mahd) {
		for (int i = 0; i < n; i++) {
			if (chitiet[i].getMahd().equals(mahd) == true) {
				return true;
			}
		}
		return false;
	}

	public void timKiemTheoMa(String mahd) {
		int dem = 0;
		for (int i = 0; i < n; i++) {
			if (chitiet[i].getMahd().equals(mahd) == true) {
				dem++;
				chitiet[i].xuat();
			}
		}
		if (dem == 0) {
			System.out.println("* Tìm không thấy !!! *");
		}
	}

	public void timKiemSpTheoMa(String masp) {
		int dem = 0;
		for (int i = 0; i < n; i++) {
			if (chitiet[i].getMasp().equals(masp) == true) {
				dem++;
				chitiet[i].xuat();
			}
		}
		if (dem == 0)
			System.out.println("* Tìm không thấy!!! *");
	}

	public void xoa(String masp) {
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (chitiet[i].getMasp().equals(masp) == false)
				chitiet[k++] = chitiet[i];
		}
		n--;
	}

	public void them() {
		System.out.println("* Thêm bao nhiêu chi tiết? *");
		int m = n;
		int soluong;
		soluong = Integer.parseInt(sc.nextLine());
		this.n = n + soluong;
		chitiet = Arrays.copyOf(chitiet, n);
		for (int i = m; i < n; i++) {
			chitiet[i] = new Chitiethoadon();
			chitiet[i].nhap();
		}
		this.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\chitiet.txt");
	}

	public int tongThanhTien() {
		int tong = 0;
		for (int i = 0; i < n; i++) {
			tong += chitiet[i].getSoluong() * chitiet[i].getDongia();
		}
		return tong;
	}

//	public boolean kiemTraHoaDon(String mahd) {
//		if (this.mahd.equals(mahd) == true) {
//			return true;
//		}
//		return false;
//	}
	public void Sua() {
		System.out.print("* Nhập mã sản phẩm bạn muốn sửa *");
		String masp = kt.kiemTraMa(); // KT xem ma nay co o trong mang ko?
		int vt = layVtSanpham(masp);
		if (vt == -1)
			System.out.print("* Mã sản phẩm bạn nhập không có *");
		else
			chitiet[vt] = MenuSua(chitiet[vt]);
	}

	public Chitiethoadon MenuSua(Chitiethoadon sp) {
		boolean flag = true;
		do {
			System.out.println("=========MENU=========");
			System.out.println("1. Mã sản phẩm");
			System.out.println("2. Tên sản phẩm");
			System.out.println("3. Loại");
			System.out.println("4. Số lượng");
			System.out.println("5. Đơn giá");
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
				System.out.println("* Bạn đã thêm thành công *");
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
			System.out.println("** Lỗi file **");
		}
		return dem;
	}

	public void ghiFile(String name) {
		try {
			FileWriter fw = new FileWriter(name);
			PrintWriter pw = new PrintWriter(fw);
			for (int i = 0; i < n; i++) {
				pw.println(chitiet[i].getMahd() + ";"+ chitiet[i].getMasp() + ";" + chitiet[i].getTensp() + ";" + chitiet[i].getLoai() + ";"
						+ chitiet[i].getSoluong() + ";" + chitiet[i].getDongia());
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
			chitiet = Arrays.copyOf(chitiet, n);
			while (scanFile.hasNextLine()) {
				String row = scanFile.nextLine();
				if (row.equals("") != true) {
					String[] data = row.split("\\;");

					Chitiethoadon temp = new Chitiethoadon();
					temp.setMahd(data[0]);
					temp.setMasp(data[1]);
					temp.setTensp(data[2]);
					temp.setLoai(data[3]);
					temp.setSoluong(Integer.parseInt(data[4]));
					temp.setDongia(Integer.parseInt(data[5]));
					temp.setThanhtien(Integer.parseInt(data[6]));
					
					chitiet[i] = new Chitiethoadon();
					this.chitiet[i] = temp;
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("** Lỗi file **");
		}
	}
}
