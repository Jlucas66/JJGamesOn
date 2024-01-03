package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.*;

import java.util.List;

public interface IRepositorioAdmin {
    public void inserir (Pessoa admin) throws ElementoDuplicadoException, AcessoInvalidoException, ElementoNuloException;
    public List<Pessoa> listar();
    public void atualizar (Pessoa adminAntigo, Pessoa adminNovo) throws ElementoNaoEncontradoException;
    public void excluir(Pessoa adminParaExcluir) throws ElementoNaoEncontradoException;
}
