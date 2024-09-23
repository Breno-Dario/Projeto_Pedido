package pck_View;

import pck_Control.ClienteControl;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaView extends JFrame {
    private JTextField nomeField;
    private JPanel jp_mainpanel;
    private JTextField enderecoField;
    private JTextField telefoneField;
    private JTextField cpfField;
    private JTextField creditoField;
    private JButton cadastrarButton;

    public AgendaView() {


        this.setContentPane(jp_mainpanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(626, 626);
        this.setLocationRelativeTo(null);

        //Executa a ação de mostra se o dados foi cadastrado//
        cadastrarButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String nome = nomeField.getText();
                String endereco = enderecoField.getText();
                String telefone = telefoneField.getText();
                String cpf = cpfField.getText();
                double credito = Double.parseDouble(creditoField.getText());


                JOptionPane.showMessageDialog(null,
                        "Cadastro realizado com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

                ClienteControl inserirCliente = new ClienteControl();
                inserirCliente.inserirCliente(nome, endereco, telefone, cpf, credito);

            }

        });

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(AgendaView::new);
    }

}



