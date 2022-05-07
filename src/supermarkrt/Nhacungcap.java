package supermarkrt;

import java.util.Scanner;

public class Nhacungcap {
	private String macc, ten, sdt;
	private Diachi diachi;
	Scanner sc = new Scanner(System.in);
	KiemLoi kt = new KiemLoi();

	public String getMacc() {
		return macc;
	}

	public void setMacc(String macc) {
		this.macc = macc;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Diachi getDiachi() {
		return diachi;
	}

	public void setDiachi(Diachi diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Nhacungcap() {
		macc = null;
		ten = null;
		diachi = new Diachi();
		sdt = null;
	}

	public Nhacungcap(String macc, String ten, String phuong, String quan, String thanhpho, String sdt) {
		this.macc = macc;
		this.ten = ten;
		diachi = new Diachi(phuong, quan, thanhpho);
		this.sdt = sdt;
	}

	public void nhap() {
		Dsnhacungcap nc = new Dsnhacungcap();
		System.out.println("Nhập mã nhà cung cấp");
		while (true) {
			this.macc = kt.kiemTraMa();
			if (nc.kiemTraNhaCung(this.macc) == false) {
				System.out.println("Nhập tên nhà cung cấp");
				this.ten = kt.kiemTraTen();
				System.out.println("Nhập số điện thoại");
				sdt = kt.kiemTraSdt();
				System.out.println("Nhập địa chỉ");
				diachi.nhap();
				break;
			} else {
				System.out.println("** Mã đã có. Nhập lại **");
			}
		}

	}

	public void xuat() {
//		System.out.println("ma nha cung cap: " + this.macc);
//		System.out.println("ten nha cung cap: " + this.ten);
//		diachi.xuat();
//		System.out.println("số điện thoại: "+sdt);
		System.out.printf("%-12s%-20s%-15s%-15s%-15s%-12s\n", this.getMacc(), this.getTen(), this.getDiachi().getPhuong(),
				this.getDiachi().getQuan(), this.getDiachi().getThanhpho(), this.getSdt());
	}
	public void xuatmavaten(){
		System.out.printf("%-12s%-20s\n", this.getMacc(), this.getTen());
	}
}
