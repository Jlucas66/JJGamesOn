package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioAvaliacao;
import br.ufrpe.jjgameson.dados.RepositorioAvaliacao;
import br.ufrpe.jjgameson.entidades.Avaliacao;
import br.ufrpe.jjgameson.exceptions.ElementoNaoEncontradoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;
import br.ufrpe.jjgameson.exceptions.NotaInvalidaException;

import java.util.List;

public class ControladorAvaliacao {

    private IRepositorioAvaliacao repositorioAvaliacao;
    private static ControladorAvaliacao instance;

    private ControladorAvaliacao() {
        repositorioAvaliacao = RepositorioAvaliacao.getInstance();
    }

    public static ControladorAvaliacao getInstance() {
        if (instance == null) {
            instance = new ControladorAvaliacao();
        }
        return instance;
    }

    public void inserirAvaliacao(Avaliacao avaliacao) throws ElementoNuloException, NotaInvalidaException {
        if (avaliacao == null) {
            throw new ElementoNuloException("Avaliação não pode ser nula.");
        }
        if (avaliacao.getCliente() == null) {
            throw new ElementoNuloException("Cliente não pode ser nulo.");
        }
        if (avaliacao.getJogo() == null) {
            throw new ElementoNuloException("Jogo não pode ser nulo.");
        }
        if (avaliacao.getNota() < 1 || avaliacao.getNota() > 5) {
            throw new NotaInvalidaException("A nota da avaliação deve estar entre 1 e 5.");
        } else {
            repositorioAvaliacao.inserir(avaliacao);
        }
    }

    public void listarAvaliacoes() {
        repositorioAvaliacao.listar();
    }

    public void atualizarAvaliacao(Avaliacao avaliacaoAntiga, Avaliacao novaAvaliacao) throws ElementoNuloException, NotaInvalidaException, ElementoNaoEncontradoException {
        if (avaliacaoAntiga == null || novaAvaliacao == null) {
            throw new ElementoNuloException("Avaliação não pode ser nula.");
        }

        List<Avaliacao> avaliacoes = repositorioAvaliacao.listar();
        boolean avaliacaoEncontrada = false;

        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.equals(avaliacaoAntiga)) {
                avaliacaoEncontrada = true;
                break;
            }
        }

        if (avaliacaoEncontrada == false) {
            throw new ElementoNaoEncontradoException("Avaliação não encontrada.");
        }

        // Verificar se a nova avaliação é válida antes de chamar o método atualizar
        if (novaAvaliacao.getNota() < 1 || novaAvaliacao.getNota() > 5) {
            throw new NotaInvalidaException("A nota da avaliação deve estar entre 1 e 5.");
        }

        repositorioAvaliacao.atualizar(avaliacaoAntiga, novaAvaliacao);
    }


    public void excluirAvaliacao(Avaliacao avaliacaoParaExcluir) throws ElementoNuloException, ElementoNaoEncontradoException {
        if (avaliacaoParaExcluir == null) {
            throw new ElementoNuloException("Avaliação não pode ser nula.");
        }

        List<Avaliacao> avaliacoes = repositorioAvaliacao.listar();
        boolean avaliacaoEncontrada = false;

        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.equals(avaliacaoParaExcluir)) {
                avaliacaoEncontrada = true;
                break;
            }
        }

        if (avaliacaoEncontrada == false) {
            throw new ElementoNaoEncontradoException("Avaliação não encontrada.");
        }

        repositorioAvaliacao.excluir(avaliacaoParaExcluir);
    }
}
