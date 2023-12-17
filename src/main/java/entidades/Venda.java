package entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venda {
    private Cliente cliente;
    private ArrayList<ItemVenda> itensVenda = new ArrayList();
    private LocalDateTime data;

    public Venda(Cliente cliente, LocalDateTime data) {
        this.cliente = cliente;
        this.data = data;
    }

    public void adicionarItemVenda(ItemVenda novoItem){
        if(!itensVenda.contains(novoItem)){
            itensVenda.add(novoItem);
        }
    }

    public void removerItemVenda(ItemVenda item){
        if(itensVenda.contains(item)){
            itensVenda.remove(item);
        }
    }

    public double calcularTotal() {
        double valorFinal = 0;
        if(!itensVenda.isEmpty()){
            for (ItemVenda venda: itensVenda) {
                valorFinal += venda.getValorTotal();
            }
        }
        return valorFinal;
    }
}
