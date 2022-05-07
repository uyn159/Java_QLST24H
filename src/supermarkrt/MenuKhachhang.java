package supermarkrt;

import java.util.Scanner;

public class MenuKhachhang {
	KiemLoi kt = new KiemLoi();
	Scanner sc = new Scanner(System.in);
	Dskhachhang dskh = new Dskhachhang();
	
	public void menu() {
		
		boolean flag3 = true;
		while (flag3) {
			System.out.println("-----------------------------Khách hàng-------------------------");
			System.out.println("1.Thêm\n2.Xoá\n3.Sửa\n4.Tìm kiếm\n5.Sắp xếp\n6.Xuất\n7.Thoát");
			switch (kt.kiemTraMenu(7)) {
			case 1: {
				dskh.them();
				dskh.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\khachhang.txt");
				break;
			}
			case 2: {
				dskh.xoa();
				break;
			}
			case 3: {
				dskh.Sua();
				break;
			}
			case 4: {
				System.out.println("1.Theo Tên\n2.Theo Mã");
				System.out.println("** Vui lòng chọn **");
				switch(kt.kiemTraMenu(2)) {
				case 1:{
					dskh.timKiemTheoTen();
					break;
				}
				case 2:{
					
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
					dskh.sapXepTheoTen();
					break;
				}
				case 2:{
					dskh.sapXepTheoMa();
					break;
				}
				default:{
					System.out.println("** Mục bạn tìm không tồn tại **");
				}
				}
				break;
			}
			case 6:{
				dskh.xuat();
				break;
			}
			case 7: {
				dskh.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\khachhang.txt");
				System.out.println("**Bạn đã thoát**");
				flag3 = false;
				break;
			}
			}
		}
	}
}
