package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioCliente;
import br.ufrpe.jjgameson.dados.RepositorioCliente;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.ElementoDuplicadoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;
import br.ufrpe.jjgameson.exceptions.SenhaFracaException;

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

    private boolean verificarSenhaForte(String senha) {
        // Exigir pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais
        return senha.length() >= 8 && senha.matches(".*[A-Z].*") && senha.matches(".*[a-z].*")
                && senha.matches(".*\\d.*") && senha.matches(".*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/~`].*");
    }

    public void inserirCliente(Pessoa cliente) throws ElementoNuloException, AcessoInvalidoException, ElementoDuplicadoException, SenhaFracaException {
        if(cliente == null){
            throw new ElementoNuloException("Cliente não pode ser nulo");
        }
        if(cliente.isEhAdm()){
            throw new AcessoInvalidoException("Cliente não pode ser um administrador");
        }
        if(repositorioCliente.obterClientePorEmail(cliente.getEmail()) != null){
            throw new ElementoDuplicadoException("Cliente já cadastrado");
        }
        if(!verificarSenhaForte(cliente.getSenha())){
            throw new SenhaFracaException("Sua senha deve ter pelo menos 8 " +
                    "caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais");
        }

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
