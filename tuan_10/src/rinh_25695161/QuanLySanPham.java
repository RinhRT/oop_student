package rinh_25695161;

import java.util.ArrayList;

public class QuanLySanPham {
	private ArrayList<SanPham> ds;
	
	public QuanLySanPham() {
		ds = new ArrayList<SanPham>();
	}
	
	public QuanLySanPham(ArrayList<SanPham> ds) {
		ds = new ArrayList<SanPham>(ds);
	}
	
	public SanPham timSP(String maSP) {
		if (maSP == null || maSP.isEmpty()) {
			System.out.println("Ma san pham khong the trong");
			return null;
		}
		
		for (SanPham e : ds) 
			if (maSP.equalsIgnoreCase(e.getMaSanPham())) return e;
		
		return null;
	}
	
	public boolean themSanPham(SanPham sp) {
		if (ds == null) {
			System.out.println("San pham khong the trong");
			return false;
		}
		
		if (timSP(sp.getMaSanPham()) != null) {
			System.out.println("San pham bi trung ma");
			return false;
		}
		
		ds.add(sp);
		return true;
	}
	
	public boolean xoaSanPham(String maSP) {
		SanPham e = timSP(maSP);
		if (e == null) return false;
		ds.remove(e);
		return true;
	}
	
	public boolean suaSoLuongTon(String maSP, int soLuongMoi) {
		SanPham e = timSP(maSP);
		if (e == null) return false;
		e.setSoLuongTon(soLuongMoi);
		return true;
	}
	
	public void xuatSanPhamGiaBanCaoNhat() {
		System.out.println("======= CAC SAN PHAM CO GIA BAN CAO NHAT =======");
		double maxPrice=-1;
		for (SanPham e: ds)
			if (e.giaBan() > maxPrice) maxPrice = e.giaBan();
		
		for (SanPham e: ds)
			if (e.giaBan() == maxPrice) {
				System.out.println(e.toString());
			}
	}
	
	public void xuatSanPhamTheoLoai(String loai) {
		if (loai == null || loai.isEmpty()) {
			System.out.println("loai khong the trong (Dien Tu/Thuc Pham)");
			return;
		}
		
		System.out.println("======= SAN PHAM \""+ loai.trim() +"\" =======");
		for (SanPham e: ds)
			if (loai.trim().equals(e.getLoai()))
				System.out.println(e.toString());
			
	}
	
	public void printAll() {
		System.out.println("======= IN IN TOAN BO SAN PHAM =======");
		ds.forEach(e -> System.out.println(e.toString()));
//		for (SanPham e : ds) 
//			System.out.println(e.toString());
	}
}
