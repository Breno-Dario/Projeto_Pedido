package pck_Control;

import pck_Model.PedidoModel;
import pck_Persistencia.PedidoPersistencia;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PedidoControl {

    private PedidoPersistencia obj_persistencia = new PedidoPersistencia();

    public void inserirPedido(String a02_data, String a02_valor_total, int a01_codigo) {
        PedidoModel obj_pedido = new PedidoModel();

        // Validate and parse the date
        LocalDate data;
        try {
            data = LocalDate.parse(a02_data); // Assuming a specific format
        } catch (DateTimeParseException e) {
            System.err.println("Data inválida: " + e.getMessage());
            return; // Early return on invalid input
        }

        // Validate and parse the total value
        double valorTotal;
        try {
            valorTotal = Double.parseDouble(a02_valor_total);
        } catch (NumberFormatException e) {
            System.err.println("Valor inválido: " + e.getMessage());
            return; // Early return on invalid input
        }

        // Set the properties for the PedidoModel object
        obj_pedido.setA02_data(String.valueOf(data));
        obj_pedido.setA02_valor_total(valorTotal);
        obj_pedido.setA01_codigo(a01_codigo);

        try {
            obj_persistencia.inserirPedido(obj_pedido);
            System.out.println("Pedido inserido com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao inserir pedido: " + e.getMessage());
        }
    }

    // Optional: Implement this method if needed
    public void inserirPedido(String data, double valorDouble) {
        // Implementation goes here
    }
}
