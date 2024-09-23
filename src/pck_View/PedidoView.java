package pck_View;

import pck_Control.PedidoControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PedidoView extends JFrame {
    private JTextField dateField1;
    private JTextField valorField2;
    private JPanel jp_mainpanel2;
    private JComboBox<String> comboBox1; // Assuming this is for selecting a customer
    private JButton confirmarButton;

    public PedidoView() {
        setContentPane(jp_mainpanel2);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(626, 626);
        setLocationRelativeTo(null);

        confirmarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleConfirmarButtonClick();
            }
        });
    }

    private void handleConfirmarButtonClick() {
        String data = dateField1.getText().trim();
        String valorText = valorField2.getText().trim();

        // Validate inputs
        if (data.isEmpty() || valorText.isEmpty()) {
            showErrorMessage("Por favor, preencha todos os campos.");
            return;
        }

        // Validate date format
        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(data); // Adjust format if necessary
        } catch (DateTimeParseException e) {
            showErrorMessage("Data inválida. Por favor, insira uma data válida (yyyy-MM-dd).");
            return;
        }

        try {
            double valorDouble = Double.parseDouble(valorText);
            int a01_codigo = comboBox1.getSelectedIndex(); // Example for using comboBox1
            PedidoControl inserirPedido = new PedidoControl();
            inserirPedido.inserirPedido(data, String.valueOf(valorDouble), a01_codigo); // Adjusted method call

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
