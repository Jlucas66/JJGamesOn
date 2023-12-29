package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioPromocao;
import br.ufrpe.jjgameson.dados.RepositorioPromocao;
import br.ufrpe.jjgameson.entidades.Promocao;

public class ControladorPromocao {

    private IRepositorioPromocao repositorioPromocao;
    private static ControladorPromocao instance;

    private ControladorPromocao() {
        repositorioPromocao = RepositorioPromocao.getInstance();
    }

    public static ControladorPromocao getInstance(){
        if(instance == null){
            instance = new ControladorPromocao();
        }
        return instance;
    }

    public void inserirPromocao(Promocao promocao){
        repositorioPromocao.inserir(promocao);
    }

    public void listarPromocoes(){
        repositorioPromocao.listar();
    }

    public void atualizarPromocao(Promocao promocaoAntiga, Promocao promocaoNova){
        repositorioPromocao.atualizar(promocaoAntiga, promocaoNova);
    }

    public void excluirPromocao(Promocao promocaoParaExcluir){
        repositorioPromocao.excluir(promocaoParaExcluir);
    }
}
