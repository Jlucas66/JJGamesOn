package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.*;
import br.ufrpe.jjgameson.gui.GerenciadorDeTelas;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.DBException;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAdmin implements IRepositorioAdmin {

    private ArrayList<Pessoa> admins;
    private static IRepositorioAdmin instance;

    private RepositorioAdmin() {
        admins = new ArrayList<>();
    }

    public static IRepositorioAdmin getInstance() {
        if (instance == null) {
            instance = new RepositorioAdmin();
        }
        return instance;
    }

    @Override
    public void inserir(Pessoa admin) {
        admins.add(admin);
    }
    
    @override
    
    public void inserirPessoaAdminBD(Pessoa pessoa) {
    	Connection conn = null;
    	Statement st = null;
    	ResultSet rs = null;
    	
        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            st.executeUpdate("INSERT INTO Pessoa (nome, email, senha, dataNascimento) VALUES ('" + pessoa.getNome() + "', '" + pessoa.getEmail() + "', '" + pessoa.getSenha() + "', '" + pessoa.getDataNascimento() + "')");
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
    public List<Pessoa> listar() {
        return admins;
    }

    public boolean verificarloginADMBD(String email, String senha) throws AcessoInvalidoException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Administrador WHERE emailAdministrador = '" + email + "'");

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
    public void removerPessoaAdmineBD(Pessoa pessoa) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM Pessoa WHERE emailCliente = '" + email + "'");
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
// atualizarPessoaAdminBD esta atualizando um nome com ele mesmo, deve atualizar uma pessoa com outra
    private void atualizarPessoaAdminBD(Pessoa pessoa){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            st.executeUpdate("UPDATE Pessoa SET nome = '" + pessoa + "' WHERE email = '" + pessoa + "'");
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
    public void listarPessoaAdminsBD() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Pessoa");

            while (rs.next()){  // deve retornar uma lista pra poder ser usado no controlador
                System.out.println(rs.getString("nome") + " " + rs.getString("email") + " " + rs.getDate("dtNascimento"));
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
    }

    @Override
    public void atualizar(Pessoa adminAntigo, Pessoa adminNovo) {
        admins.set(admins.indexOf(adminAntigo), adminNovo);
    }

    @Override
    public void excluir(Pessoa adminParaExcluir) {
        admins.remove(adminParaExcluir);
    }
}
