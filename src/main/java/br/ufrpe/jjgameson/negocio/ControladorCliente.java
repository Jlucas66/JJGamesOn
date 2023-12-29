package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioCliente;
import br.ufrpe.jjgameson.dados.RepositorioCliente;
import br.ufrpe.jjgameson.entidades.Pessoa;

public class ControladorCliente {

    private IRepositorioCliente repositorioCliente;
    private static ControladorCliente instance;

    private ControladorCliente() {
        repositorioCliente = RepositorioCliente.getInstance();
    }

    public static ControladorCliente getInstance(){
        if(instance == null){
            instance = new ControladorCliente();
        }
        return instance;
    }

    public void inserirCliente(Pessoa cliente){
        repositorioCliente.inserirCliente(cliente);
    }

    public Pessoa obterClientePorEmail(String email){
        return repositorioCliente.obterClientePorEmail(email);
    }

    public void removerCliente(String email){
        repositorioCliente.removerCliente(email);
    }

    public void atualizarCliente(Pessoa clienteAntigo, Pessoa clienteNovo){
        repositorioCliente.atualizarCliente(clienteAntigo, clienteNovo);
    }

    public void listarClientes(){
        repositorioCliente.listarClientes();
    }
}
