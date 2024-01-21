package br.ufrpe.jjgameson.dados;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCodigo implements IRepositorioCodigo {

    private List<String> codigos;
    private static IRepositorioCodigo instance;

    private RepositorioCodigo() {
        codigos = new ArrayList<>();
    }

    public static IRepositorioCodigo getInstance(){
        if(instance == null){
            instance = new RepositorioCodigo();
        }
        return instance;
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
