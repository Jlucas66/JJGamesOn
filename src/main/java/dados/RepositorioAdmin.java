package dados;

import entidades.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAdmin implements IRepositorioAdmin{

    private ArrayList<Pessoa> pessoas;

    public RepositorioAdmin() {
        pessoas = new ArrayList<>();
    }

    @Override
    public void inserir(Pessoa admin) {
        if(pessoas != null){
            pessoas.add(admin)
        }
    }

    @Override
    public List<Pessoa> listar() {
        return pessoas;
    }

    @Override
    public void atualizar(Pessoa adminAntigo, Pessoa adminNovo) {
        for (Pessoa pessoa : pessoas) {
            if (pessoas.equals(adminAntigo)){
                int index = pessoas.indexOf(adminNovo)
            }
        }
    }

    @Override
    public void excluir(Pessoa adminParaExcluir) {
        for (Pessoa pessoa : pessoas){
            if (Pessoa.equals(adminParaExcluir)){
                avaliacoes.remove(pessoa);
                break;
            }
        }
    }
}
