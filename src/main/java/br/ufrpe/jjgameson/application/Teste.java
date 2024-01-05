package br.ufrpe.jjgameson.application;
import br.ufrpe.jjgameson.entidades.*;
import br.ufrpe.jjgameson.negocio.Fachada;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Teste {
    // instancie aqui um exemplo de cada classe do pacote entidades
    public static void main(String[] args) {
        Pessoa admin = new Pessoa("João", "joao@email.br",
                "senha123", LocalDate.of(2022, 12, 1), true);
        Pessoa cliente = new Pessoa("Maria", "maria@email.br",
                "senha123", LocalDate.of(2003, 2, 4), false);
        Jogo jogo = new Jogo(1, "Minecraft", 29.90, "Mojang Studios", "Casual",
                "Um jogo casual de construção", FaixaEtaria.LIVRE);
        Avaliacao avaliacao = new Avaliacao(cliente, jogo, 5, "Muito bom!", LocalDateTime.now());
        Venda venda = new Venda(cliente, LocalDateTime.now());
        ItemVenda itemVenda = new ItemVenda(jogo, 2, 1);
        Fachada fachada = Fachada.getInstance();
        try {
            fachada.inserirAdmin(admin);
            fachada.inserirCliente(cliente);
            fachada.inserirJogo(jogo);
            fachada.inserirAvaliacao(avaliacao);
            fachada.inserirVenda(venda);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
