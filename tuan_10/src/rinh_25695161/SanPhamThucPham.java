package rinh_25695161;

import java.time.LocalDate;

public class SanPhamThucPham extends SanPham {
	private LocalDate hetHan;
	
	public LocalDate getHetHan() {
		return hetHan;
	}
	
	public void setHetHan(LocalDate hetHan) {
		LocalDate dateNow = LocalDate.now();
		if (!dateNow.isBefore(hetHan))
			throw new IllegalArgumentException("Han su dung khong hop le");
		
		this.hetHan = hetHan;
	}

	public SanPhamThucPham(String maSanPham, String tenSanPham, LocalDate ngaySanXuat, int soLuongTon, double giaNhap,
			LocalDate hetHan) {
		super(maSanPham, tenSanPham, ngaySanXuat, soLuongTon, giaNhap, "Thuc Pham");
		setHetHan(hetHan);
	}

	@Override
	public double giaBan() {
		LocalDate dateNow = LocalDate.now();
			if (!dateNow.isBefore(hetHan)) return 0;
		return giaNhap+(giaNhap*.05);
	}
	
	@Override
	public String toString() {
		return super.toString()+
			"|"+
			String.format(
				"%12.2f|%12s",
				giaBan(),
				hetHan.toString()
			);	
	}
}
