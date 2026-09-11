
import java.time.LocalDate;

public class Main {
    public void main(String[] args) {
        HangThucPham tp1 = new HangThucPham();
        // HangThucPham tp2 = new HangThucPham();
        // HangThucPham tp3 = new HangThucPham();

        tp1.setter("ID", "");
        tp1.setter("name", "Bo kho");
        tp1.setter("price", 12312);
        tp1.setter("mfd", LocalDate.now());
        tp1.setter("exp", LocalDate.now());

        tp1.getter("name");
        tp1.getter("exp");
    }
}