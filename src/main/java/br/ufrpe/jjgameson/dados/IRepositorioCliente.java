package br.ufrpe.jjgameson.dados;


import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;

import java.util.List;

public interface IRepositorioCliente {

        void inserirCliente(Pessoa cliente);
        void inserirUltimoCliente(Pessoa cliente);
        Pessoa obterClientePorEmail(String email);
        Pessoa obterUltimoCliente();
        void removerCliente(String email);
        void atualizarCliente(Pessoa clienteAntigo, Pessoa clienteNovo);
        List<Pessoa> listarClientes();
}
