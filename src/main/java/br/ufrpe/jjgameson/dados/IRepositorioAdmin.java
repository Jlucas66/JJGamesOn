package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.*;

import java.util.List;

public interface IRepositorioAdmin {
    public void inserir (Pessoa admin);
    public List<Pessoa> listar();
    public boolean verificarloginADMBD(String email, String senha) throws AcessoInvalidoException;
    public void atualizar (Pessoa adminAntigo, Pessoa adminNovo);
    public void excluir(Pessoa adminParaExcluir);
}
