package supermarkrt;

import java.util.Scanner;

abstract public class Connguoi {
	private String ten, phai, sdt;
	private int tuoi;
	private Diachi diachi;
	public static int  dem = 0;
	Scanner s = new Scanner(System.in);
	KiemLoi kt = new KiemLoi();

	public Connguoi() {
		this.ten = null;
		this.tuoi = 0;
		this.phai = null;
		this.diachi = new Diachi();
		this.sdt = null;
		dem++;
	}

	public Connguoi(String ten, String phai, String sdt, int tuoi, String phuong, String quan,
			String thanhpho) {
		this.ten = ten;
		this.phai = phai;
		// this.diachi = diachi;
		this.sdt = sdt;
		this.tuoi = tuoi;
		this.diachi= new Diachi(phuong,quan,thanhpho);
		dem++;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}


	public String getPhai() {
		return phai;
	}

	public void setPhai(String phai) {
		this.phai = phai;
	}

	
	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public void nhap() {
		System.out.println("Nhập tên:");
		ten = kt.kiemTraTen();
		System.out.println("Nhập địa chỉ: ");
		// diachi = s.nextLine();
		diachi.nhap();
		System.out.println("Nhập phái:");
		phai = kt.ktPhai();
		System.out.println("Nhập số điện thoại:");
		sdt = kt.kiemTraSdt();
		System.out.println("Nhập tuổi:");
		tuoi = kt.kiemTraTuoi();
	}

	public void xuat() {
		
//		System.out.println("tên: " + ten);
//		diachi.xuat();
//		System.out.println("ngày sinh: " + ngaysinh);
//		System.out.println("phái: " + phai);
//		System.out.println("số điện thoại: " + sdt);
//		System.out.println("tuổi: " + tuoi);
		System.out.printf("%-12s%-12s%-12d", ten,sdt,tuoi);
		diachi.xuat();
		System.out.println();
	}
	
	public Diachi getDiachi() {
		return diachi;
	}

	public void setDiachi(Diachi diachi) {
		this.diachi = diachi;
	}

	abstract public void Hoatdong();
}
