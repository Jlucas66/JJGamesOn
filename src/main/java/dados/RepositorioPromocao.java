package dados;

import entidades.Avaliacao;
import entidades.Promocao;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPromocao implements IRepositorioPromocao{

    private ArrayList<Promocao> promocoes;

    public RepositorioPromocao() {
        promocoes = new ArrayList<>();
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
