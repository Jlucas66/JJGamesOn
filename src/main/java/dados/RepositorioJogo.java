package dados;

import entidades.Avaliacao;
import entidades.Jogo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioJogo implements IRepositorioJogo {

    private ArrayList<Jogo> jogos;

    public RepositorioJogo() {
        jogos = new ArrayList<>();
    }
    @Override
    public void inserirJogo(Jogo jogo) {
        if(jogo != null){
            jogos.add(jogo);
        }
    }

    @Override
    public Jogo obterJogoPorId(int id) {
        for (Jogo jogo : jogos) {
            if(jogo.getId() == id) return jogo;
        }
        return null;
    }

    @Override
    public void removerJogo(Jogo jogoParaExcluir) {
        for (Jogo jogo : jogos) {
            if (jogo.equals(jogoParaExcluir)) {
                jogos.remove(jogo);
                break;
            }
        }
    }

    @Override
    public void atualizarJogo(Jogo jogoAntigo, Jogo jogoNovo) {
        for (Jogo jogo : jogos) {
            if (jogo.equals(jogoAntigo)) {
                int index = jogos.indexOf(jogo);
                jogos.set(index, jogoNovo);
                break;
            }
        }
    }

    @Override
    public List<Jogo> listarJogos() {
        return jogos;
    }
}
