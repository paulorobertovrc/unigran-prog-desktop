package db;

import java.sql.*;

public class Database {
    private static final String DB_NAME = "unigran";
    private static Connection conn;

    public static Connection connect() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/";
            String username = "root";
            String password = "12345678";

            conn = DriverManager.getConnection(url + DB_NAME, username, password);
            createTable();

            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível estabelecer a conexão com o banco de dados.");
        }
    }

    private static void createTable() {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS `" + DB_NAME + "`.`tbProduto` (" +
                    "`codigo` VARCHAR(10) NOT NULL," +
                    "`nome` VARCHAR(100) NOT NULL," +
                    "`preco` DOUBLE NOT NULL," +
                    "`quantidade` INT NOT NULL," +
                    "PRIMARY KEY (`codigo`));");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível criar a tabela de produtos.");
        }
    }

}
