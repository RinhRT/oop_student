package rinh_25695161;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		QuanLySanPham ql = new QuanLySanPham();
		
		ql.themSanPham(
				new SanPhamDienTu(
					"DT_001", 
					"Lap", 
					LocalDate.now(), 
					10, 
					120, 
					LocalDate.now().plusMonths(3))
		);
		
		ql.themSanPham(
				new SanPhamThucPham(
					"TP_001", 
					"Chau", 
					LocalDate.now(), 
					2313, 
					20, 
					LocalDate.now().plusWeeks(1))
		);
		
		ql.themSanPham(
				new SanPhamThucPham(
					"TP_002", "Lap Xuong", 
					LocalDate.now().plusMonths(0), 
					1, 
					21,
					LocalDate.now().plusWeeks(1))
		);
		
		ql.themSanPham(
				new SanPhamDienTu(
					"DT_002", 
					"Lap123", 
					LocalDate.now().plusMonths(-2), 
					9, 
					120, 
					LocalDate.now().plusMonths(3))
		);
		
		ql.themSanPham(
				new SanPhamDienTu(
					"DT_003", 
					"May moi", 
					LocalDate.now().plusMonths(-4), 
					15, 
					3120, 
					LocalDate.now().plusMonths(3))
		);
	
		ql.themSanPham(
				new SanPhamDienTu(
					"DT_004", 
					"Lap", 
					LocalDate.now(), 
					10, 
					120, 
					LocalDate.now().plusMonths(1))
		);
		
		System.out.println("[+] DANH SACH SAN PHAM BAN DAU");
		ql.printAll();
		
		System.out.println("\n[+] XOA SAN PHAM THEO MA (VI DU: \"TP_002\")");
		ql.xoaSanPham("TP_002");
		ql.printAll();
		
		System.out.println("\n[+] SUA SO LUONG THEO THEO MA SAN PHAM (VI DU: maSP\"DT_003\", sl:10)");
		ql.suaSoLuongTon("DT_003", 10);
		ql.printAll();
		
		System.out.println("\n[+] XUAT SAN PHAM THEO LOAI");
		ql.xuatSanPhamTheoLoai("Dien Tu");

		System.out.println("\n[+] XUAT SAN PHAM THEO GIA BAN CAO NHAT");
		ql.xuatSanPhamGiaBanCaoNhat();
	}

}
