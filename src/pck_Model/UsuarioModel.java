package pck_Model;


public class UsuarioModel {
    private int id;
    private String nome;

    public UsuarioModel(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return id + " - " + nome; // Formato exibido no JComboBox
    }
}

