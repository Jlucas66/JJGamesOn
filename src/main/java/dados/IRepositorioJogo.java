package dados;

import entidades.Avaliacao;
import entidades.Jogo;

import java.util.List;

public interface IRepositorioJogo {

        void inserirJogo(Jogo jogo);
        Jogo obterJogoPorId(int id);
        void removerJogo(Jogo jogo);
        void atualizarJogo(Jogo jogoAntigo, Jogo jogoNovo);
        List<Jogo> listarJogos();
}
