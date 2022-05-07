package supermarkrt;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;

public class Hoadon {
	private String mahd, ma;
	private Calendar tam = Calendar.getInstance();
	private String ngayrahd = tam.get(Calendar.YEAR) + "-" + (tam.get(Calendar.MONTH) + 1) + "-"
			+ tam.get(Calendar.DAY_OF_MONTH);
	Scanner sc = new Scanner(System.in);
	KiemLoi kt = new KiemLoi();
	Chitiethoadon cthd;

	public String getNgayrahd() {
		return ngayrahd;
	}

	public void setNgayrahd(String ngayrahd) {
		this.ngayrahd = ngayrahd;
	}

	public String getMahd() {
		return mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public Hoadon() {
		mahd = null;
		ma = null;
		ngayrahd = null;
	}

	public Hoadon(String mahd, String ma, String ngayrahd) {
		this.mahd = mahd;
		this.ma = ma;
		this.ngayrahd = ngayrahd;
	}

	public void nhap() {
		Dshoadon hd = new Dshoadon();
		System.out.println("nhập mã hoá đơn");
		while(true) {
			mahd = kt.kiemTraMa();
			if(hd.kiemTraHoaDon(this.mahd)==false) {
				System.out.println("nhập mã đối tác");
				ma = kt.kiemTraMa();
				ngayrahd = tam.get(Calendar.YEAR) + "-" + (tam.get(Calendar.MONTH) + 1) + "-"
						+ tam.get(Calendar.DAY_OF_MONTH);
				break;
			}else {
				System.out.println("** Mã đã có. Nhập lại **");
			}
		}
	}

	public void xuat() {
//		System.out.println("mã đối tác: " + ma);
//		System.out.println("mã hoá đơn: " + mahd);
//		System.out.println("ngày ra hoá đon: " + ngayrahd);
		System.out.printf("%-12s%-12s%-20s\n", this.getMahd(), this.getMa(), this.getNgayrahd());

	}
	public void xuatma() {

		System.out.printf("%-12s\n", this.getMahd());

	}
	public void xuatmavamnc() {

		System.out.printf("%-12s%-12s\n", this.getMahd(),this.getMa());

	}



//	 public boolean kiemTraDoiTac(String ma) {
//		 if(this.getMa().equals(ma)==true)
//			 return true;
//		 else
//			 return false;
//	 }
}