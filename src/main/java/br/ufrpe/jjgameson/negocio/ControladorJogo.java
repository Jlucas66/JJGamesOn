package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.dados.IRepositorioJogo;
import br.ufrpe.jjgameson.dados.RepositorioJogo;
import br.ufrpe.jjgameson.entidades.FaixaEtaria;
import br.ufrpe.jjgameson.entidades.Jogo;
import br.ufrpe.jjgameson.exceptions.ElementoDuplicadoException;
import br.ufrpe.jjgameson.exceptions.ElementoInvalidoException;
import br.ufrpe.jjgameson.exceptions.ElementoNaoEncontradoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;

import java.util.List;

public class ControladorJogo {

    private IRepositorioJogo repositorioJogo;
    private static ControladorJogo instance;

    private ControladorJogo() {
        repositorioJogo = RepositorioJogo.getInstance();
    }

    public static ControladorJogo getInstance(){
        if(instance == null){
            instance = new ControladorJogo();
        }
        return instance;
    }
    public void inserirJogo(Jogo jogo) throws ElementoNuloException, ElementoDuplicadoException, ElementoInvalidoException {
        if(jogo == null){
            throw new ElementoNuloException("Jogo não pode ser nulo");
        }
        if(jogo.getNome() == null || jogo.getNome().isEmpty()){
            throw new ElementoNuloException("Nome do jogo não pode ser nulo ou vazio");
        }
        if(jogo.getDesenvolvedora() == null || jogo.getDesenvolvedora().isEmpty()){
            throw new ElementoNuloException("Desenvolvedora do jogo não pode ser nulo ou vazio");
        }
        if(jogo.getGenero() == null || jogo.getGenero().isEmpty()){
            throw new ElementoNuloException("Genero do jogo não pode ser nulo ou vazio");
        }
        if(jogo.getResumo() == null || jogo.getResumo().isEmpty()){
            throw new ElementoNuloException("Resumo do jogo não pode ser nulo ou vazio");
        }
        if(jogo.getFaixaEtaria() == null){
            throw new ElementoNuloException("Faixa etaria do jogo não pode ser nulo");
        }
        if (jogo.getValor() == 0 || jogo.getValor() < 0){
            throw new ElementoInvalidoException("Valor do jogo não pode ser zero ou negativo");
        }
        if (jogo.getId() == 0 || jogo.getId() < 0){
            throw new ElementoInvalidoException("Id do jogo não pode ser zero ou negativo");
        }
        if(jogo.getFaixaEtaria() != FaixaEtaria.LIVRE && jogo.getFaixaEtaria() != FaixaEtaria.DEZ && jogo.getFaixaEtaria() != FaixaEtaria.DOZE && jogo.getFaixaEtaria() != FaixaEtaria.QUATORZE && jogo.getFaixaEtaria() != FaixaEtaria.DEZESSEIS && jogo.getFaixaEtaria() != FaixaEtaria.DEZOITO){
            throw new ElementoInvalidoException("Faixa etaria do jogo não pode ser diferente das opções disponiveis");
        }
        if(repositorioJogo.obterJogoPorId(jogo.getId()) != null){
            throw new ElementoDuplicadoException("Jogo já cadastrado");
        }
        repositorioJogo.inserirJogo(jogo);
    }

    public Jogo obterJogoPorId(int id) throws ElementoInvalidoException, ElementoNaoEncontradoException {
        if(id <= 0){
            throw new ElementoInvalidoException("Id não pode ser menor ou igual a zero");
        }
        if (repositorioJogo.obterJogoPorId(id) == null){
            throw new ElementoNaoEncontradoException("Jogo não encontrado");
        }
        return repositorioJogo.obterJogoPorId(id);
    }

    public void removerJogo(Jogo jogoParaExcluir) throws ElementoNuloException, ElementoNaoEncontradoException {
        if (jogoParaExcluir == null){
            throw new ElementoNuloException("Jogo não pode ser nulo");
        }

        List<Jogo> jogos = repositorioJogo.listarJogos();
        boolean jogoEncontrado = false;

        for (Jogo jogo : jogos) {
            if (jogo.equals(jogoParaExcluir)) {
                jogoEncontrado = true;
                break;
            }
        }

        if (jogoEncontrado == false) {
            throw new ElementoNaoEncontradoException("Jogo não encontrado.");
        }
        repositorioJogo.removerJogo(jogoParaExcluir);
    }

