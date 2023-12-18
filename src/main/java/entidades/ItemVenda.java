package entidades;

import java.util.ArrayList;

public class ItemVenda {
    private Jogo jogo;
    private int idItemVenda;
    private int quantidade;
    private double valorTotal;
    private ArrayList<String> codigos;

    public ItemVenda(Jogo jogo, int quantidade, int idItemVenda) {
        this.jogo = jogo;
        this.idItemVenda = idItemVenda;
        this.quantidade = quantidade;
        valorTotal = jogo.getValor() * quantidade;
        this.codigos = Codigo.gerarCodigos(quantidade);
    }


    public void aplicarDesconto(Promocao promocao){
        if(promocao.getJogoEmPromocao().equals(jogo)){
            valorTotal = promocao.calcularValorComDesconto() * quantidade;
        }
        else {
            throw new IllegalArgumentException("O jogo não está em promoção.");
        }
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public ArrayList<String> getCodigos() {
        return codigos;
    }
}
