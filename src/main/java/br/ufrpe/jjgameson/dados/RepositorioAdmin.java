package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Pessoa;

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
    public void inserir(Pessoa admin) {
        if(admin != null && admin.isEhAdm()){
            admins.add(admin);
        }
    }

    @Override
    public List<Pessoa> listar() {
        return admins;
    }

    @Override
    public void atualizar(Pessoa adminAntigo, Pessoa adminNovo) {
        for (Pessoa pessoa : admins) {
            if (admins.equals(adminAntigo)){
                int index = admins.indexOf(adminNovo);
                admins.set(index, adminNovo);
                break;
            }
        }
    }

    @Override
    public void excluir(Pessoa adminParaExcluir) {
        for (Pessoa admin : admins){
            if (admin.equals(adminParaExcluir)){
                admins.remove(admin);
                break;
            }
        }
    }
}
