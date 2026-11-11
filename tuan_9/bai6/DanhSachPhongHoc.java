package bai6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachPhongHoc {
	private List<PhongHoc> ds;
	
	public DanhSachPhongHoc() {
		this.ds = new ArrayList<>();
	}
	
	public boolean themPhongHoc(PhongHoc phong) {
		for (PhongHoc p : ds) {
			if (p.getMaPhong().equalsIgnoreCase(phong.getMaPhong())) {
				System.out.println("Loi: Ma phong " + phong.getMaPhong() + " da ton tai!");
				return false;
			}
		}
		ds.add(phong);
		return true;
	}
	
	public PhongHoc timKiem(String maPhong) {
		for (PhongHoc p : ds) {
			if (p.getMaPhong().equalsIgnoreCase(maPhong)) {
				return p;
			}
		}
		return null;
	}
	
	public void inDanhSach() {
		if (ds.isEmpty()) {
			System.out.println("Danh sach rong.");
			return;
		}
		System.out.println("--- DANH SACH PHONG HOC ---");
		for (PhongHoc p : ds) {
			System.out.println(p.toString());
		}
	}
	
	public List<PhongHoc> getPhongDatChuan() {
		List<PhongHoc> kq = new ArrayList<>();
		for (PhongHoc p : ds) {
			if (p.datChuan()) {
				kq.add(p);
			}
		}
		return kq;
	}
	
	public void sapXepTangTheoDayNha() {
		Collections.sort(ds, new Comparator<PhongHoc>() {
			@Override 
			public int compare(PhongHoc o1, PhongHoc o2) {
				return o1.getDayNha().compareTo(o2.getDayNha());
			}
		});
	}
	
	public void sapXepGiamTheoDienTich() {
		Collections.sort(ds, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				return Double.compare(o2.getDienTich(), o1.getDienTich());
			}
		});
	}
	
	public void sapXepTangTheoBongDen() {
		Collections.sort(ds, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				return Integer.compare(o1.getSoBongDen(), o2.getSoBongDen());
			}
		});
	}
	
	public boolean capNhatSoMayTinh(String maPhong, int soMayMoi) {
		PhongHoc p = timKiem(maPhong);
		if (p instanceof PhongMayTinh) {
			((PhongMayTinh) p).setSoMayTinh(soMayMoi);
			return true;
		}
		return false;
	}
	
	public boolean xoaPhongHoc(String maPhong) {
		PhongHoc p = timKiem(maPhong);
		if (p != null) {
			ds.remove(p);
			return true;
		}
		return false; 
	}
	
	public int tongSoPhong() {
		return ds.size();
	}
	
	public List<PhongMayTinh> getPhongMay60() {
		List<PhongMayTinh> kq = new ArrayList<>();
		for (PhongHoc p : ds) {
			if (p instanceof PhongMayTinh) {
				PhongMayTinh pmt = (PhongMayTinh) p;
				if (pmt.getSoMayTinh() == 60) {
					kq.add(pmt);
				}
			}
		}
		return kq;
	}
}
