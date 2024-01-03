package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.AdminDuplicadoException;
import br.ufrpe.jjgameson.exceptions.AdminNaoEncontradoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;

import java.util.List;

public interface IRepositorioAdmin {
    public void inserir (Pessoa admin) throws AdminDuplicadoException, AcessoInvalidoException, ElementoNuloException;
    public List<Pessoa> listar();
    public void atualizar (Pessoa adminAntigo, Pessoa adminNovo) throws AdminNaoEncontradoException;
    public void excluir(Pessoa adminParaExcluir) throws AdminNaoEncontradoException;
}
