package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Jogo;
import br.ufrpe.jjgameson.exceptions.DBException;
import br.ufrpe.jjgameson.gui.GerenciadorDeTelas;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class RepositorioJogo implements IRepositorioJogo {

    private ArrayList<Jogo> jogos;
    private static IRepositorioJogo instance;

    private RepositorioJogo() {
        jogos = new ArrayList<>();
    }

    public static IRepositorioJogo getInstance(){
        if(instance == null){
            instance = new RepositorioJogo();
        }
        return instance;
    }
    @Override
    public void inserirJogo(Jogo jogo) {
        if(jogo != null){
            jogos.add(jogo);
        }
    }

    @Override
    public void inserirJogoBD(Jogo jogo) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            st.executeUpdate("INSERT INTO Jogo (nomeJogo, desenvolvedora, genero, faixaEtaria, resumo, valor, URL, id) VALUES ('" + jogo.getNome() + "', '" + jogo.getDesenvolvedora() + "', '" + jogo.getGenero() + "', '" + jogo.getFaixaEtaria() + "', '" + jogo.getResumo() + "', '" + jogo.getValor() + "', '" + jogo.getPath() + " ', '" + jogo.getId() + "')");
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
    public Jogo obterJogoPorId(int id) {
        for (Jogo jogo : jogos) {
            if(jogo.getId() == id) return jogo;
        }
        return null;
    }

    public Jogo obterJogoPorIdBD(int id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Jogo jogo = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Jogo WHERE IdJogo = " + id);
            if(rs.next()){
                jogo = new Jogo(rs.getInt("idJogo"), rs.getString("URL"), rs.getString("nomeJogo"), rs.getDouble("valor"), rs.getString("desenvolvedora"), rs.getString("genero"), rs.getString("resumo"), rs.getString("faixaEtaria"));
            }
        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
        return jogo;
    }
    @Override
    public void removerJogo(Jogo jogoParaExcluir) {
        for (Jogo jogo : jogos) {
            if (jogo.equals(jogoParaExcluir)) {
                jogos.remove(jogo);
                break;
            }
        }
    }

    public void removerJogoBD(int id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM Jogo WHERE IdJogo = " + id);
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
    public void atualizarJogo(Jogo jogoAntigo, Jogo jogoNovo) {
        for (Jogo jogo : jogos) {
            if (jogo.equals(jogoAntigo)) {
                int index = jogos.indexOf(jogo);
                jogos.set(index, jogoNovo);
                break;
            }
        }
    }

    public void atualizarJogoBD(Jogo jogoAntigo, Jogo jogoNovo) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            st.executeUpdate("UPDATE Jogo SET nomeJogo = '" + jogoNovo.getNome() + "', desenvolvedora = '" + jogoNovo.getDesenvolvedora() + "', genero = '" + jogoNovo.getGenero() + "', faixaEtaria = '" + jogoNovo.getFaixaEtaria() + "', resumo = '" + jogoNovo.getResumo() + "', valor = '" + jogoNovo.getValor() + "', path = '" + jogoNovo.getPath() + "' WHERE IdJogo = " + jogoAntigo.getId());
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
    public List<Jogo> listarJogos() {
        return jogos;
    }

    public List<Jogo> listarJogosBD() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<Jogo> jogos = new ArrayList<>();

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Jogo");
            while(rs.next()){
                Jogo jogo = new Jogo(rs.getInt("idJogo"), rs.getString("URL"), rs.getString("nomeJogo"), rs.getDouble("valor"), rs.getString("desenvolvedora"), rs.getString("genero"), rs.getString("resumo"), rs.getString("faixaEtaria"));
                jogos.add(jogo);
            }
        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
        return jogos;
    }
}
