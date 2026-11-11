package bai6;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DanhSachPhongHoc ql = new DanhSachPhongHoc();
		try (Scanner sc = new Scanner(System.in)) {
			ql.themPhongHoc(new PhongLyThuyet("LT01", "A", 50, 5, true));
			ql.themPhongHoc(new PhongLyThuyet("LT02", "A", 40, 4, false));
			ql.themPhongHoc(new PhongMayTinh("MT01", "B", 45, 5, 30));
			ql.themPhongHoc(new PhongMayTinh("MT02", "B", 50, 5, 20));
			ql.themPhongHoc(new PhongMayTinh("MT03", "C", 90, 9, 60));
			ql.themPhongHoc(new PhongThiNghiem("TN01", "C", 60, 6, "Hoa Hoc", 40, true));
			ql.themPhongHoc(new PhongThiNghiem("TN02", "C", 60, 6, "Sinh Hoc", 40, false));
			
			int chon;
			do {
				System.out.println("\n========== MENU QUAN LY PHONG HOC ==========");
			    System.out.println("1. In danh sach phong hoc");
			    System.out.println("2. Them phong hoc moi");
			    System.out.println("3. Tim kiem phong theo ma");
			    System.out.println("4. In danh sach phong dat chuan");
			    System.out.println("5. Sap xep tang dan theo day nha");
			    System.out.println("6. Sap xep giam dan theo dien tich");
			    System.out.println("7. Sap xep tang dan theo so bong den");
			    System.out.println("8. Cap nhat so may tinh");
			    System.out.println("9. Xoa phong hoc");
			    System.out.println("10. Tong so phong hoc");
			    System.out.println("11. Danh sach phong may co 60 may");
			    System.out.println("0. Thoat");
			    System.out.print("Chon chuc nang: ");
			    
			    try {
			        chon = Integer.parseInt(sc.nextLine());
			    } catch (NumberFormatException e) {
			        chon = -1;
			    }

			    switch (chon) {
			        case 1:
			            ql.inDanhSach();
			            break;
			        case 2:
			            System.out.println("Nhap loai (1: LT, 2: MT, 3: TN): ");
			            int loai = Integer.parseInt(sc.nextLine());
			            System.out.print("Ma phong: "); String ma = sc.nextLine();
			            System.out.print("Day nha: "); String day = sc.nextLine();
			            System.out.print("Dien tich: "); double dt = Double.parseDouble(sc.nextLine());
			            System.out.print("So bong den: "); int den = Integer.parseInt(sc.nextLine());

			            if (loai == 1) {
			                System.out.print("Co may chieu (true/false): "); boolean mc = Boolean.parseBoolean(sc.nextLine());
			                ql.themPhongHoc(new PhongLyThuyet(ma, day, dt, den, mc));
			            } else if (loai == 2) {
			                System.out.print("So may tinh: "); int may = Integer.parseInt(sc.nextLine());
			                ql.themPhongHoc(new PhongMayTinh(ma, day, dt, den, may));
			            } else if (loai == 3) {
			                System.out.print("Chuyen nganh: "); String cn = sc.nextLine();
			                System.out.print("Suc chua: "); int sc1 = Integer.parseInt(sc.nextLine());
			                System.out.print("Co bon rua (true/false): "); boolean br = Boolean.parseBoolean(sc.nextLine());
			                ql.themPhongHoc(new PhongThiNghiem(ma, day, dt, den, cn, sc1, br));
			            }
			            break;
			        case 3:
			            System.out.print("Nhap ma can tim: ");
			            String maTim = sc.nextLine();
			            PhongHoc p = ql.timKiem(maTim);
			            if (p != null) System.out.println(p);
			            else System.out.println("Khong tim thay.");
			            break;
			        case 4:
			            List<PhongHoc> dsChuan = ql.getPhongDatChuan();
			            System.out.println("--- PHONG DAT CHUAN ---");
			            for (PhongHoc ph : dsChuan) System.out.println(ph);
			            break;
			        case 5:
			            ql.sapXepTangTheoDayNha();
			            System.out.println("Da sap xep tang theo day nha.");
			            ql.inDanhSach();
			            break;
			        case 6:
			            ql.sapXepGiamTheoDienTich();
			            System.out.println("Da sap xep giam theo dien tich.");
			            ql.inDanhSach();
			            break;
			        case 7:
			            ql.sapXepTangTheoBongDen();
			            System.out.println("Da sap xep tang theo bong den.");
			            ql.inDanhSach();
			            break;
			        case 8:
			            System.out.print("Nhap ma phong may can cap nhat: ");
			            String maMT = sc.nextLine();
			            System.out.print("Nhap so may moi: ");
			            int soMayMoi = Integer.parseInt(sc.nextLine());
			            if (ql.capNhatSoMayTinh(maMT, soMayMoi)) 
			                System.out.println("Cap nhat thanh cong.");
			            else 
			                System.out.println("That bai (Khong tim thay hoac sai loai phong).");
			            break;
			        case 9:
			            System.out.print("Nhap ma phong can xoa: ");
			            String maXoa = sc.nextLine();
			            System.out.print("Ban co chac chan muon xoa? (Y/N): ");
			            String xacNhan = sc.nextLine();
			            if (xacNhan.equalsIgnoreCase("Y")) {
			                if (ql.xoaPhongHoc(maXoa)) System.out.println("Da xoa.");
			                else System.out.println("Khong tim thay phong.");
			            } else {
			                System.out.println("Da huy xoa.");
			            }
			            break;
			        case 10:
			            System.out.println("Tong so phong: " + ql.tongSoPhong());
			            break;
			        case 11:
			            List<PhongMayTinh> ds60 = ql.getPhongMay60();
			            System.out.println("--- PHONG MAY 60 MAY ---");
			            if(ds60.isEmpty()) System.out.println("Khong co.");
			            for (PhongMayTinh pm : ds60) System.out.println(pm);
			            break;
			        case 0:
			            System.out.println("Tam biet!");
			            break;
			        default:
			            System.out.println("Chuc nang khong hop le.");
			    }
			} while (chon != 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
