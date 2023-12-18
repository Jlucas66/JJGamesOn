package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Codigo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCodigo implements IRepositorioCodigo {

    private List<String> codigos;

    public RepositorioCodigo() {
        codigos = new ArrayList<>();
    }

    @Override
    public void inserir(String codigo) {
        if(codigo != null && !codigo.isEmpty()) {
            codigos.add(codigo);
        }
    }

    @Override
    public List<String> listar() {
        return new ArrayList<>(codigos);
    }
}
