package pck_Persistencia;

import pck_Model.PedidoModel;
import pck_Dao.Conexao_DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class PedidoPersistencia {

    private Conexao_DAO oConectar = new Conexao_DAO();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void inserirPedido(PedidoModel obj_pedido) {
        String sql = "CALL Proc_InsPedido(?,?,?)";

        try (Connection conn = oConectar.getConnection();
             CallableStatement oCall = conn.prepareCall(sql)) {

            if (conn != null) {
                oCall.setString(1, obj_pedido.getA02_data().format(DATE_FORMATTER));
                oCall.setDouble(2, obj_pedido.getA02_valor_total());
                oCall.setInt(3, obj_pedido.getA01_codigo());

                oCall.execute(); // Execute the procedure
            }
        } catch (SQLException erro) {
            System.err.println("Erro ao inserir pedido: " + erro.getMessage());
            // Consider throwing a custom exception
        }
    }
}
