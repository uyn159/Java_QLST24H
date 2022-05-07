package supermarkrt;

import java.util.Scanner;

public class Diachi {
	private String thanhpho, phuong, quan;
	Scanner sc = new Scanner(System.in);
	KiemLoi kt = new KiemLoi();

	public Diachi() {
		thanhpho = null;
		phuong = null;
		quan = null;
	}

	public Diachi(String phuong, String quan, String thanhpho) {
		this.thanhpho = thanhpho;
		this.phuong = phuong;
		this.quan = quan;
	}

	public String getThanhpho() {
		return thanhpho;
	}

	public void setThanhpho(String thanhpho) {
		this.thanhpho = thanhpho;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public void nhap() {
		System.out.println("nhập phường");
		phuong=kt.kiemTraTen();
		System.out.println("nhập quận");
		quan=kt.kiemTraTen();
		System.out.println("nhập thành phố");
		thanhpho=kt.kiemTraTen();
	}
	
	public void xuat() {
		System.out.printf("%-12s%-12s%-12s", this.phuong,this.quan, this.thanhpho);
	}
}
