package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioCliente;
import br.ufrpe.jjgameson.dados.RepositorioCliente;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.*;

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

    public void inserirCliente(Pessoa cliente) throws ElementoNuloException, AcessoInvalidoException, ElementoDuplicadoException, SenhaFracaException, EmailInvalidoException {
        if(cliente == null){
            throw new ElementoNuloException("Cliente não pode ser nulo");
        }
        if(cliente.isEhAdm()){
            throw new AcessoInvalidoException("Cliente não pode ser um administrador");
        }
        if(repositorioCliente.obterClientePorEmail(cliente.getEmail()) != null){
            throw new ElementoDuplicadoException("Já existe um cliente cadastrado com esse email");
        }

        if(cliente.getSenha() == null){
            throw new ElementoNuloException("Senha não pode ser nula");
        }

        if(cliente.getSenha().isEmpty()){
            throw new ElementoNuloException("Senha não pode ser vazia");
        }

        if(cliente.getEmail() == null){
            throw new ElementoNuloException("Email não pode ser nulo");
        }

        if(!cliente.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            throw new EmailInvalidoException("Email inválido, o email deve ser no formato \"email@dominio\"");
        }

        if(!verificarSenhaForte(cliente.getSenha())){
            throw new SenhaFracaException("Sua senha deve ter pelo menos 8 " +
                    "caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais");
        }

        repositorioCliente.inserirCliente(cliente);
    }

    public Pessoa obterClientePorEmail(String email) throws ElementoNuloException, EmailInvalidoException {
        Pessoa resultado = null;
        if(email == null){
            throw new ElementoNuloException("Email não pode ser nulo");
        }
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new EmailInvalidoException("Email inválido, o email deve ser no formato \"email@dominio\"");
        }
        resultado = repositorioCliente.obterClientePorEmail(email);
        return resultado;
    }

    public void removerCliente(String email) throws ElementoNuloException, ElementoNaoEncontradoException {
        if(email == null){
            throw new ElementoNuloException("Email não pode ser nulo");
        }
        if(repositorioCliente.obterClientePorEmail(email) == null){
            throw new ElementoNaoEncontradoException("Não existe cliente cadastrado com esse email");
        }
        for (Pessoa cliente : repositorioCliente.listarClientes()) {
            if (cliente.getEmail().equals(email)) {
                repositorioCliente.removerCliente(email);
                break;
            }
        }
    }

    public void atualizarCliente(Pessoa clienteAntigo, Pessoa clienteNovo) throws ElementoNuloException, AcessoInvalidoException, ElementoNaoEncontradoException, EmailInvalidoException, SenhaFracaException {
        if(clienteAntigo == null || clienteNovo == null){
            throw new ElementoNuloException("Cliente não pode ser nulo");
        }
        if(clienteNovo.isEhAdm()){
            throw new AcessoInvalidoException("Cliente não pode ser um administrador");
        }
        if(clienteNovo.getSenha() == null){
            throw new ElementoNuloException("Senha não pode ser nula");
        }
        if(clienteNovo.getSenha().isEmpty()){
            throw new ElementoNuloException("Senha não pode ser vazia");
        }
        if(!verificarSenhaForte(clienteNovo.getSenha())){
            throw new SenhaFracaException("Sua senha deve ter pelo menos 8 " +
                    "caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais");
        }
        if(clienteNovo.getEmail() == null){
            throw new ElementoNuloException("Email não pode ser nulo");
        }
        if(repositorioCliente.obterClientePorEmail(clienteAntigo.getEmail()) == null){
            throw new ElementoNaoEncontradoException("Não existe cliente cadastrado com esse email");
        }
        if(repositorioCliente.obterClientePorEmail(clienteNovo.getEmail()) != null){
            throw new EmailInvalidoException("Já existe um cliente cadastrado com esse email");
        }
        if(!clienteNovo.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            throw new EmailInvalidoException("Email inválido, o email deve ser no formato \"email@dominio\"");
        }
        repositorioCliente.atualizarCliente(clienteAntigo, clienteNovo);
    }

    public void listarClientes(){
        repositorioCliente.listarClientes();
    }
}
