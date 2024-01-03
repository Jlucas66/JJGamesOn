package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAdmin implements IRepositorioAdmin {

    private ArrayList<Pessoa> admins;
    private static IRepositorioAdmin instance;

    private RepositorioAdmin() {
        admins = new ArrayList<>();
    }

    public static IRepositorioAdmin getInstance() {
        if (instance == null) {
            instance = new RepositorioAdmin();
        }
        return instance;
    }

    @Override
    public void inserir(Pessoa admin) {
        admins.add(admin);
    }


    @Override
    public List<Pessoa> listar() {
        return admins;
    }

    @Override
    public void atualizar(Pessoa adminAntigo, Pessoa adminNovo) {
        admins.set(admins.indexOf(adminAntigo), adminNovo);
    }

    @Override
    public void excluir(Pessoa adminParaExcluir) {
        admins.remove(adminParaExcluir);
    }
}
