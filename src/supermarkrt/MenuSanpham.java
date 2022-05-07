package supermarkrt;

public class MenuSanpham {
	KiemLoi kt = new KiemLoi();
	Dssanpham dssp = new Dssanpham();

	public void menu() {
		
		boolean flag4 = true;
		while (flag4) {
			System.out.println("-------------------------- Sản phẩm ------------------------------");
			System.out.println("1.Thêm\n2.Xoá\n3.Sửa\n4.Tìm kiếm\n5.Sắp xếp\n6.Sửa\n7.Xuất\n8.Thoát");
			switch (kt.kiemTraMenu(8)) {
			case 1: {
				dssp.them();
				dssp.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\sanpham.txt");
				break;
			}
			case 2: {
				dssp.xoa();
				break;
			}
			case 3: {
				break;
			}
			case 4: {
				System.out.println("1.Theo Tên\n2.Theo Mã\n3.Theo Loại");
				System.out.println("* Vui lòng chọn *");
				switch (kt.kiemTraMenu(3)) {
				case 1: {
					dssp.timKiemTheoTen();
					break;
				}
				case 2: {
					dssp.timKiemTheoMa();
					break;
				}
				case 3: {
					dssp.timKiemTheoLoai();
					break;
				}
				default: {
					System.out.println("** Mục bạn tìm không tồn tại **");
				}
				}
				break;
			}
			case 5: {
				System.out.println("1.Theo Tên\n2.Theo Mã");
				System.out.println("* Vui lòng chọn *");
				switch (kt.kiemTraMenu(2)) {
				case 1: {
					dssp.sapXepTheoTen();
					break;
				}
				case 2: {
					dssp.sapXepTheoMa();
					break;
				}
				default: {
					System.out.println("** Mục bạn chọn không tồn tại **");
				}
				}
				break;
			}
			case 6:{
				dssp.Sua();
				break;
			}
			case 7: {
				dssp.xuat();
				break;
			}
			case 8: {
				dssp.ghiFile("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\src\\sanpham.txt");
				System.out.println("** Bạn đã thoát Sản phẩm **");
				flag4 = false;
				break;
			}
			}
		}
	}
}
