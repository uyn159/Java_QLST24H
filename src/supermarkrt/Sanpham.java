/*chua co Constructor*/
package supermarkrt;

import java.util.Scanner;

public class Sanpham {
	private String masp, tensp, loai;
	private int soluong;
	private int dongia;
	Scanner sc = new Scanner(System.in);
	KiemLoi kt = new KiemLoi();

	public Sanpham() {
		masp = null;
		tensp = null;
		loai = null;
		soluong = 0;
		dongia = 0;
	}

	public Sanpham(String masp, String tensp, String loai, int soluong, int dongia) {
		this.masp = masp;
		this.tensp = tensp;
		this.loai = loai;
		this.soluong = soluong;
		this.dongia = dongia;
	}

	public int getDongia() {
		return dongia;
	}

	public void setDongia(int dongia) {
		this.dongia = dongia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public void nhap() {
		Dssanpham sp = new Dssanpham();
		System.out.println("nhập mã sản phẩm");
		
		while(true) {
			masp = kt.kiemTraMa();
		
			if(sp.kiemTraSanPham(this.masp)==false) {
				System.out.println("nhập tên sản phẩm");
				tensp = kt.kiemTraTen();
				System.out.println("nhập loại sản phẩm");
				loai = kt.kiemTraTen();
				System.out.println("nhập số lượng của " + tensp);
				soluong = kt.kiemTraInt();
				System.out.println("nhập đơn giá sản phẩm");
				dongia = kt.kiemTraInt();
				break;
			}else {
				System.out.println("** Mã đã có. Nhập lại **");
			}
		}
	}

	public void xuat() {
		System.out.printf("%-15s%-20s%-15s%-10d%-10d\n", this.getMasp(), this.getTensp(), this.getLoai(),
				this.getSoluong(), this.getDongia());
	}
	public void xuatmavaten() {
		System.out.printf("%-15s%-20s\n", this.getMasp(), this.getTensp());
	}
	public void xuatloai() {
		System.out.printf("%-15s\n", this.getLoai());
	}

	public void kiemTraKho(String masp) {
		if (this.getMasp().equals(masp) == true)
			System.out.println("*Trong kho có sản phẩm này.*");
		else
			System.out.println("*Trong kho không có sản phẩm này!!!- Sản phẩm LẬU*");
	}
}
