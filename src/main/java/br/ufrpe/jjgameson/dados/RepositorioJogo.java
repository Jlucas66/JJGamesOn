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
            st.executeUpdate("INSERT INTO Jogo (nomeJogo, desenvolvedora, genero, faixaEtaria, resumo, valor, path, id) VALUES ('" + jogo.getNome() + "', '" + jogo.getDesenvolvedora() + "', '" + jogo.getGenero() + "', '" + jogo.getFaixaEtaria() + "', '" + jogo.getResumo() + "', '" + jogo.getValor() + "', '" + jogo.getPath() + " ', '" + jogo.getId() + "')");
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

    @Override
    public void removerJogo(Jogo jogoParaExcluir) {
        for (Jogo jogo : jogos) {
            if (jogo.equals(jogoParaExcluir)) {
                jogos.remove(jogo);
                break;
            }
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

    @Override
    public List<Jogo> listarJogos() {
        return jogos;
    }

    @Override
    public boolean obterJogoPorIdBD(int id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Jogo WHERE id = " + id);
            if(rs.next()){
                return true;
            }
        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
        return false;
    }
}
