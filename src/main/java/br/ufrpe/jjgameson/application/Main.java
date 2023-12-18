package br.ufrpe.jjgameson.application;

import br.ufrpe.jjgameson.dados.*;
import br.ufrpe.jjgameson.entidades.Pessoa;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Instanciando Repositorios:
        RepositorioAdmin repositorioAdmin = new RepositorioAdmin();
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioCodigo repositorioCodigo = new RepositorioCodigo();
        RepositorioAvaliacao repositorioAvaliacao = new RepositorioAvaliacao();
        RepositorioJogo repositorioJogo = new RepositorioJogo();
        RepositorioPromocao repositorioPromocao = new RepositorioPromocao();
        RepositorioVenda repositorioVenda = new RepositorioVenda();

        // Gerando Pessoas
        Pessoa admin1 = new Pessoa("João", "joaoemail@gmail.com", "senha123", LocalDate.of(1999,12,12),true);
        Pessoa cliente1 = new Pessoa("Vagner", "vagneremail@gmail.com", "coxinha123", LocalDate.of(2002,5,15),false);

        // Inserindo no repositorio
        repositorioAdmin.inserir(admin1);
        repositorioCliente.inserirCliente(cliente1);
        }
}
