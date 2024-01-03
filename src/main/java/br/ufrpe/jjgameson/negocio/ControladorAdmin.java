package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioAdmin;
import br.ufrpe.jjgameson.dados.RepositorioAdmin;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.ElementoDuplicadoException;
import br.ufrpe.jjgameson.exceptions.ElementoNaoEncontradoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;

import java.util.List;

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

    public void inserir(Pessoa admin) throws AcessoInvalidoException, ElementoDuplicadoException, ElementoNuloException {
        if (admin == null) {
            throw new ElementoNuloException("Administrador não pode ser nulo.");
        }
        if (!admin.isEhAdm()) {
            throw new AcessoInvalidoException("Apenas administradores podem ser cadastrados.");
        }
        if (repositorioAdmin.listar().contains(admin)) {
            throw new ElementoDuplicadoException("Esse administrador ja foi cadastrado.");
        }

        repositorioAdmin.inserir(admin);
    }

    public void listar(){
        repositorioAdmin.listar();
    }

    public void atualizar(Pessoa adminAntigo, Pessoa adminNovo) throws ElementoNaoEncontradoException, ElementoNuloException, AcessoInvalidoException {
        if (adminAntigo == null || adminNovo == null) {
            throw new ElementoNuloException("Administrador não pode ser nulo.");
        }
        List<Pessoa> admins = repositorioAdmin.listar();
        boolean adminEncontrado = false;

        for (Pessoa admin : admins) {
            if (admin.equals(adminAntigo)) {
                adminEncontrado = true;
                break;
            }
        }

        if (adminEncontrado == false) {
            throw new ElementoNaoEncontradoException("Administrador não encontrado para atualização.");
        }
        if (adminNovo.isEhAdm() == false) {
            throw new AcessoInvalidoException("Apenas administradores podem ser cadastrados.");
        }

        repositorioAdmin.atualizar(adminAntigo, adminNovo);
    }

    public void excluir(Pessoa adminParaExcluir) throws ElementoNaoEncontradoException, ElementoNuloException {
        if (adminParaExcluir == null) {
            throw new ElementoNuloException("Administrador não pode ser nulo.");
        }

        List<Pessoa> admins = repositorioAdmin.listar();
        boolean adminEncontrado = false;

        for (Pessoa admin : admins) {
            if (admin.equals(adminParaExcluir)) {
                adminEncontrado = true;
                break;
            }
        }

        if (adminEncontrado == false) {
            throw new ElementoNaoEncontradoException("Administrador não encontrado para exclusão.");
        }

        repositorioAdmin.excluir(adminParaExcluir);
    }
}
