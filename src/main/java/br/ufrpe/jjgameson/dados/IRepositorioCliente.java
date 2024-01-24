package br.ufrpe.jjgameson.dados;


import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;

import java.util.List;

public interface IRepositorioCliente {

        void inserirCliente(Pessoa cliente);
        Pessoa obterClientePorEmail(String email);
        boolean VerificarUsuarioLoginBD(String email, String senha);
        void removerCliente(String email);
        void atualizarCliente(Pessoa clienteAntigo, Pessoa clienteNovo);
        List<Pessoa> listarClientes();
}
