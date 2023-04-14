package view;

import modelo.Produto;
import modelo.ProdutoDao;

import javax.swing.*;
import java.awt.*;

public class TelaListagem extends JFrame {
    private final ProdutoDao produtoDao = ProdutoDao.getInstance();

    public TelaListagem() {
        this.initialize();
        this.setExtendedState(JFrame.NORMAL);
    }

    private void initialize() {
        this.setTitle("Listagem de Produtos");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(10, 10, 570, 300);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(null);
        painelBotoes.setBounds(10, 320, 570, 40);

        JLabel lblTitulo = new JLabel("Listagem de Produtos");
        lblTitulo.setBounds(10, 10, 150, 20);

        JButton btnNovo = new JButton("Novo");
        btnNovo.setBounds(10, 0, 100, 20);

        JButton btnApagar = new JButton("Apagar");
        btnApagar.setBounds(120, 0, 100, 20);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(230, 0, 100, 20);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem menuNovo = new JMenuItem("Novo");
        JMenuItem menuSair = new JMenuItem("Sair");

        JList<Produto> lista = new JList<>();
        lista.setBounds(10, 40, 550, 250);
        lista.setModel(produtoDao.listar());

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(10, 40, 550, 250);

        menuArquivo.add(menuNovo);
        menuArquivo.addSeparator();
        menuArquivo.add(menuSair);

        menuBar.add(menuArquivo);

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnApagar);
        painelBotoes.add(btnSair);

        painel.add(lblTitulo);
        painel.add(scroll, BorderLayout.CENTER);

        this.add(painel);
        this.add(painelBotoes);

        this.setJMenuBar(menuBar);

        btnNovo.addActionListener(e -> exibirTelaCadastro());

        btnSair.addActionListener(e -> sair());

        menuNovo.addActionListener(e -> exibirTelaCadastro());

        menuSair.addActionListener(e -> sair());
    }

    private void exibirTelaCadastro() {
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.setVisible(true);
        this.setVisible(false);
    }

    private void sair() {
        setVisible(false);
        dispose();
        System.exit(0);
    }

}
