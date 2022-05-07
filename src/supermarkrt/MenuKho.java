package supermarkrt;

public class MenuKho {
	KiemLoi kt = new KiemLoi();
	Kho kho = new Kho();
	
	public void menu() {
		
		boolean flag1=true;
		while(flag1) {
			System.out.println("--------------------------------Kho-----------------------------");
			System.out.println("1.Thêm\n2.Xoá\n3.Sửa\n4.Tìm kiếm\n5.Sắp xếp\n6.Xuất\n7.Thoát");
			switch(kt.kiemTraMenu(7)) {
			case 1:{
				kho.them();
				kho.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\kho.txt");
				break;
			}
			case 2:{
				String masp;
				System.out.println("* Vui lòng nhập mã sản phẩm *");
				while(true) {
					masp=kt.kiemTraMa();
					if(kho.kiemTraSanPham(masp)==true) {
						kho.xoa(masp);
						break;
					}else {
						System.out.println("** Mã cần xoá không tồn tại. Nhập lại **");
					}
				}
				break;
			}
			case 3:{
				kho.Sua();
				break;
			}
			case 4:{
				System.out.println("1.Theo Tên\n2.Theo Mã\n3.Theo Loại");
				System.out.println("* Vui lòng ch�?n *");
				switch(kt.kiemTraMenu(3)) {
				case 1:{
					String ten;
					System.out.println("* Vui lòng nhập tên cần tìm *");
					while(true) {
						ten=kt.kiemTraTen();
						if(kho.kiemTraSanPhamTheoTen(ten)==true) {
							kho.timKiemTheoTen(ten);
							break;
						}else {
							System.out.println("** Tên cần tìm không tồn tại. Nhập lại **");
						}
					}
					break;
				}
				case 2:{
					String masp;
					System.out.println("* Vui lòng nhập mã cần tìm *");
					while(true) {
						masp=kt.kiemTraMa();
						if(kho.kiemTraSanPham(masp)==true) {
							kho.timKiemTheoMa(masp);
							break;
						}else {
							System.out.println("** Mã cần tìm không tồn tại. Nhập lại");
						}
					}
					break;
				}
				case 3:{
					String loai;
					System.out.println("* Vui lòng nhập mã cần tìm *");
					while(true) {
						loai=kt.kiemTraTen();
						if(kho.kiemTraSanPhamTheoLoai(loai)==true) {
							kho.timKiemTheoLoai(loai);;
							break;
						}else {
							System.out.println("** Loại cần tìm không tồn tại. Nhập lại **");
						}
					}
					break;
				}
				default:{
					System.out.println("** Mục bạn tìm không tồn tại **");
				}
				}
				break;
			}
			case 5:{
				System.out.println("1.Theo Tên\n2.Theo Mã");
				System.out.println("* Vui lòng ch�?n *");
				switch(kt.kiemTraMenu(2)) {
				case 1:{
					kho.sapXepTheoTen();
					break;
				}
				case 2:{
					kho.sapXepTheoMa();
					break;
				}
				default:{
					System.out.println("** Mục bạn tìm không tồn tại **");
				}
				}
				break;
			}
			case 6:{
				kho.xuat();
				break;
			}
			case 7:{
				kho.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\kho.txt");
				System.out.println("**Bạn đã thoát Kho**");
				flag1=false;
				break;
			}
			}
		}
	}
}
