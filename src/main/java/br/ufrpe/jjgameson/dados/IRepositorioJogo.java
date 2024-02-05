package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Jogo;

import java.util.List;

public interface IRepositorioJogo {

        void inserirJogo(Jogo jogo);
        void inserirJogoBD(Jogo jogo);
        Jogo obterJogoPorId(int id);
        void removerJogo(Jogo jogo);
        void atualizarJogo(Jogo jogoAntigo, Jogo jogoNovo);
        List<Jogo> listarJogos();
        boolean obterJogoPorIdBD(int id);
}
