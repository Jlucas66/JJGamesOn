package dados;

import entidades.Avaliacao;
import entidades.ItemVenda;

import java.util.List;

public interface IRepositorioItemVenda {
    public void inserir (ItemVenda itemVenda);
    public List<ItemVenda> listar();
    public void atualizar (ItemVenda itemVenda);
    public void excluir(int idItemVenda);
}
