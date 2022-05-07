package supermarkrt;

import java.util.Scanner;

public class MenuNhanvien {
	KiemLoi kt = new KiemLoi();
	Dsnhanvien dsnv = new Dsnhanvien();

	public void menu() {
		
		boolean flag2 = true;
		while (flag2) {
			System.out.println("----------------------------Nhân viên--------------------------");
			System.out.println("1.Thêm\n2.Xoá\n3.Sửa\n4.Tìm kiếm\n5.Xuất\n6.Thoát");
			switch (kt.kiemTraMenu(6)) {
			case 1: {
				dsnv.them();
				dsnv.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhanvien.txt");
				break;
			}
			case 2: {
				dsnv.xoa();
				break;
			}
			case 3: {
				dsnv.Sua();
				break;
			}
			case 4: {
				System.out.println("1.Theo Tên\n2.Theo Mã");
				switch (kt.kiemTraMenu(2)) {
				case 1: {
					dsnv.timKiemTheoTen();
					break;
				}
				case 2: {
					dsnv.timKiemTheoMa();
					break;
				}
				default: {
					System.out.println("** Không có mục bạn cần tìm **");
				}
				}
				break;
			}
			case 5: {
				dsnv.xuat();
				break;
			}
			case 6: {
				dsnv.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhanvien.txt");
				System.out.println("** Bạn đã thoát **");
				flag2 = false;
				break;
			}
			}
		}
	}
}
