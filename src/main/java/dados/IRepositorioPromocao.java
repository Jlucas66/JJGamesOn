package dados;

import entidades.Pessoa;
import entidades.Promocao;

import java.util.List;

public interface IRepositorioPromocao {
    public void inserir (Promocao promocao);
    public List<Promocao> listar();
    public void atualizar (Promocao promocao);
    public void excluir(int idPromocao);
}
