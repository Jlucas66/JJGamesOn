package dados;

import entidades.Cliente;

public interface IRepositorioCliente {

        void inserirCliente(Cliente cliente);
        Cliente obterClientePorId(int id);
        void removerCliente(Cliente cliente);
        void atualizarCliente(Cliente cliente);
        //static void listarClientesDoBancoDeDados();
}
