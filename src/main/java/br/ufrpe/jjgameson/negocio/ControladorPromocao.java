package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioPromocao;
import br.ufrpe.jjgameson.dados.RepositorioPromocao;
import br.ufrpe.jjgameson.entidades.Promocao;
import br.ufrpe.jjgameson.exceptions.ElementoDuplicadoException;
import br.ufrpe.jjgameson.exceptions.ElementoInvalidoException;
import br.ufrpe.jjgameson.exceptions.ElementoNaoEncontradoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;

import java.util.List;

public class ControladorPromocao {

    private IRepositorioPromocao repositorioPromocao;
    private static ControladorPromocao instance;

    private ControladorPromocao() {
        repositorioPromocao = RepositorioPromocao.getInstance();
    }

    public static ControladorPromocao getInstance() {
        if (instance == null) {
            instance = new ControladorPromocao();
        }
        return instance;
    }

    public void inserirPromocao(Promocao promocao) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        if (promocao == null) {
            throw new ElementoNuloException("Promoção não pode ser nula.");
        }
        if (promocao.getJogoEmPromocao() == null) {
            throw new ElementoNuloException("Jogo não pode ser nulo.");
        }
        if (promocao.getDataInicio() == null || promocao.getDataFim() == null) {
            throw new ElementoNuloException("Data não pode ser nula.");
        }
        if (promocao.getDesconto() == 0) {
            throw new ElementoInvalidoException("O valor do desconto não pode ser 0.");
        }
        if (promocao.getDesconto() < 0 || promocao.getDesconto() > 100) {
            throw new ElementoInvalidoException("O valor do desconto deve estar entre 0 e 100.");
        }
        if (promocao.getDataInicio().isAfter(promocao.getDataFim())) {
            throw new ElementoInvalidoException("A data de início deve ser anterior à data de fim.");
        }
        if (promocao.getDataFim().isBefore(promocao.getDataInicio())) {
            throw new ElementoInvalidoException("A data de fim deve ser posterior à data de início.");
        }
        if (repositorioPromocao.listar().contains(promocao)) {
            throw new ElementoDuplicadoException("Promoção já cadastrada.");
        }
        repositorioPromocao.inserir(promocao);
    }

    public void listarPromocoes() {
        repositorioPromocao.listar();
    }

    public void atualizarPromocao(Promocao promocaoAntiga, Promocao promocaoNova) throws ElementoNuloException,
            ElementoDuplicadoException, ElementoNaoEncontradoException, ElementoInvalidoException {
        if (promocaoAntiga == null || promocaoNova == null) {
            throw new ElementoNuloException("Promoção não pode ser nula.");
        }

        List<Promocao> promocoes = repositorioPromocao.listar();
        boolean existe = false;

        for (Promocao promocao : promocoes) {
            if (promocao.equals(promocaoAntiga)) {
                existe = true;
                break;
            }
        }

        if (existe == false) {
            throw new ElementoNaoEncontradoException("Promoção não encontrada.");
        }

        if (promocaoNova.getJogoEmPromocao() == null) {
            throw new ElementoNuloException("Jogo não pode ser nulo.");
        }
        if (promocaoNova.getDataInicio() == null || promocaoNova.getDataFim() == null) {
            throw new ElementoNuloException("Data não pode ser nula.");
        }
        if (promocaoNova.getDesconto() == 0) {
            throw new ElementoInvalidoException("O valor do desconto não pode ser 0.");
        }
        if (promocaoNova.getDesconto() < 0 || promocaoNova.getDesconto() > 100) {
            throw new ElementoInvalidoException("O valor do desconto deve estar entre 0 e 100.");
        }
        if (promocaoNova.getDataInicio().isAfter(promocaoNova.getDataFim())) {
            throw new ElementoInvalidoException("A data de início deve ser anterior à data de fim.");
        }
        if (promocaoNova.getDataFim().isBefore(promocaoNova.getDataInicio())) {
            throw new ElementoInvalidoException("A data de fim deve ser posterior à data de início.");
        }
        if (repositorioPromocao.listar().contains(promocaoNova)) {
            throw new ElementoDuplicadoException("Promoção já cadastrada.");
        }
        repositorioPromocao.atualizar(promocaoAntiga, promocaoNova);
    }

    public void excluirPromocao(Promocao promocaoParaExcluir) throws ElementoNuloException, ElementoNaoEncontradoException{
        if (promocaoParaExcluir == null) {
            throw new ElementoNuloException("Promoção não pode ser nula.");
        }

        List<Promocao> promocoes = repositorioPromocao.listar();
        boolean existe = false;

        for (Promocao promocao : promocoes) {
            if (promocao.equals(promocaoParaExcluir)) {
                existe = true;
                break;
            }
        }

        if (existe == false) {
            throw new ElementoNaoEncontradoException("Promoção não encontrada.");
        }
        repositorioPromocao.excluir(promocaoParaExcluir);
    }
}
