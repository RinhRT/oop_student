package bai6;

public abstract class PhongHoc {
	protected String maPhong;
	protected String dayNha;
	protected double dienTich;
	protected int soBongDen;
	
	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super();
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getDayNha() {
		return dayNha;
	}

	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public int getSoBongDen() {
		return soBongDen;
	}

	public void setSoBongDen(int soBongDen) {
		this.soBongDen = soBongDen;
	}
	
	public boolean duAnhSang() {
		return (dienTich / soBongDen) <= 10;
	}
	
	public abstract boolean datChuan();

	@Override
	public String toString() {
		return String.format("Ma: %-10s | Day: %-10s | Dien tich: %-8.2f | Den: %-3d", 
				maPhong, dayNha, dienTich, soBongDen);
	}
	
	
}
