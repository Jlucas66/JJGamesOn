package dados;

public interface IRepositorioGenerico<T, ID>{  // T é o tipo de entidade que será manipulada, ID é o tipo do identificador da entidade

    void inserir(T entidade);
    T recuperar(ID id);
    void remover(T entidade);
    void atualizar(T entidade);
    static void listarDoBancoDeDados(){}

}
