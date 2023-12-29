package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioAvaliacao;
import br.ufrpe.jjgameson.dados.RepositorioAvaliacao;
import br.ufrpe.jjgameson.entidades.Avaliacao;

public class ControladorAvaliacao {

    private IRepositorioAvaliacao repositorioAvaliacao;
    private static ControladorAvaliacao instance;

    private ControladorAvaliacao() {
        repositorioAvaliacao = RepositorioAvaliacao.getInstance();
    }

    public static ControladorAvaliacao getInstance(){
        if(instance == null){
            instance = new ControladorAvaliacao();
        }
        return instance;
    }

    public void inserirAvaliacao(Avaliacao avaliacao){
        repositorioAvaliacao.inserir(avaliacao);
    }

    public void listarAvaliacoes(){
        repositorioAvaliacao.listar();
    }

    public void atualizarAvaliacao(Avaliacao avaliacaoAntiga, Avaliacao novaAvaliacao){
        repositorioAvaliacao.atualizar(avaliacaoAntiga, novaAvaliacao);
    }

    public void excluirAvaliacao(Avaliacao avaliacaoParaExcluir){
        repositorioAvaliacao.excluir(avaliacaoParaExcluir);
    }
}
