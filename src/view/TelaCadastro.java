package view;

import listener.ListenerSalvar;
import modelo.Produto;

import javax.swing.*;

public class TelaCadastro extends JDialog {
    public TelaCadastro() {
        this.setTitle("Cadastrar Novo Produto");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(360, 200);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setModal(true);
//        this.setAlwaysOnTop(true);

        JLabel lblCodigo = new JLabel("Código:");
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblPreco = new JLabel("Preço:");
        JLabel lblQuantidade = new JLabel("Quantidade:");

        JTextField txtCodigo = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtPreco = new JTextField();
        JTextField txtQuantidade = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");

        lblCodigo.setBounds(10, 10, 150, 20);
        lblNome.setBounds(10, 40, 150, 20);
        lblPreco.setBounds(10, 70, 150, 20);
        lblQuantidade.setBounds(10, 100, 150, 20);

        txtCodigo.setBounds(130, 10, 200, 20);
        txtNome.setBounds(130, 40, 200, 20);
        txtPreco.setBounds(130, 70, 200, 20);
        txtQuantidade.setBounds(130, 100, 200, 20);

        btnCadastrar.setBounds(40, 140, 130, 20);
        btnCancelar.setBounds(180, 140, 130, 20);

        this.add(lblCodigo);
        this.add(lblNome);
        this.add(lblPreco);
        this.add(lblQuantidade);

        this.add(txtCodigo);
        this.add(txtNome);
        this.add(txtPreco);
        this.add(txtQuantidade);

        this.add(btnCadastrar);
        this.add(btnCancelar);

        btnCadastrar.addActionListener(new ListenerSalvar(txtCodigo, txtNome, txtPreco, txtQuantidade));
        btnCancelar.addActionListener(e -> {
            setVisible(false);
            dispose();
        });

        this.setVisible(true);
    }

    public static void exibirMensagem(Produto produto) {
        JDialog dialog = new JDialog();
        JOptionPane pane = new JOptionPane(
                produto.toString(),
                JOptionPane.INFORMATION_MESSAGE
        );

        dialog.setContentPane(pane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setAlwaysOnTop(true);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

}
