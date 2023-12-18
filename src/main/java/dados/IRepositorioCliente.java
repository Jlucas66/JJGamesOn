package dados;


import entidades.Pessoa;

import java.util.List;

public interface IRepositorioCliente {

        void inserirCliente(Pessoa cliente);
        Pessoa obterClientePorEmail(String email);
        void removerCliente(String email);
        void atualizarCliente(Pessoa clienteAntigo, Pessoa clienteNovo);
        List<Pessoa> listarClientes();
}
