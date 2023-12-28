package br.ufrpe.jjgameson.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://root:B1b54ACg-2B155gAd-4EdbG5ffhGea2D@viaduct.proxy.rlwy.net:26602/railway";
    private static final String USUARIO = "root";
    private static final String SENHA = "B1b54ACg-2B155gAd-4EdbG5ffhGea2D";

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
