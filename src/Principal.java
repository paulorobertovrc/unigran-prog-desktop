import javax.swing.*;

// Utilizar caixas de diálogo JOptionPane para ler os atributos de um objeto Produto
// e exibir o resultado da chamada do método toString() do objeto Produto.

public class Principal {
    public static void main(String[] args) {

        Produto produto = new Produto(
            JOptionPane.showInputDialog(null,
                    "Código do produto: ",
                    "Cadastro de Produto",
                    JOptionPane.QUESTION_MESSAGE),

            JOptionPane.showInputDialog(null,
                    "Nome do produto: ",
                    "Cadastro de Produto",
                    JOptionPane.QUESTION_MESSAGE),

            Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Preço do produto: ",
                    "Cadastro de Produto",
                    JOptionPane.QUESTION_MESSAGE)),

            Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Quantidade do produto: ",
                    "Cadastro de Produto",
                    JOptionPane.QUESTION_MESSAGE))
        );

        JOptionPane.showMessageDialog(null,
                produto.toString(),
                "Produto Cadastrado",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
