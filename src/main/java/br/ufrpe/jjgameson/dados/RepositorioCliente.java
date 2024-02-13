package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.DBException;
import br.ufrpe.jjgameson.gui.GerenciadorDeTelas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements IRepositorioCliente {

    private ArrayList<Pessoa> clientes;
    private static IRepositorioCliente instance;

    private RepositorioCliente() {
        clientes = new ArrayList<>();
    }

    public static IRepositorioCliente getInstance() {
        if (instance == null) {
            instance = new RepositorioCliente();
        }
        return instance;
    }


    @Override
    public void inserirCliente(Pessoa cliente) {
        clientes.add(cliente);
    }

    @Override
    public void inserirClienteBD(Pessoa cliente) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            st.executeUpdate("INSERT INTO Cliente (nome, emailCliente, senha, dtNascimento) VALUES ('" + cliente.getNome() + "', '" + cliente.getEmail() + "', '" + cliente.getSenha() + "', '" + cliente.getDataNascimento() + "')");
        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
    }

    @Override
    public Pessoa obterClientePorEmail(String email) {
        for (Pessoa cliente : clientes) {
            if (cliente.getEmail().equals(email)) return cliente;
        }
        return null;
    }
    public Pessoa obterClientePorEmailBD(String email){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Pessoa cliente = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Cliente WHERE emailCliente = '" + email + "'");

            if (rs.next()){
                cliente = new Pessoa(rs.getString("nome"), rs.getString("emailCliente"), rs.getString("senha"), rs.getDate("dtNascimento").toLocalDate(), false);
            }
        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
        return cliente;
    }

    @Override
    public boolean VerificarUsuarioLoginBD(String email, String senha) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Cliente WHERE emailCliente = '" + email + "'");

            if (rs.next()){
                if (rs.getString("senha").equals(senha)){
                    return true;
                }
                else{
                    GerenciadorDeTelas.exibirAlertaMensagem("Erro", "Senha incorreta!");
                    throw new AcessoInvalidoException("Senha incorreta!");
                }
            }
            else{
                GerenciadorDeTelas.exibirAlertaMensagem("Erro", "Email não cadastrado!");
                throw new AcessoInvalidoException("Email não cadastrado!");
            }

        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        } catch (AcessoInvalidoException e) {
            throw new RuntimeException(e);
        } finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
    }

    @Override
    public void removerCliente(String email) {
        if (email != null) {
            for (Pessoa cliente : clientes) {
                if (cliente.getEmail().equals(email)) {
                    clientes.remove(cliente);
                    break;
                }
            }
        }

    }
    public void removerClienteBD(String email) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM Cliente WHERE emailCliente = '" + email + "'");
        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
    }

    @Override
    public void atualizarCliente(Pessoa clienteAntigo, Pessoa clienteNovo) {
        for (Pessoa cliente : clientes) {
            if (cliente.equals(clienteAntigo)) {
                int index = clientes.indexOf(cliente);
                clientes.set(index, clienteNovo);
                break;
            }
        }
    }

    public void atualizarClienteBD(String email){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            st.executeUpdate("UPDATE Cliente SET nome = '" + email + "' WHERE emailCliente = '" + email + "'");
        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        finally {
            ConexaoBD.closeConnection();
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
    }

    @Override
    public List<Pessoa> listarClientes() {
        return clientes;
    }

    public List<Pessoa> listarClientesBD() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Cliente");

            while (rs.next()){
                System.out.println(rs.getString("nome") + " " + rs.getString("emailCliente") + " " + rs.getDate("dtNascimento"));
            }

        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        finally {
            ConexaoBD.closeConnection();
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
        return null;
    }

}