    public void atualizarJogo(Jogo jogoAntigo, Jogo jogoNovo) throws ElementoNuloException, ElementoNaoEncontradoException, ElementoDuplicadoException, ElementoInvalidoException {
        if (jogoAntigo == null || jogoNovo == null){
            throw new ElementoNuloException("Jogo não pode ser nulo");
        }

        List<Jogo> jogos = repositorioJogo.listarJogos();
        boolean jogoEncontrado = false;

        for (Jogo jogo : jogos) {
            if (jogo.equals(jogoAntigo)) {
                jogoEncontrado = true;
                break;
            }
        }

        if (jogoEncontrado == false) {
            throw new ElementoNaoEncontradoException("Jogo não encontrado.");
        }

        if (jogoNovo.getNome() == null || jogoNovo.getNome().isEmpty()){
            throw new ElementoNuloException("Nome do jogo não pode ser nulo ou vazio");
        }
        if (jogoNovo.getDesenvolvedora() == null || jogoNovo.getDesenvolvedora().isEmpty()){
            throw new ElementoNuloException("Desenvolvedora do jogo não pode ser nulo ou vazio");
        }
        if (jogoNovo.getGenero() == null || jogoNovo.getGenero().isEmpty()){
            throw new ElementoNuloException("Genero do jogo não pode ser nulo ou vazio");
        }
        if (jogoNovo.getResumo() == null || jogoNovo.getResumo().isEmpty()){
            throw new ElementoNuloException("Resumo do jogo não pode ser nulo ou vazio");
        }
        if (jogoNovo.getFaixaEtaria() == null){
            throw new ElementoNuloException("Faixa etaria do jogo não pode ser nulo");
        }
        if (jogoNovo.getValor() == 0 || jogoNovo.getValor() < 0){
            throw new ElementoInvalidoException("Valor do jogo não pode ser zero ou negativo");
        }
        if (jogoNovo.getId() == 0 || jogoNovo.getId() < 0){
            throw new ElementoInvalidoException("Id do jogo não pode ser zero ou negativo");
        }
        if (jogoNovo.getFaixaEtaria() != FaixaEtaria.LIVRE && jogoNovo.getFaixaEtaria() != FaixaEtaria.DEZ && jogoNovo.getFaixaEtaria() != FaixaEtaria.DOZE && jogoNovo.getFaixaEtaria() != FaixaEtaria.QUATORZE && jogoNovo.getFaixaEtaria() != FaixaEtaria.DEZESSEIS && jogoNovo.getFaixaEtaria() != FaixaEtaria.DEZOITO){
            throw new ElementoInvalidoException("Faixa etaria do jogo não pode ser diferente das opções disponiveis");
        }
        if (repositorioJogo.obterJogoPorId(jogoNovo.getId()) != null){
            throw new ElementoDuplicadoException("Jogo já cadastrado");
        }
        repositorioJogo.atualizarJogo(jogoAntigo, jogoNovo);
    }

    public void listarJogos(){
        repositorioJogo.listarJogos();
    }

    //Funcoes para o banco de dados

    public void inserirJogoBD(Jogo jogo) throws ElementoNuloException, ElementoDuplicadoException, ElementoInvalidoException{
        if(jogo == null){
            throw new ElementoNuloException("Jogo não pode ser nulo");
        }
        if(jogo.getNome() == null || jogo.getNome().isEmpty()){
            throw new ElementoNuloException("Nome do jogo não pode ser nulo ou vazio");
        }
        if(jogo.getDesenvolvedora() == null || jogo.getDesenvolvedora().isEmpty()){
            throw new ElementoNuloException("Desenvolvedora do jogo não pode ser nulo ou vazio");
        }
        if(jogo.getGenero() == null || jogo.getGenero().isEmpty()){
            throw new ElementoNuloException("Genero do jogo não pode ser nulo ou vazio");
        }
        if(jogo.getResumo() == null || jogo.getResumo().isEmpty()){
            throw new ElementoNuloException("Resumo do jogo não pode ser nulo ou vazio");
        }
        if(jogo.getFaixaEtaria() == null){
            throw new ElementoNuloException("Faixa etaria do jogo não pode ser nulo");
        }
        if (jogo.getValor() == 0 || jogo.getValor() < 0){
            throw new ElementoInvalidoException("Valor do jogo não pode ser zero ou negativo");
        }
        if (jogo.getId() == 0 || jogo.getId() < 0){
            throw new ElementoInvalidoException("Id do jogo não pode ser zero ou negativo");
        }
        if(jogo.getFaixaEtaria() != FaixaEtaria.LIVRE && jogo.getFaixaEtaria() != FaixaEtaria.DEZ && jogo.getFaixaEtaria() != FaixaEtaria.DOZE && jogo.getFaixaEtaria() != FaixaEtaria.QUATORZE && jogo.getFaixaEtaria() != FaixaEtaria.DEZESSEIS && jogo.getFaixaEtaria() != FaixaEtaria.DEZOITO){
            throw new ElementoInvalidoException("Faixa etaria do jogo não pode ser diferente das opções disponiveis");
        }
        if(repositorioJogo.obterJogoPorIdBD(jogo.getId()) != null){
            throw new ElementoDuplicadoException("Jogo já cadastrado");
        }
        repositorioJogo.inserirJogoBD(jogo);
    }

