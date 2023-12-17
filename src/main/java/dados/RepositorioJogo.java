package dados;

import entidades.Jogo;

import java.util.ArrayList;

public class RepositorioJogo implements IRepositorioJogo {

    // atributos

    private ArrayList<Jogo> jogos;
    private static IRepositorioJogo instance;

    // construtores

    private RepositorioJogo(){
        jogos = new ArrayList<>();
    }

    public static IRepositorioJogo getInstance(){
        if(instance == null){
            instance = new RepositorioJogo();
        }
        return instance;
    }

    // CRUD de jogo
    public void inserirJogo(Jogo jogo){
        if (jogo != null){
            jogos.add(jogo);
        }
    }

    public Jogo obterJogoPorId(int id){
        Jogo c = null;
        for (Jogo jogo : jogos){
            if (jogo.getId() == id){
                c = jogo;
            }
        }
        return c;
    }

    public void removerJogo(Jogo jogo){
        if (jogo != null){
            jogos.remove(jogo);
        }
    }

    public void atualizarJogo (Jogo jogo){
        if (jogo != null){
            for (Jogo antigo : jogos){
                if (antigo.getId() == jogo.getId()){  // se o id do jogo antigo for igual ao id do jogo novo, a atualização é feita
                    antigo.setNome(jogo.getNome());
                    antigo.setValor(jogo.getValor());
                    antigo.setDesenvolvedora(jogo.getDesenvolvedora());
                    antigo.setGenero(jogo.getGenero());
                    antigo.setResumo(jogo.getResumo());
                    antigo.setFaixaEtaria(jogo.getFaixaEtaria());
                }
            }
        }

    }

/*  num crud esse método é necessário, mas não sei como implementar com
banco de br.ufrpe.JJGamesOn.dados
    public void listarJogosDoBancoDeDados(??){

    }
   */
}
