package pck_Model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PedidoModel {
    private int a02codigo;
    private LocalDate a02_data;
    private double a02_valor_total;
    private int a01_codigo;

    // Getter e Setter para a02_valor_total
    public double getA02_valor_total() {
        return a02_valor_total;
    }

    public void setA02_valor_total(double a02_valor_total) {
        this.a02_valor_total = a02_valor_total;
    }

    // Getter e Setter para a01_codigo
    public int getA01_codigo() {
        return a01_codigo;
    }

    public void setA01_codigo(int a01_codigo) {
        this.a01_codigo = a01_codigo;
    }

    // Getter e Setter para a02_data
    public LocalDate getA02_data() {
        return a02_data;
    }

    public void setA02_data(String a02_data) {
        this.a02_data = LocalDate.parse(a02_data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // Getter e Setter para a02codigo
    public int getA02codigo() {
        return a02codigo;
    }

    public void setA02codigo(int a02codigo) {
        this.a02codigo = a02codigo;
    }
}
