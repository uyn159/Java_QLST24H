package supermarkrt;

public class MenuHoadon {
	KiemLoi kt = new KiemLoi();
	boolean flag6;
	Dshoadon dshd = new Dshoadon();
	
	public void menu() {
		dshd.docFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\hoadon.txt");
		flag6 = true;
		while(flag6) {
			System.out.println("------------------------------------- Hoá đơn -----------------------------");
			System.out.println("1.Thêm\n2.Xoá\n3.Tìm kiếm\n4.Xuất\n5.Chi tiết hoá đơn\n6.Thoát");
			switch(kt.kiemTraMenu(7)) {
			case 1:{
				dshd.them();
				break;
			}
			case 2:{
				dshd.xoa();
				break;
			}
			case 3:{
				dshd.timKiemTheoMa();
				break;
			}
			case 4:{
				System.out.println("1.Hết\n2.Cá nhân");
				System.out.println("* Vui lòng chọn");
				switch(kt.kiemTraMenu(2)) {
				case 1:{
					dshd.xuat();
					break;
				}
				case 2:{
					dshd.xuatdt();
					break;
				}
				default:{
					System.out.println("** Không tìm thấy mục bạn cần **");
				}
				}
				dshd.xuat();
				break;
			}
			case 5:{
				MenuChitiet ct = new MenuChitiet();
				ct.menu();
				break;
			}
			case 6:{
				dshd.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\hoadon.txt");
				System.out.println("** Bạn đã thoát Hoá đơn **");
				flag6=false;
				break;
			}
			default:{
				System.out.println("** Mục bạn tìm không tồn tại **");
			}
			}
		}
	}
}
