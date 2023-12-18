package dados;

import entidades.Codigo;

import java.util.List;

public interface IRepositorioCodigo {
    public void inserir (Codigo codigo);
    public List<Codigo> listar();
}
