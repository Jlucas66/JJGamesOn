package dados;

import entidades.Codigo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCodigo implements IRepositorioCodigo {

    private ArrayList<Codigo> codigos;

    public RepositorioCodigo() {
        codigos = new ArrayList<>();
    }
    @Override
    public void inserir(Codigo codigo) {
        if(codigo != null){
            codigos.add(codigo);
        }
    }

    @Override
    public List<Codigo> listar() {
        return codigos;
    }
}
