import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerSalvar implements ActionListener {
    private final JTextField txtCodigo;
    private final JTextField txtNome;
    private final JTextField txtPreco;
    private final JTextField txtQuantidade;

    public ListenerSalvar(JTextField txtCodigo,
                          JTextField txtNome,
                          JTextField txtPreco,
                          JTextField txtQuantidade) {
        this.txtCodigo = txtCodigo;
        this.txtNome = txtNome;
        this.txtPreco = txtPreco;
        this.txtQuantidade = txtQuantidade;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Produto produto = new Produto(
                txtCodigo.getText(),
                txtNome.getText(),
                Double.parseDouble(txtPreco.getText()),
                Integer.parseInt(txtQuantidade.getText())
        );

        JOptionPane.showMessageDialog(null,
                produto.toString(),
                "Produto Cadastrado",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
