package dados;

import entidades.Avaliacao;
import entidades.Pessoa;

import java.util.List;

public interface IRepositorioAdmin {
    public void inserir (Pessoa admin);
    public List<Pessoa> listar();
    public void atualizar (Pessoa admin);
    public void excluir(String email);
}
