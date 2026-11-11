package bai6;

public class PhongMayTinh extends PhongHoc {
	public int soMayTinh;
	
	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}
	
	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		this.soMayTinh = soMayTinh;
	}

	@Override
	public boolean datChuan() {
		if (soMayTinh <= 0) {
			return false;
		}
		return duAnhSang() && (dienTich / soMayTinh <= 1.5);
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" | So may: %-3d | Dat chuan: %s", 
				soMayTinh, (datChuan() ? "Co" : "Khong"));
	}
}
