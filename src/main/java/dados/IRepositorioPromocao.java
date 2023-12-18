package dados;

import entidades.Pessoa;
import entidades.Promocao;

import java.util.List;

public interface IRepositorioPromocao {
    public void inserir (Promocao promocao);
    public List<Promocao> listar();
    public void atualizar (Promocao promocaoAntiga, Promocao promocaoNova);
    public void excluir(Promocao promocaoParaExcluir);
}
