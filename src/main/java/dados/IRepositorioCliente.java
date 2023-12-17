package dados;


import entidades.Pessoa;

public interface IRepositorioCliente {

        void inserirCliente(Pessoa cliente);
//        Pessoa obterClientePorId(int id);
        void removerCliente(Pessoa cliente);
//        void atualizarCliente(Pessoa cliente);
        //static void listarClientesDoBancoDeDados();
}
