package br.ufrpe.jjgameson.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.jjgameson.entidades.Avaliacao;


public class RepositorioAvaliacao implements IRepositorioAvaliacao {

	private ArrayList<Avaliacao> avaliacoes;

	public RepositorioAvaliacao() {
		avaliacoes = new ArrayList<>();
	}

	@Override
	public void inserir(Avaliacao avaliacao) {
		if(avaliacao != null){
			avaliacoes.add(avaliacao);
		}
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
