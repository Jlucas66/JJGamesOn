package entidades;

import java.time.LocalDate;

public class Cliente extends Pessoa{
    private int idCliente;
    public Cliente(String nome, String email, String senha, LocalDate dataNascimento) {
        super(nome, email, senha, dataNascimento);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}

