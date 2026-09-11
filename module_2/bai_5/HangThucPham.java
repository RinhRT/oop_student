// package bai_5;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class HangThucPham {
    private String ID="";
    private String name="xxx";
    private double price=0.0;
    private LocalDate mfd=LocalDate.now();
    private LocalDate exp=LocalDate.now();

    private Object defaultValue(String attribute) {
        switch (attribute) {
            case "ID":
                return "";
            case "name":
                return "xxx";
            case "price":
                return 0.0;
            case "mfd":
                return LocalDate.now();
            case "exp":
                return mfd;
            default:
                return null;
        }
    }

    private void validate(Field field, Object value) {
        String attribute = field.getName();

        switch (attribute) {
            case "name":
            case "ID":
                if (!(value instanceof String)) 
                    throw new IllegalArgumentException(
                        attribute + " must be String."
                    );

                if (((String) value).isBlank()) 
                    throw new IllegalArgumentException(
                        attribute + " cannot be empty."
                    );
                break;
            case "price":
                if (!(value instanceof Double)) 
                    throw new IllegalArgumentException(
                        attribute + " must be double."
                    );

                if ((double)value<0.0)
                    throw new IllegalArgumentException(
                        attribute + " must be >= 0.0."
                    );
                break;
            case "mfd":
                if (!(value instanceof LocalDate)) 
                    throw new IllegalArgumentException(
                        attribute + " must be LocalDate."
                    );
                
                if (((LocalDate)value).isAfter(LocalDate.now()))
                    throw new IllegalArgumentException(
                        attribute + " cannot be after today."
                    );
                break;
            case "exp":
                if (!(value instanceof LocalDate)) 
                    throw new IllegalArgumentException(
                        attribute + " must be LocalDate."
                    );

                if (!((LocalDate)value).isAfter(mfd))
                    throw new IllegalArgumentException(
                        attribute + " must be after mfd."
                    );
                break;
        }
    }

    public HangThucPham(String ID, String name, double price, LocalDate mfd, LocalDate exp) {
        if (ID == null || ID.isBlank())
            throw new IllegalArgumentException("ID cannot be empty.");

        this.setter("ID", ID);
        this.setter("name", name);
        this.setter("price", price);
        this.setter("mfd", mfd);
        this.setter("exp", exp);
    }

    public HangThucPham() {
        throw new IllegalArgumentException("ID cannot be empty.");
    }

    public void getter(String attribute) {
        try {
            Field field = this.getClass().getDeclaredField(attribute);
            field.setAccessible(true);
            System.out.println(field.get(this));
        } catch (NoSuchFieldException e) {
            System.err.println("Attribute does not exist: " + attribute);
        } catch (IllegalAccessException e) {
            System.err.println("Unable to access attribute: " + attribute);
        }
    }

    public void setter(String attribute, Object value) {
        try {
            Field field = this.getClass().getDeclaredField(attribute);
            field.setAccessible(true);

            try {
                this.validate(field, value);
            } catch (IllegalArgumentException e) {
                value = defaultValue(attribute);
            }

            field.set(this, value);
        } catch (NoSuchFieldException e) {
            System.err.println("Attribute does not exist: " + attribute);
        } catch (IllegalAccessException e) {
            System.err.println("Unable to access attribute: " + attribute);
        }
    }
}