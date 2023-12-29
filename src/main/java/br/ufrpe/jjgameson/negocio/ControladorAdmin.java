package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioAdmin;
import br.ufrpe.jjgameson.dados.RepositorioAdmin;
import br.ufrpe.jjgameson.entidades.Pessoa;

public class ControladorAdmin {

    private IRepositorioAdmin repositorioAdmin;
    private static ControladorAdmin instance;

    private ControladorAdmin() {
        repositorioAdmin = RepositorioAdmin.getInstance();
    }

    public static ControladorAdmin getInstance(){
        if(instance == null){
            instance = new ControladorAdmin();
        }
        return instance;
    }

    public void inserir(Pessoa admin){
        repositorioAdmin.inserir(admin);
    }

    public void listar(){
        repositorioAdmin.listar();
    }

    public void atualizar(Pessoa adminAntigo, Pessoa adminNovo){
        repositorioAdmin.atualizar(adminAntigo, adminNovo);
    }

    public void excluir(Pessoa adminParaExcluir){
        repositorioAdmin.excluir(adminParaExcluir);
    }
}
