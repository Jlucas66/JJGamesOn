package dados;

import entidades.Avaliacao;
import entidades.Codigo;

import java.util.List;

public interface IRepostorioCodigo {
    public void inserir (Codigo codigo);
    public List<Codigo> listar();
}
