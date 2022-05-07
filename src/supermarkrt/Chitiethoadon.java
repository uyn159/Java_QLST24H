package supermarkrt;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Chitiethoadon extends Sanpham {
	private String mahd;
	private String status;
	private float x = this.getSoluong() * this.getDongia();
	private int thanhtien = (int) x;
	KiemLoi kt = new KiemLoi();

	public Chitiethoadon() {
		super();
		mahd = null;
		status = null;
		thanhtien = 0;
	}

	public Chitiethoadon(String mahd, String masp, String ten, String loai, int dongia, int soluong, int thanhtien,
			String status) {
		super(masp, ten, loai, dongia, soluong);
		this.mahd = mahd;
		this.status = status;
		this.thanhtien = thanhtien;
	}

	public String getMahd() {
		return mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}

	public void nhap() {
		System.out.println("Nhập mã hoá đơn");
		mahd = kt.kiemTraMa();
		super.nhap();
		System.out.println("Nhập trạng thái");
		status = kt.kiemTraStatus();
	}

	public void xuat() {
		System.out.printf("%-12s%-14s%-20s%-15s%-12d%-12d%-12s\n", this.getMahd(), this.getMasp(), this.getTensp(),
				this.getLoai(), this.getSoluong(),this.getDongia(), this.getThanhtien(), this.getStatus());
	}
}
