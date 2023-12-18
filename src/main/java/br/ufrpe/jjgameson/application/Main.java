package br.ufrpe.jjgameson.application;

import br.ufrpe.jjgameson.dados.*;
import br.ufrpe.jjgameson.entidades.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Instanciando Repositorios:
        RepositorioAdmin repositorioAdmin = new RepositorioAdmin();
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioCodigo repositorioCodigo = new RepositorioCodigo();
        RepositorioJogo repositorioJogo = new RepositorioJogo();
        RepositorioVenda repositorioVenda = new RepositorioVenda();

        // Gerando Pessoas
        Pessoa admin1 = new Pessoa("João", "joaoemail@gmail.com", "senha123", LocalDate.of(1999,12,12),true);
        Pessoa cliente1 = new Pessoa("Vagner", "vagneremail@gmail.com", "coxinha123", LocalDate.of(2002,5,15),false);
        Pessoa cliente2 = new Pessoa("Bruno", "brunoemail@gmail.com", "123456", LocalDate.of(2001,7,15),false);

        // Gerando Jogo
        Jogo jogo1 = new Jogo(1,"Minecraft",29.90,"Mojang Studios","Casual","Um jogo casual de construção", FaixaEtaria.LIVRE);
        Jogo jogo2 = new Jogo(2,"GTA V",69.90,"Rockstar Games","Ação","Um jogo de ação", FaixaEtaria.DEZESSEIS);
        // Gerando itemVenda
        ItemVenda itemVenda1 = new ItemVenda(jogo1,2,1);
        for (String codigo: itemVenda1.getCodigos()) {
            repositorioCodigo.inserir(codigo);
        }

        // Gerando Venda
        Venda venda1 = new Venda(cliente1, LocalDateTime.now());
        venda1.adicionarItemVenda(itemVenda1);


        // Inserindo no repositorio
        repositorioAdmin.inserir(admin1);
        repositorioCliente.inserirCliente(cliente1);
        repositorioCliente.inserirCliente(cliente2);
        repositorioJogo.inserirJogo(jogo1);
        repositorioJogo.inserirJogo(jogo2);
        repositorioVenda.inserir(venda1);

        // Listando coisas
        List<Pessoa> clientes = repositorioCliente.listarClientes();
        System.out.println("\nClientes:");
        for (Pessoa cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail());
        }
        List<String> codigos = repositorioCodigo.listar();
        System.out.println("\nCódigos:");
        for (String codigo : codigos) {
            System.out.println("Código: " + codigo);
        }

        // Removendo cliente
        repositorioCliente.removerCliente("brunoemail@gmail.com");
        System.out.println("\nClientes:");
        for (Pessoa cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail());
        }

        //Listando Jogo
        List<Jogo> jogos = repositorioJogo.listarJogos();
        System.out.println("\nJogos:");
        for (Jogo jogo : jogos) {
            System.out.println("Nome: " + jogo.getNome() + ", Desenvolvedora: " + jogo.getDesenvolvedora());
        }

        //Removendo Jogo
        repositorioJogo.removerJogo(jogo1);
        System.out.println("\nJogos:");
        for (Jogo jogo : jogos) {
            System.out.println("Nome: " + jogo.getNome() + ", Desenvolvedora: " + jogo.getDesenvolvedora());
        }
    }
}
