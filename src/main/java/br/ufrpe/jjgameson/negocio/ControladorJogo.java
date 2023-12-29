package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioJogo;
import br.ufrpe.jjgameson.dados.RepositorioJogo;
import br.ufrpe.jjgameson.entidades.Jogo;

public class ControladorJogo {

    private IRepositorioJogo repositorioJogo;
    private static ControladorJogo instance;

    private ControladorJogo() {
        repositorioJogo = RepositorioJogo.getInstance();
    }

    public static ControladorJogo getInstance(){
        if(instance == null){
            instance = new ControladorJogo();
        }
        return instance;
    }

    public void inserirJogo(Jogo jogo){
        repositorioJogo.inserirJogo(jogo);
    }

    public Jogo obterJogoPorId(int id){
        return repositorioJogo.obterJogoPorId(id);
    }

    public void removerJogo(Jogo jogoParaExcluir){
        repositorioJogo.removerJogo(jogoParaExcluir);
    }

    public void atualizarJogo(Jogo jogoAntigo, Jogo jogoNovo){
        repositorioJogo.atualizarJogo(jogoAntigo, jogoNovo);
    }

    public void listarJogos(){
        repositorioJogo.listarJogos();
    }
}
