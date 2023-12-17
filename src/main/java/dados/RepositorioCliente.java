package dados;

import entidades.Pessoa;

import java.sql.*;
import java.util.ArrayList;

public class RepositorioCliente implements IRepositorioGenerico<Pessoa, String>{
    // atributos

    private ArrayList<Pessoa> clientes;
    private static IRepositorioGenerico<Pessoa, String> instance;

    // construtores
    private RepositorioCliente(){
        clientes = new ArrayList<>();
    }

    public static IRepositorioGenerico<Pessoa, String> getInstance(){
        if(instance == null){
            instance = new RepositorioCliente();
        }
        return instance;
    }

    // CRUD de cliente

    public void inserir(Pessoa cliente) {
        if (cliente != null){
            clientes.add(cliente);
        }

    }

    public Pessoa recuperar(String email) {
        Pessoa c = null;
        for (Pessoa cliente : clientes){
            if (cliente.getEmail().equals(email)){
                c = cliente;
            }
        }
        return c;
    }

    public void remover(Pessoa cliente) {
        if (cliente != null){
            clientes.remove(cliente);
        }
    }

    public void atualizar(Pessoa cliente) {
        if (cliente != null){
            for (Pessoa antigo : clientes){
                if (antigo.getEmail().equals(cliente.getEmail())){  // se o email do cliente antigo for igual ao id do cliente novo, a atualização é feita
                    antigo.setNome(cliente.getNome());
                    antigo.setEmail(cliente.getEmail());
                    antigo.setSenha(cliente.getSenha());
                    antigo.setDataNascimento(cliente.getDataNascimento());
                }
            }
        }
    }

    public static void listarClientesDoBancoDeDados() {
        String consultaSQL = "select * from Cliente";

        try (Connection conexao = ConexaoBD.obterConexao()) {
            PreparedStatement comando = conexao.prepareStatement(consultaSQL);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");

                System.out.println("Nome: " + nome);
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        listarClientesDoBancoDeDados();
    }
}


