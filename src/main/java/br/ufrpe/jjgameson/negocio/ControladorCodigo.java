package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioCodigo;
import br.ufrpe.jjgameson.dados.RepositorioCodigo;

public class ControladorCodigo {

    private IRepositorioCodigo repositorioCodigo;
    private static ControladorCodigo instance;

    private ControladorCodigo() {
        repositorioCodigo = RepositorioCodigo.getInstance();
    }

    public static ControladorCodigo getInstance(){
        if(instance == null){
            instance = new ControladorCodigo();
        }
        return instance;
    }

    public void inserir(String codigo){
        repositorioCodigo.inserir(codigo);
    }

    public void listar(){
        repositorioCodigo.listar();
    }
}
