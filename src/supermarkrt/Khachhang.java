package supermarkrt;

import java.util.Scanner;
import java.util.Formatter.*;
import java.io.PrintStream.*;

public class Khachhang extends Connguoi {
	String makh;
	Scanner sc = new Scanner(System.in);

	public Khachhang() {
		super();
		makh = null;
	}

	public Khachhang(String ten, String phai, String sdt, int tuoi, String phuong, String quan,
			String thanhpho, String makh) {
		super(ten, phai, sdt, tuoi, phuong, quan, thanhpho);
		this.makh = makh;
	}

	public Khachhang(String makh) {
		this.makh = makh;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public void nhap() {
		Dskhachhang kh = new Dskhachhang();
		
		System.out.println("nhập mã khách hàng:");
		while(true) {
			makh = sc.nextLine();
			if(kh.kiemTraKhachHang(this.makh)==false) {
				super.nhap();
				break;
			}else {
				System.out.println("** Mã đã có. Nhập lại **");
			}
		}
		
	}

	public void xuat() {
		System.out.printf("%-15s%-20s%-15s%-15s%-15s%-15s%-12s%-15s\n",this.getMakh(),this.getTen(),
				this.getDiachi().getPhuong(), this.getDiachi().getQuan(), this.getDiachi().getThanhpho(),
				 this.getPhai(), this.getSdt(), this.getTuoi());
		
	}
	public void xuatmavaten() {
		System.out.printf("%-15s%-20s\n",this.getMakh(),this.getTen());
		
	}
	
	@Override
	public void Hoatdong() {
		System.out.println("Mua hàng ....");
	}
}
