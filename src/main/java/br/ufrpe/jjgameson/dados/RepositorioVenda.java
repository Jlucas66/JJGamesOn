package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Venda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVenda implements IRepositorioVenda{

    private ArrayList<Venda> vendas;
    private static IRepositorioVenda instance;

    private RepositorioVenda() {
        vendas = new ArrayList<>();
    }

    public static IRepositorioVenda getInstance(){
        if(instance == null){
            instance = new RepositorioVenda();
        }
        return instance;
    }
    @Override
    public void inserir(Venda venda) {
        if(venda != null){
            vendas.add(venda);
        }
    }

    @Override
    public void inserirBD(Venda venda) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = ConexaoBD.getConnection();
            st = conn.createStatement();
            st.executeUpdate("INSERT INTO Venda (dtVenda, emailCliente, itens) VALUES ('" + venda.getData() + "', '" + venda.getCliente().getEmail() + "', '" + venda.getItensVenda().toString() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Venda> listar() {
        return vendas;
    }

    @Override
    public void atualizar(Venda vendaAntiga, Venda vendaNova) {
        for (Venda venda : vendas) {
            if (venda.equals(vendaAntiga)) {
                int index = vendas.indexOf(venda);
                vendas.set(index, vendaNova);
                break;
            }
        }
    }

    @Override
    public void excluir(Venda vendaParaExcluir) {
        for (Venda venda : vendas) {
            if (venda.equals(vendaParaExcluir)) {
                vendas.remove(venda);
                break;
            }
        }

    }
}
