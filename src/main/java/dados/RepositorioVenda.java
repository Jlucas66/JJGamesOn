package dados;

import entidades.Avaliacao;
import entidades.Venda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVenda implements IRepositorioVenda{

    private ArrayList<Venda> vendas;

    public RepositorioVenda() {
        vendas = new ArrayList<>();
    }
    @Override
    public void inserir(Venda venda) {
        if(venda != null){
            vendas.add(venda);
        }
    }

    @Override
    public List<Venda> listar() {
        return vendas;
    }

    @Override
    public void atualizar(Venda vendaAntiga, Venda vendaNova) {
        for (Venda venda : vendas) {
            if (venda.equals(vendaAntiga)) {
                int index = vendas.indexOf(venda);
                vendas.set(index, vendaNova);
                break;
            }
        }
    }

    @Override
    public void excluir(Venda vendaParaExcluir) {
        for (Venda venda : vendas) {
            if (venda.equals(vendaParaExcluir)) {
                vendas.remove(venda);
                break;
            }
        }

    }
}
