package br.ufrpe.jjgameson.entidades;

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
        this.codigos = gerarCodigos(quantidade);
    }

    // Método para gerar códigos diretamente na classe ItemVenda
    private static ArrayList<String> gerarCodigos(int quantidade) {
        ArrayList<String> codigos = new ArrayList<>();

        for (int j = 0; j < quantidade; j++) {
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder codigo = new StringBuilder();

            java.util.Random random = new java.util.Random();
            for (int i = 0; i < 10; i++) {
                int indice = random.nextInt(caracteres.length());
                codigo.append(caracteres.charAt(indice));
            }

            codigos.add(codigo.toString());
        }
        return codigos;
    }

    public void aplicarDesconto(Promocao promocao) {
        if (promocao.getJogoEmPromocao().equals(jogo)) {
            valorTotal = promocao.calcularValorComDesconto() * quantidade;
        } else {
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