package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioVenda;
import br.ufrpe.jjgameson.dados.RepositorioVenda;
import br.ufrpe.jjgameson.entidades.Venda;

public class ControladorVenda {

    private IRepositorioVenda repositorioVenda;
    private static ControladorVenda instance;

    private ControladorVenda() {
        repositorioVenda = RepositorioVenda.getInstance();
    }

    public static ControladorVenda getInstance(){
        if(instance == null){
            instance = new ControladorVenda();
        }
        return instance;
    }

    public void inserirVenda(Venda venda){
        repositorioVenda.inserir(venda);
    }

    public void listarVendas(){
        repositorioVenda.listar();
    }

    public void atualizarVenda(Venda vendaAntiga, Venda vendaNova){
        repositorioVenda.atualizar(vendaAntiga, vendaNova);
    }

    public void excluirVenda(Venda vendaParaExcluir){
        repositorioVenda.excluir(vendaParaExcluir);
    }
}
