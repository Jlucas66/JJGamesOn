package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Codigo;

import java.util.List;

public interface IRepositorioCodigo {
    public void inserir (String codigo);
    public List<String> listar();
}
