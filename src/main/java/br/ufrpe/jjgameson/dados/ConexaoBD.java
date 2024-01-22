package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.exceptions.DBException;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ConexaoBD {

    private static Connection conn = null;

    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("src/main/resources/br/ufrpe/jjgameson/db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (Exception e){
            throw new DBException(e.getMessage());
        }
    }

            return DriverManager.getConnection(URL, USUARIO, SENHA);
    public static Connection getConnection(){
        if (conn == null){
            try {
                Properties pops = loadProperties();;
                String url = pops.getProperty("dburl");
                conn = DriverManager.getConnection(url, pops);
            }
            catch (SQLException e){
                throw new DBException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection(){
        if (conn != null){
            try {
                conn.close();
            }
            catch (SQLException e){
                throw new DBException(e.getMessage());
            }
        }
    }

    public static void closeStatement(java.sql.Statement st){
        if (st != null){
            try {
                st.close();
            }
            catch (SQLException e){
                throw new DBException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(java.sql.ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            }
            catch (SQLException e){
                throw new DBException(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from Cliente");

            while (rs.next()){
                System.out.println(rs.getString("emailCliente") + " " + rs.getString("nome") + " " + rs.getDate("dtNascimento"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            ConexaoBD.closeResultSet(rs);
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeConnection();
        }

    }
}
