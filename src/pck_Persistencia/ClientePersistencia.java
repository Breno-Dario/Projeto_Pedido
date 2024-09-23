package pck_Persistencia;

import pck_Model.ClienteModel;
import pck_Dao.Conexao_DAO;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;


public class ClientePersistencia {

    CallableStatement oCall;
    Conexao_DAO oConectar = new Conexao_DAO();

    public void inserirCliente(ClienteModel obj_model) {
        try {
            Connection conn = oConectar.getConnection();
            if (conn != null) {
                oCall = conn.prepareCall("CALL Proc_InsCliente(?,?,?,?,?)");
                oCall.setString(1, obj_model.getA01_nome());
                oCall.setString(2, obj_model.getA01_endereco());
                oCall.setString(3, obj_model.getA01_telefone());
                oCall.setString(4, obj_model.getA01_cpf());
                oCall.setDouble(5, obj_model.getA01_credito());
                oCall.execute(); // Execute the procedure
            }
        } catch (SQLException erro) {
            System.out.println(erro);
        }
    }
}
