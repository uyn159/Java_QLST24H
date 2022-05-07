package supermarkrt;

import java.io.IOException;
import java.util.Scanner;
import java.util.Formatter.*;
import java.io.PrintStream.*;

public class Main {

	public static void main(String[] args) throws IOException {
		KiemLoi kt = new KiemLoi();
		Scanner sc = new Scanner(System.in);
		boolean flag=true;
		while(flag){
			System.out.println("**=================================Menu=================================**");
			System.out.println("**				1.Kho					**");
			System.out.println("**				2.Nhân viên				**");
			System.out.println("**				3.Khách hàng				**");
			System.out.println("**				4.Sản phẩm				**");
			System.out.println("**				5.Hàng hoá				**");
			System.out.println("**				6.Nhà cung cấp				**");
			System.out.println("**				7.Thoát					**");
			System.out.println("**				Vui lòng nhập mã mà bạn muốn chọn	**");
			System.out.println("**======================================================================**");

			switch (kt.kiemTraMenu(7)) {
			case 1: {// begin of Kho
				MenuKho k = new MenuKho();
				k.menu();
				break;
			}//end of Kho
			case 2: {//begin of nhân vên
				MenuNhanvien mn = new MenuNhanvien();
				mn.menu();
				break;
			}// end of Nhân viên
			case 3: {//begin of khách hàng
				MenuKhachhang kh = new MenuKhachhang();
				kh.menu();
				break;
			}// end of Khách hàng
			case 4: {//begin of Sản phẩm
				MenuSanpham sp = new MenuSanpham();
				sp.menu();
				break;
			}//end of sản phẩm
			case 5: {//begin of Hoá đơn
				MenuHoadon hd = new MenuHoadon();
				hd.menu();
				break;
			}//end of Hoá đơn
			case 6:{//begin of Nhà cung cấp
				MenuNhacung ncc = new MenuNhacung();
				ncc.menu();
				break;
			}//end of Nhà cung cấp
			case 7: {
				System.out.println("**Bạn có muốn thoát không?** (y/n) ");
				if(kt.kiemTraYN().equals("n")==true)
					break;
				System.out.println("**Bạn chắc chắn muốn thoát không?** (y/n) ");
				if(kt.kiemTraYN().equals("n")==true)
					break;
				System.out.println("** Bạn đã ghi xuất file thành công **");
				System.out.println("** Bạn đã thoát thành công**");
				flag=false;
				break;
			}
			default:
				System.out.println("**	Tìm không thấy trong danh sách**");
			}
		}
		

		
		//Dskhachhang kh = new Dskhachhang();
		//kh.docFile("D:\\Eclipse\\do an\\khachhang.txt");
		//kh.nhap();
		//kh.xuat();
		//kh.ghiFile("D:\\Eclipse\\do an\\khachhang.txt");
	
		//String s = kt.kiemTraTen();
	}

}
