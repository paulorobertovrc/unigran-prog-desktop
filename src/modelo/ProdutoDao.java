package modelo;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDao {
    private static ProdutoDao instance;
    private static final Connection connection = Database.connect();

    private ProdutoDao() {
    }

    public static ProdutoDao getInstance() {
        if (instance == null) instance = new ProdutoDao();

        return instance;
    }

    public void inserir(Produto produto) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO tbProduto (codigo, nome, preco, quantidade) VALUES (?, ?, ?, ?);");
            ps.setString(1, produto.getCodigo());
            ps.setString(2, produto.getNome());
            ps.setDouble(3, produto.getPreco());
            ps.setInt(4, produto.getQuantidade());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível inserir o produto no banco de dados.");
        }
    }

}
