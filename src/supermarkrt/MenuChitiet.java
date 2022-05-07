package supermarkrt;

public class MenuChitiet {
	KiemLoi kt = new KiemLoi();
	private boolean flag;
	Dschitiet dsct = new Dschitiet();
	
	public void menu() {
		flag = true;
		System.out.println("1.Xuất\n4.Thêm\n6.Thoát");
		System.out.println("* Vui lòng chọn *");
		while (flag) {
			switch (kt.kiemTraMenu(4)) {
			case 1: {
				dsct.xuat();
				break;
			}
			case 2: {
				String mahd;
				System.out.println("* Vui lòng nhập mã hoá đơn *");
				while (true) {
					mahd = kt.kiemTraMa();
					if (dsct.kiemTraHoaDon(mahd) == true) {
						dsct.tinhSoLuongNhap(mahd,"1");
						break;
					} else {
						System.out.println("** Mã hoá đơn không tồn tại. Nhập lại **");
					}
				}
				break;
			}
			case 3: {
				String mahd;
				System.out.println("* Vui lòng nhập mã hoá đơn *");
				while (true) {
					mahd = kt.kiemTraMa();
					if (dsct.kiemTraHoaDon(mahd) == true) {
						dsct.tinhSoLuongXuat(mahd,"0");
						break;
					} else {
						System.out.println("** Mã hoá đơn không tồn tại. Nhập lại **");
					}
				}
				break;
			}
			case 4: {
				dsct.them();
			}
			case 6: {
				flag = false;
				System.out.println("** Bạn đã thoát **");
				break;
			}
			default: {
				System.out.println("** Mục bạn tìm không tồn tại **");
			}
			}
		}
	}

}
