package br.ufrpe.jjgameson.dados;

import java.util.List;

import br.ufrpe.jjgameson.entidades.Avaliacao;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;

public interface IRepositorioAvaliacao {

	public void inserir (Avaliacao avaliacao);
	public List<Avaliacao> listar();
	public void atualizar (Avaliacao avaliacao, Avaliacao novaAvaliacao);
	public void excluir(Avaliacao avaliacaoParaExcluir);
	void inserirBD(Avaliacao avaliacao);
	void listarBD(Avaliacao avaliacao);
	void atualizarBD(Avaliacao avaliacao);
	void excluirBD(Avaliacao avaliacao);
}
