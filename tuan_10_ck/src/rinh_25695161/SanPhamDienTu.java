package rinh_25695161;

import java.time.LocalDate;

public class SanPhamDienTu extends SanPham {
	private LocalDate hanBaoHanh;

	public LocalDate getHanBaoHanh() {
		return hanBaoHanh;
	}

	public void setHanBaoHanh(LocalDate hanBaoHanh) {
		LocalDate dateNow = LocalDate.now();
		if (!dateNow.isBefore(hanBaoHanh))
			throw new IllegalArgumentException("Han bao hanh khong hop le");
		
		this.hanBaoHanh = hanBaoHanh;
	}

	public SanPhamDienTu(String maSanPham, String tenSanPham, LocalDate ngaySanXuat, int soLuongTon, double giaNhap,
			LocalDate hanBaoHanh) {
		super(maSanPham, tenSanPham, ngaySanXuat, soLuongTon, giaNhap, "Dien Tu");
		setHanBaoHanh(hanBaoHanh);
	}

	@Override
	public double giaBan() {
		return giaNhap+(giaNhap*.1);
	}

	@Override
	public String toString() {
		return super.toString()+
			"|"+
			String.format(
				"%12.2f|%12s",
				giaBan(),
				hanBaoHanh.toString()
			);	
	}
	
	
}
