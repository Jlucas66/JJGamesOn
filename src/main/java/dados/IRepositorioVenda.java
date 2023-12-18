package dados;

import entidades.Pessoa;
import entidades.Venda;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioVenda {
    public void inserir (Venda venda);
    public List<Venda> listar();
    public void atualizar (Venda venda);
    public void excluir(LocalDateTime dtVenda);
}
