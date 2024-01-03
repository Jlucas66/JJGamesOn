package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.AdminDuplicadoException;
import br.ufrpe.jjgameson.exceptions.AdminNaoEncontradoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAdmin implements IRepositorioAdmin{

    private ArrayList<Pessoa> admins;
    private static IRepositorioAdmin instance;

    private RepositorioAdmin() {
        admins = new ArrayList<>();
    }

    public static IRepositorioAdmin getInstance(){
        if(instance == null){
            instance = new RepositorioAdmin();
        }
        return instance;
    }

    @Override
    public void inserir(Pessoa admin) throws AdminDuplicadoException, AcessoInvalidoException, ElementoNuloException {
        if (admin != null && admin.isEhAdm() && !admins.contains(admin)) {
            admins.add(admin);
        } else {
            if (admin != null && !admin.isEhAdm()) {
                throw new AcessoInvalidoException("Apenas administradores podem ser cadastrados.");
            } else if (admins.contains(admin)) {
                throw new AdminDuplicadoException("Esse administrador ja foi cadastrado.");
            }
                else if (admin == null) {
                throw new ElementoNuloException("Administrador não pode ser nulo.");
            }
        }
    }


    @Override
    public List<Pessoa> listar() {
        return admins;
    }

    @Override
    public void atualizar(Pessoa adminAntigo, Pessoa adminNovo) throws AdminNaoEncontradoException {
        boolean encontrado = false;
        for (Pessoa pessoa : admins) {
            if (pessoa.equals(adminAntigo)) {
                int index = admins.indexOf(pessoa);
                admins.set(index, adminNovo);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new AdminNaoEncontradoException("Administrador não encontrado para atualização.");
        }
    }

    @Override
    public void excluir(Pessoa adminParaExcluir) throws AdminNaoEncontradoException {
        boolean encontrado = false;
        for (Pessoa admin : admins) {
            if (admin.equals(adminParaExcluir)) {
                admins.remove(admin);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new AdminNaoEncontradoException("Administrador não encontrado para exclusão.");
        }
    }
}
