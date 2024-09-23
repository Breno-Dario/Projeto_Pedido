package pck_Control;
import pck_Model.ClienteModel;
import pck_Persistencia.ClientePersistencia;


public class ClienteControl {

    ClienteModel obj_modelo = new ClienteModel();

    ClientePersistencia obj_persistencia = new ClientePersistencia();

    public void inserirCliente(String a01_nome,String a01_endereco, String a01_telefone, String a01_cpf, Double a01_credito){

        obj_modelo.setA01_nome(a01_nome);
        obj_modelo.setA01_endereco(a01_endereco);
        obj_modelo.setA01_telefone(a01_telefone);
        obj_modelo.setA01_cpf(a01_cpf);
        obj_modelo.setA01_credito(a01_credito);

     obj_persistencia.inserirCliente(obj_modelo);
    }

}
