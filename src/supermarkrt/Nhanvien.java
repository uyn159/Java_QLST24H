package supermarkrt;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Nhanvien extends Connguoi {
	String manv, maql;
	float luong;
	public static int dem = 0;
	final static float hesoluong = 3.0f;
	Scanner s = new Scanner(System.in);
	KiemLoi kt = new KiemLoi();

	public Nhanvien() {
		super();
		manv = null;
		maql = null;
		luong = 0.0f;
		dem++;
	}

	public Nhanvien(String ten, String phai, String sdt, int tuoi, String phuong, String quan, String thanhpho,
			String manv, String maql, float luong) {
		super(ten, phai, sdt, tuoi, phuong, quan, thanhpho);
		this.manv = manv;
		this.maql = maql;
		this.luong = luong;
		dem++;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public String getMaql() {
		return maql;
	}

	public void setMaql(String maql) {
		this.maql = maql;
	}

	public void nhap() {
		Dsnhanvien nv = new Dsnhanvien();
		System.out.println("nhập mã nhân viên:");
		while(true) {
			manv = kt.kiemTraMa();
			if(nv.kiemTraNhanVien(this.manv)==false) {
				System.out.println("nhập mã quản lý:");	
				maql = kt.kiemTraMa();
				System.out.println("nhập lương nhân viên:");
				luong = kt.kiemTraFloat();
				super.nhap();
				break;
			}else {
				System.out.println("** Mã đã có. Nhập lại **");
			}
		}
	}

	public void xuat() {
//		System.out.println("mã nhân viên:" + this.manv);
//		super.xuat();
//		System.out.println("mã quản lý:" + this.maql);
//		System.out.println("lương nhân viên:" + this.luong);
		
		System.out.printf("%-15s%-20s%-12s%-15s%-15s%-15s%-15s%-12s%-7s%-5s\n", this.getManv(), this.getTen(),
				this.getMaql(), this.getDiachi().getPhuong(), this.getDiachi().getQuan(), this.getDiachi().getThanhpho(),
				this.getSdt(), this.getPhai(), this.getTuoi(),this.getLuong());
	}
	public void xuatmavaten() {
		System.out.printf("%-15s%-20s\n", this.getManv(), this.getTen());
	}
	@Override
	public void Hoatdong() {
		// TODO Auto-generated method stub
		System.out.println("Bán hàng....");

	}

	public double tinhLuong() {
		return getLuong() + getLuong() * hesoluong;
	}
}
