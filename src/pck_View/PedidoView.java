package pck_View;

import pck_Control.PedidoControl;
import pck_Model.UsuarioModel; // Importando a classe PessoalModel

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class PedidoView extends JFrame {
    private JTextField dateField1;
    private JTextField valorField2;
    private JPanel jp_mainpanel2;
    private JComboBox<UsuarioModel> comboBox1; // Alterado para o tipo PessoalModel
    private JButton confirmarButton;

    public PedidoView() {
        setContentPane(jp_mainpanel2);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(626, 626);
        setLocationRelativeTo(null);

        // Criar uma lista de pessoas (substitua isso pela sua lógica de banco de dados)
        List<UsuarioModel> pessoais = new ArrayList<>();
        pessoais.add(new UsuarioModel(1, "Oliveira da SIlva")); // Usar PessoalModel
        pessoais.add(new UsuarioModel(2, "Lucas SIlva"));
        pessoais.add(new UsuarioModel(3, "Lucas Gustavo"));
        pessoais.add(new UsuarioModel(4, "Giovanna Maria"));

        // Popular o JComboBox com as pessoas
        DefaultComboBoxModel<UsuarioModel> model = new DefaultComboBoxModel<>();
        for (UsuarioModel pessoal : pessoais) {
            model.addElement(pessoal);
        }
        comboBox1.setModel(model);

        confirmarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleConfirmarButtonClick();
            }
        });
    }

    private void handleConfirmarButtonClick() {
        String data = dateField1.getText().trim();
        String valorText = valorField2.getText().trim();

        // Validar entradas
        if (data.isEmpty() || valorText.isEmpty()) {
            showErrorMessage("Por favor, preencha todos os campos.");
            return;
        }

        // Validar formato de data
        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(data); // Ajuste o formato se necessário
        } catch (DateTimeParseException e) {
            showErrorMessage("Data inválida. Por favor, insira uma data válida (yyyy-MM-dd).");
            return;
        }

        try {
            double valorDouble = Double.parseDouble(valorText);
            int a01_codigo = ((UsuarioModel) comboBox1.getSelectedItem()).getId(); // Obter o ID da pessoa selecionada
            PedidoControl inserirPedido = new PedidoControl();
            inserirPedido.inserirPedido(data, String.valueOf(valorDouble), a01_codigo); // Chamada do método ajustada

            JOptionPane.showMessageDialog(null,
                    "Cadastro realizado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            showErrorMessage("Valor inválido. Por favor, insira um número.");
        }
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PedidoView::new);
    }
}
