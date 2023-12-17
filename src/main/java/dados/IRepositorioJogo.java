package dados;

import entidades.Jogo;

public interface IRepositorioJogo {

        void inserirJogo(Jogo jogo);
        Jogo obterJogoPorId(int id);
        void removerJogo(Jogo jogo);
        void atualizarJogo(Jogo jogo);
        // void listarJogosDoBancoDeDados (???);
}
