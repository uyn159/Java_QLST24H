package supermarkrt;

import java.util.Scanner;

public class MenuNhacung {
	KiemLoi kt = new KiemLoi();
	Scanner sc = new Scanner(System.in);
	Dsnhacungcap dsnc = new Dsnhacungcap();
	Nhacungcap[] dsncc = new Nhacungcap[1];
	private int n;

	public void menu() {
		  
		boolean flag3 = true;
		while (flag3) {
			System.out.println("----------------------------- Nhà cung -------------------------");
			System.out.println("1.Thêm\n2.Xoá\n3.Sửa\n4.Tìm kiếm\n5.Sắp xếp\n6.Xuất\n7.Thoát");
			switch (kt.kiemTraMenu(7)) {
			case 1: {
				dsnc.them();
				break;
			}
			case 2: {
				dsnc.xoa();
				break;
			}
			case 3: {
				dsnc.Sua();
				break;
			}
			case 4: {
				System.out.println("1.Theo Tên\n2.Theo Mã");
				System.out.println("** Vui lòng chọn **");
				switch(kt.kiemTraMenu(2)) {
				case 1:{
					dsnc.timKiemTheoTen();
					break;
				}
				case 2:{
					dsnc.timKiemTheoMa();
					break;
				}
				default:{
					System.out.println("** Không tìm thấy mục bạn cần **");
				}
				}
				break;
			}
			case 5: {
				System.out.println("1.Theo Tên\n2.Theo Mã");
				System.out.println("* Vui lòng chọn *");
				switch(kt.kiemTraMenu(2)) {
				case 1:{
					dsnc.sapXepTheoTen();
					break;
				}
				case 2:{
					dsnc.sapXepTheoMa();
					break;
				}
				default:{
					System.out.println("** Mục bạn tìm không tồn tại **\n");
				}
				}
				break;
			}
			case 6:{
				dsnc.xuat();
				break;
			}
			 
			case 7: {
				dsnc.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\nhacungcap.txt");
				System.out.println("** Bạn đã thoát Hoá đơn **\n");
				flag3 = false;
				break;
			}
			}
		}
	}
}
