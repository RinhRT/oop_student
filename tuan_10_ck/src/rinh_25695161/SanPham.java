package rinh_25695161;

import java.time.LocalDate;
import java.util.Objects;

public abstract class SanPham {
	protected String maSanPham, tenSanPham, loai;
	protected LocalDate ngaySanXuat;
	protected int soLuongTon;
	protected double giaNhap;
	
	public String getMaSanPham() {
		return maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		if (loai == null || loai.isEmpty())
			throw new IllegalArgumentException("Loai san pham khong the trong");
		
		if (loai.trim() == "Dien Tu" || loai.trim() == "Thuc Pham") 
			this.loai = loai;
		else 
			throw new IllegalArgumentException("Loai san pham khong hop le");
	}
	public void setMaSanPham(String maSanPham) {
		if (maSanPham == null || maSanPham.isEmpty())
			throw new IllegalArgumentException("Ma san pham khong the trong");
		
		this.maSanPham = maSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		if (tenSanPham == null || tenSanPham.isEmpty())
			throw new IllegalArgumentException("Ten san pham khong the trong");
		
		this.tenSanPham = tenSanPham;
	}
	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		LocalDate dateNow = LocalDate.now();
		if (ngaySanXuat == null || ngaySanXuat.isAfter(dateNow))
			throw new IllegalArgumentException("Ngay san xuat khong hop le");
		
		this.ngaySanXuat = ngaySanXuat;
	}
	public void setGiaNhap(double giaNhap) {
		if (giaNhap < 0)
			throw new IllegalArgumentException("Gia nhap khong the be hon 0");
		this.giaNhap = giaNhap;
	}
	public void setSoLuongTon(int soLuongTon) {
		if (soLuongTon < 0)
			throw new IllegalArgumentException("So luong khong the be hon 0");
		this.soLuongTon = soLuongTon;
	}
	
	public abstract double giaBan();
	
	public SanPham(String maSanPham, String tenSanPham, LocalDate ngaySanXuat, int soLuongTon, double giaNhap, String loai) {
		super();
		setMaSanPham(maSanPham);
		setTenSanPham(tenSanPham);
		setNgaySanXuat(ngaySanXuat);
		setSoLuongTon(soLuongTon);
		setGiaNhap(giaNhap);
		setLoai(loai);
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}
	@Override
	public String toString() {
		return String.format(
			"%10s|%25s|%12s|%10s|%10d|%12.2f", 
			maSanPham,
			tenSanPham,
			ngaySanXuat.toString(),
			loai,
			soLuongTon,
			giaNhap
		);
	}
	
	
}
