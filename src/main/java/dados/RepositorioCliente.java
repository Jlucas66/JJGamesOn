package dados;

import entidades.Pessoa;

import java.sql.*;
import java.util.ArrayList;

public class RepositorioCliente implements IRepositorioCliente{
    // atributos

    private ArrayList<Pessoa> clientes;
    private static IRepositorioCliente instance;

    // construtores
    private RepositorioCliente(){
        clientes = new ArrayList<>();
    }

    public static IRepositorioCliente getInstance(){
        if(instance == null){
            instance = new RepositorioCliente();
        }
        return instance;
    }

    // CRUD de cliente

    public void inserirCliente(Pessoa cliente) {
        if (cliente != null){
            clientes.add(cliente);
        }

    }

    // *ATUALIZAR*
    // NÃO EXISTE ATRIBUTO ID

//    public Pessoa obterClientePorId(int id) {
//        Pessoa c = null;
//        for (Pessoa cliente : clientes){
//            if (cliente.getIdCliente() == id){
//                c = cliente;
//            }
//        }
//        return c;
//    }

    public void removerCliente(Pessoa cliente) {
        if (cliente != null){
            clientes.remove(cliente);
        }
    }


    // *ATUALIZAR*
    // NÃO EXISTE ATRIBUTO ID

//    public void atualizarCliente(Pessoa cliente) {
//        if (cliente != null){
//            for (Pessoa antigo : clientes){
//                if (antigo.getIdCliente() == cliente.getIdCliente()){  // se o id do cliente antigo for igual ao id do cliente novo, a atualização é feita
//                    antigo.setNome(cliente.getNome());
//                    antigo.setEmail(cliente.getEmail());
//                    antigo.setSenha(cliente.getSenha());
//                    antigo.setDataNascimento(cliente.getDataNascimento());
//                }
//            }
//        }
//    }

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


