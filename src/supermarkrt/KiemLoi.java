package supermarkrt;

import java.util.Scanner;
import java.io.IOException;
import java.lang.*;
import java.text.SimpleDateFormat;

public class KiemLoi {
	Scanner sc = new Scanner(System.in);

	public String kiemTraYN() {
		String s;
		while (true) {
			String regex = "[yn]";
			s = sc.nextLine();
			// boolean check;
			if (s.matches(regex) == true && s.equals("") == false)
				break;
			else
				System.out.println("**Ký tự nhập không hợp lệ ** Xin vui lòng nhập lại**");
		}
		return s;
	}

	public int kiemTraMenu(int x) throws NumberFormatException {
		// int so = 0;
		int luachon;
		while (true) {
			try {
				luachon = Integer.parseInt(sc.nextLine());
				if (luachon < 0)
					System.out.println("**Lựa chọn không được âm. Nhập lại.**");
				else if (luachon > x)
					System.out.println("**Bạn đã nhập sai lựa chọn. Nhập lại.**");
				else
					break;

			} catch (NumberFormatException e) {
				System.out.println("**Lỗi dữ liệu. Hãy nhập lại.**");
			}
		}
		return luachon;
	}

	public String kiemTraMa() {
		String s;
		String regex = "[a-zA-Z0-9]{5}";
		while (true) {
			try {
				s = sc.nextLine();
				if (s.matches(regex) == true && s.equals("") == false)
					break;
				else
					System.out.println("**Mã chứa kí tự lạ hoặc không phù hợp ,tối thiểu 5 ký tự. Nhập lại.**");
			} catch (Exception e) {
				System.out.println("**Lỗi dữ liệu. Nhập lại.**");
			}
		}
		return s;
	}

	public String kiemTraSdt() {
		String sdt;
		String regex = "0[1-9][0-9]{8}";
		while (true) {
			try {
				sdt = sc.nextLine();
				if (sdt.matches(regex) == true && sdt.equals("") == false)
					break;
				else
					System.out.println("**Không phải sđt bao gồm 9 số vd 01*******. Nhập lại.**");
			} catch (Exception e) {
				System.out.println("**Lỗi dữ liệu . Nhập lại.**");
			}
			
		}
		return sdt;
	}

	public String kiemTraTen() {
		String ten;
		String regex = "\\d*[\\pL\\p{Mn}*\\s]*";
		while (true) {
			try {
				ten = sc.nextLine();
				if (ten.matches(regex) == true && ten.equals("") == false)
					break;
				else
					System.out.println("** Tên không phù hợp. Nhập lại. **");
			} catch (Exception e) {
				System.out.println("** Lỗi dữ liệu. Nhập lại. **");
			}
		}
		return ten;
	}

	public String kiemTraStatus() {
		String s;
		String regex = "[0-1]";
		while (true) {
			try {
				s = sc.nextLine();
				if (s.matches(regex) == true && s.equals("") == false) {
					break;
				} else {
					System.out.println("** Trạng thái không đúng. Nhập lại **");
				}
			} catch (Exception e) {
				System.out.println("** Lỗi dữ liệu. Nhập lại **");
			}
		}
		return s;
	}

	public int kiemTraTuoi() {
		int tuoi = 0;
		while (true) {
			try {
				tuoi = Integer.parseInt(sc.nextLine());
				if (tuoi > 0 && tuoi < 100)
					break;
				else
					System.out.println("** Nhập sai số tuổi. Nhập lại **");
			} catch (Exception e) {
				System.out.println("** Lỗi dữ liệu. Nhập lại **");
			}
		}
		return tuoi;
	}

	public int kiemTraInt() {
		int Int = 0;
		while (true) {
			try {
				Int = Integer.parseInt(sc.nextLine());
				if (Int < 0)
					System.out.println("** Số không được âm. Nhập lại **");
				else
					break;
			} catch (Exception e) {
				System.out.println("** Lỗi dữ liệu. Nhập lại **");
			}
		}
		return Int;
	}

	public String ktPhai() {
		String phai;
		while (true) {
			try {
				phai = sc.nextLine();
				if (phai.equals("") == false) {
					if (phai.equalsIgnoreCase("nam") == true || phai.equalsIgnoreCase("nữ") == true|| phai.equalsIgnoreCase("khác"))
						break;
					else
						System.out.println("** Nam, nữ hoặc khác. Nhập lại **");
				}
			} catch (Exception e) {
				System.out.println("** Lỗi dữ liệu. Nhập lại **");
			}
		}
		return phai;
	}

	public float kiemTraFloat() {
		float Floatnum = 0;
		while (true) {
			try {
				Floatnum = Float.parseFloat(sc.nextLine());
				if (Floatnum < 0)
					System.out.println("** Số không được âm. Nhập lại **");
				else
					break;
			} catch (Exception e) {
				System.out.println("** Lỗi dữ liệu. Nhập lại **");
			}
		}
		return Floatnum;
	}

}
