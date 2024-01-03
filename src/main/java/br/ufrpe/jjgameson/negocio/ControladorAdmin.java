package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioAdmin;
import br.ufrpe.jjgameson.dados.RepositorioAdmin;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.AdminDuplicadoException;
import br.ufrpe.jjgameson.exceptions.AdminNaoEncontradoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;

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

    public void inserir(Pessoa admin) throws AcessoInvalidoException, AdminDuplicadoException, ElementoNuloException {
        repositorioAdmin.inserir(admin);
    }

    public void listar(){
        repositorioAdmin.listar();
    }

    public void atualizar(Pessoa adminAntigo, Pessoa adminNovo) throws AdminNaoEncontradoException {
        repositorioAdmin.atualizar(adminAntigo, adminNovo);
    }

    public void excluir(Pessoa adminParaExcluir) throws AdminNaoEncontradoException {
        repositorioAdmin.excluir(adminParaExcluir);
    }
}
