package pck_Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao_DAO {

    public Connection obj_connection= null;

    private final String DRIVER = "org.mariadb.jdbc.Driver";
    private final String URL = "jdbc:mariadb://localhost:3306/DB_PEDIDO";
    private final String LOGIN = "root";
    private final String SENHA = "root";

    public Conexao_DAO() {

    }

    public Connection getConnection() {
        try
        {
            Class.forName(DRIVER);
            obj_connection = DriverManager.getConnection(URL, LOGIN, SENHA);
            System.out.println("Conectou");
            return obj_connection;

        }

        catch (ClassNotFoundException erro){
            System.out.println("Driver não encontrado" + erro.toString());
            return obj_connection;
        }

        catch (SQLException erro){
            System.out.println("Erro ao conectar" + erro.toString());
            return obj_connection;
        }

    }

}
