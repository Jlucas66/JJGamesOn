package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Promocao;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPromocao implements IRepositorioPromocao{

    private ArrayList<Promocao> promocoes;
    private static IRepositorioPromocao instance;

    private RepositorioPromocao() {
        promocoes = new ArrayList<>();
    }

    public static IRepositorioPromocao getInstance(){
        if(instance == null){
            instance = new RepositorioPromocao();
        }
        return instance;
    }
    @Override
    public void inserir(Promocao promocao) {
        if(promocao != null){
            promocoes.add(promocao);
        }
    }

    @Override
    public List<Promocao> listar() {
        return promocoes;
    }

    @Override
    public void atualizar(Promocao promocaoAntiga, Promocao promocaoNova) {
        for (Promocao promocao : promocoes) {
            if (promocao.equals(promocaoAntiga)) {
                int index = promocoes.indexOf(promocao);
                promocoes.set(index, promocaoNova);
                break;
            }
        }
    }

    @Override
    public void excluir(Promocao promocaoParaExcluir) {
        for (Promocao promocao : promocoes) {
            if (promocao.equals(promocaoParaExcluir)) {
                promocoes.remove(promocao);
                break;
            }
        }
    }
}