    public Jogo obterJogoPorIdBD(int id) throws ElementoInvalidoException, ElementoNaoEncontradoException{
        if(id <= 0){
            throw new ElementoInvalidoException("Id não pode ser menor ou igual a zero");
        }
        if (repositorioJogo.obterJogoPorIdBD(id) == null){
            throw new ElementoNaoEncontradoException("Jogo não encontrado");
        }
        return repositorioJogo.obterJogoPorIdBD(id);
    }
    public void removerJogoBD(int id) throws ElementoNuloException, ElementoNaoEncontradoException{
        if(id <= 0){
            throw new ElementoNuloException("Id não pode ser menor ou igual a zero");
        }
        boolean jogoEncontrado = false;
        List<Jogo> jogos = repositorioJogo.listarJogosBD();
        for (Jogo jogo : jogos) {
            if (jogo.getId() == id) {
                jogoEncontrado = true;
                break;
            }
        }
        if (jogoEncontrado == false) {
            throw new ElementoNaoEncontradoException("Jogo não encontrado.");
        }
        repositorioJogo.removerJogoBD(id);
    }

    public void atualizarJogoBD(Jogo jogoAntigo, Jogo jogoNovo) throws ElementoNuloException, ElementoNaoEncontradoException, ElementoDuplicadoException, ElementoInvalidoException{
        if (jogoAntigo == null || jogoNovo == null){
            throw new ElementoNuloException("Jogo não pode ser nulo");
        }
        boolean jogoEncontrado = false;
        List<Jogo> jogos = repositorioJogo.listarJogosBD();

        for (Jogo jogo : jogos) {
            if (jogo.equals(jogoAntigo)) {
                jogoEncontrado = true;
                break;
            }
        }

        if (jogoEncontrado == false) {
            throw new ElementoNaoEncontradoException("Jogo não encontrado.");
        }

        if (jogoNovo.getNome() == null || jogoNovo.getNome().isEmpty()){
            throw new ElementoNuloException("Nome do jogo não pode ser nulo ou vazio");
        }
        if (jogoNovo.getDesenvolvedora() == null || jogoNovo.getDesenvolvedora().isEmpty()){
            throw new ElementoNuloException("Desenvolvedora do jogo não pode ser nulo ou vazio");
        }
        if (jogoNovo.getGenero() == null || jogoNovo.getGenero().isEmpty()){
            throw new ElementoNuloException("Genero do jogo não pode ser nulo ou vazio");
        }
        if (jogoNovo.getResumo() == null || jogoNovo.getResumo().isEmpty()){
            throw new ElementoNuloException("Resumo do jogo não pode ser nulo ou vazio");
        }
        if (jogoNovo.getFaixaEtaria() == null){
            throw new ElementoNuloException("Faixa etaria do jogo não pode ser nulo");
        }
        if (jogoNovo.getValor() == 0 || jogoNovo.getValor() < 0){
            throw new ElementoInvalidoException("Valor do jogo não pode ser zero ou negativo");
        }
        if (jogoNovo.getId() == 0 || jogoNovo.getId() < 0){
            throw new ElementoInvalidoException("Id do jogo não pode ser zero ou negativo");
        }
        if (jogoNovo.getFaixaEtaria() != FaixaEtaria.LIVRE && jogoNovo.getFaixaEtaria() != FaixaEtaria.DEZ && jogoNovo.getFaixaEtaria() != FaixaEtaria.DOZE && jogoNovo.getFaixaEtaria() != FaixaEtaria.QUATORZE && jogoNovo.getFaixaEtaria() != FaixaEtaria.DEZESSEIS && jogoNovo.getFaixaEtaria() != FaixaEtaria.DEZOITO){
            throw new ElementoInvalidoException("Faixa etaria do jogo não pode ser diferente das opções disponiveis");
        }
        if (repositorioJogo.obterJogoPorIdBD(jogoNovo.getId()) != null){
            throw new ElementoDuplicadoException("Jogo já cadastrado");
        }
        repositorioJogo.atualizarJogoBD(jogoAntigo, jogoNovo);
    }

    public List<Jogo> listarJogosBD(){
        return repositorioJogo.listarJogosBD();
    }
}

