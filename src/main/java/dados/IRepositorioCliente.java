package dados;


import entidades.Pessoa;

public interface IRepositorioCliente {

        void inserirCliente(Pessoa cliente);
        Pessoa obterClientePorEmail(String email);
        void removerCliente(Pessoa cliente);
//        void atualizarCliente(Pessoa cliente);
        //static void listarClientesDoBancoDeDados();
}
