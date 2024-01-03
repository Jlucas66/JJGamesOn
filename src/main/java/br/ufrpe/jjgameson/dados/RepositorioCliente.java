package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements IRepositorioCliente {

    private ArrayList<Pessoa> clientes;
    private static IRepositorioCliente instance;

    private RepositorioCliente() {
        clientes = new ArrayList<>();
    }

    public static IRepositorioCliente getInstance() {
        if (instance == null) {
            instance = new RepositorioCliente();
        }
        return instance;
    }

    @Override
    public void inserirCliente(Pessoa cliente) {
        clientes.add(cliente);
    }

    @Override
    public Pessoa obterClientePorEmail(String email) {
        for (Pessoa cliente : clientes) {
            if (cliente.getEmail().equals(email)) return cliente;
        }
        return null;
    }

    @Override
    public void removerCliente(String email) {
        if (email != null) {
            for (Pessoa cliente : clientes) {
                if (cliente.getEmail().equals(email)) {
                    clientes.remove(cliente);
                    break;
                }
            }
        }

    }

    @Override
    public void atualizarCliente(Pessoa clienteAntigo, Pessoa clienteNovo) {
        for (Pessoa cliente : clientes) {
            if (cliente.equals(clienteAntigo)) {
                int index = clientes.indexOf(cliente);
                clientes.set(index, clienteNovo);
                break;
            }
        }
    }

    @Override
    public List<Pessoa> listarClientes() {
        return clientes;
    }
}


