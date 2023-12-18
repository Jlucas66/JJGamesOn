package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Avaliacao;	


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
