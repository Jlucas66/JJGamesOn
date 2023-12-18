package dados;

import entidades.Avaliacao;
import entidades.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements IRepositorioCliente{

    private ArrayList<Pessoa> clientes;

    public RepositorioCliente() {
        clientes = new ArrayList<>();
    }
    @Override
    public void inserirCliente(Pessoa cliente) {
        if(cliente != null && !cliente.isEhAdm()){
            clientes.add(cliente);
        }
    }

    @Override
    public Pessoa obterClientePorEmail(String email) {
        for (Pessoa cliente : clientes) {
            if(cliente.getEmail().equals(email))return cliente;
        }
        return null;
    }

    @Override
    public void removerCliente(String email) {
        if(email != null){
            for (Pessoa cliente:clientes) {
                if(cliente.getEmail().equals(email)){
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


