package dados;

import java.util.List;

import entidades.Avaliacao;

public interface IRepositorioAvaliacao {

	public void inserir (Avaliacao avaliacao);
	public List<Avaliacao> listar();
	public void atualizar (Avaliacao avaliacao); 
	public void excluir(int id);
}
