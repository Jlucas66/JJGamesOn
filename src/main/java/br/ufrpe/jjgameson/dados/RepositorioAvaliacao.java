package br.ufrpe.jjgameson.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.jjgameson.entidades.Avaliacao;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;


public class RepositorioAvaliacao implements IRepositorioAvaliacao {

	private ArrayList<Avaliacao> avaliacoes;
	private static IRepositorioAvaliacao instance;

	private RepositorioAvaliacao() {
		avaliacoes = new ArrayList<>();
	}
	public static IRepositorioAvaliacao getInstance(){
		if(instance == null){
			instance = new RepositorioAvaliacao();
		}
		return instance;
	}

	@Override
	public void inserir(Avaliacao avaliacao) throws ElementoNuloException {
		if (avaliacao.getCliente() == null) {
				throw new ElementoNuloException("Cliente não pode ser nulo.");
			}

			if (avaliacao.getJogo() == null) {
				throw new ElementoNuloException("Jogo não pode ser nulo.");
			}

			avaliacoes.add(avaliacao);
		}

	@Override
	public List<Avaliacao> listar() {
		return avaliacoes;
	}

	@Override
	public void atualizar(Avaliacao avaliacaoAntiga, Avaliacao novaAvaliacao) {
		for (Avaliacao avaliacao : avaliacoes) {
			if (avaliacao.equals(avaliacaoAntiga)) {
				int index = avaliacoes.indexOf(avaliacao);
				avaliacoes.set(index, novaAvaliacao);
				break;
			}
		}
	}

	@Override
	public void excluir(Avaliacao avaliacaoParaExcluir) {
		for (Avaliacao avaliacao : avaliacoes) {
			if (avaliacao.equals(avaliacaoParaExcluir)) {
				avaliacoes.remove(avaliacao);
				break;
			}
		}
	}
}
