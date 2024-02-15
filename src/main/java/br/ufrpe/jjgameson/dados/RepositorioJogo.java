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
    public Jogo obterJogoPorNome(String nome) {
        for (Jogo jogo : jogos) {
            if(jogo.getNome().equalsIgnoreCase(nome)) return jogo;
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
}