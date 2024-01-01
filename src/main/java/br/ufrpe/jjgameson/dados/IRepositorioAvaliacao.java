package br.ufrpe.jjgameson.dados;

import java.util.List;

import br.ufrpe.jjgameson.entidades.Avaliacao;
import br.ufrpe.jjgameson.exceptions.ClienteNuloException;
import br.ufrpe.jjgameson.exceptions.JogoNuloException;
import br.ufrpe.jjgameson.exceptions.NotaInvalidaException;

public interface IRepositorioAvaliacao {

	public void inserir (Avaliacao avaliacao) throws ClienteNuloException, JogoNuloException;
	public List<Avaliacao> listar();
	public void atualizar (Avaliacao avaliacao, Avaliacao novaAvaliacao);
	public void excluir(Avaliacao avaliacaoParaExcluir);
}
