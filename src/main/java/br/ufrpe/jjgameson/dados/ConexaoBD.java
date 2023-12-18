package br.ufrpe.jjgameson.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://root:eDc3b6agDG11-1-1-DB61CgEfac363hh@roundhouse.proxy.rlwy.net:39211/railway";
    private static final String USUARIO = "root";
    private static final String SENHA = "eDc3b6agDG11-1-1-DB61CgEfac363hh";

    private static Connection conexao;

    // Método para obter a conexão
    public static Connection obterConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC do MySQL não encontrado", e);
        }
    }

    // Método para fechar a conexão
    public static void fecharConexao(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
