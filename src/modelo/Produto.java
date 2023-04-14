package modelo;

import java.text.NumberFormat;

public class Produto {
    private final String codigo;
    private final String nome;
    private final double preco;
    private final int quantidade;

    public Produto(String codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Código:     " + this.codigo + "     |       Nome:     " + this.nome + "     |       Preço:      " +
                NumberFormat.getCurrencyInstance().format(this.preco) + "       |     Quantidade:     " + this.quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
