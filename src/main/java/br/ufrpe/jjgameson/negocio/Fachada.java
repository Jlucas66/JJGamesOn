package br.ufrpe.jjgameson.negocio;

import br.ufrpe.jjgameson.entidades.*;
import br.ufrpe.jjgameson.exceptions.*;

import java.util.List;

public class Fachada {

    private static Fachada instance;

    private ControladorAdmin controladorAdministrador;
    private ControladorAvaliacao controladorAvaliacao;
    private ControladorCliente controladorCliente;
    private ControladorCodigo controladorCodigo;
    private ControladorJogo controladorJogo;
    private ControladorPromocao controladorPromocao;
    private ControladorVenda controladorVenda;

    private Fachada(){
        controladorAdministrador = ControladorAdmin.getInstance();
        controladorAvaliacao = ControladorAvaliacao.getInstance();
        controladorCliente = ControladorCliente.getInstance();
        controladorCodigo = ControladorCodigo.getInstance();
        controladorJogo = ControladorJogo.getInstance();
        controladorPromocao = ControladorPromocao.getInstance();
        controladorVenda = ControladorVenda.getInstance();
    }

    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
        }
        return instance;
    }

    //Administradores
    public void inserirAdmin(Pessoa admin)
            throws ElementoInvalidoException, ElementoNuloException, SenhaFracaException, ElementoDuplicadoException, AcessoInvalidoException {
        controladorAdministrador.inserir(admin);
    }

    public void listarAdmins(){
        controladorAdministrador.listar();
    }

    public void removerAdmin(Pessoa admin) throws ElementoNaoEncontradoException, ElementoNuloException {
        controladorAdministrador.excluir(admin);
    }

    public void atualizarAdmin(Pessoa adminAntigo, Pessoa adminNovo) throws ElementoNaoEncontradoException, ElementoNuloException, ElementoInvalidoException, SenhaFracaException, ElementoDuplicadoException, AcessoInvalidoException {
        controladorAdministrador.atualizar(adminAntigo, adminNovo);
    }
    //Avaliacoes
    public void inserirAvaliacao(Avaliacao avaliacao) throws ElementoNuloException, ElementoInvalidoException {
        controladorAvaliacao.inserirAvaliacao(avaliacao);
    }

    public void listarAvaliacoes(){
        controladorAvaliacao.listarAvaliacoes();
    }

    public void atualizarAvaliacao(Avaliacao avaliacaoAntiga, Avaliacao novaAvaliacao) throws ElementoNuloException, ElementoInvalidoException, ElementoNaoEncontradoException, ElementoDuplicadoException {
        controladorAvaliacao.atualizarAvaliacao(avaliacaoAntiga, novaAvaliacao);
    }

    public void excluirAvaliacao(Avaliacao avaliacao) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorAvaliacao.excluirAvaliacao(avaliacao);
    }

    //Clientes
    public void inserirCliente(Pessoa cliente) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException, SenhaFracaException, AcessoInvalidoException {
        controladorCliente.inserirCliente(cliente);
    }

    public void inserirClienteBD(Pessoa cliente) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException, SenhaFracaException, AcessoInvalidoException {
        controladorCliente.inserirClienteBD(cliente);
    }

    public void listarClientes(){
        controladorCliente.listarClientes();
    }

    public void listarClientesBD(){
        controladorCliente.listarClientesBD();
    }

    public void obterClientePorEmail(String email) throws ElementoNuloException, ElementoInvalidoException, ElementoNaoEncontradoException {
        controladorCliente.obterClientePorEmail(email);
    }

    public Pessoa obterClientePorEmailBD(String email) throws ElementoNuloException, ElementoInvalidoException, ElementoNaoEncontradoException {
        return controladorCliente.obterClientePorEmailBD(email);

    }

    public void atualizarCliente(Pessoa clienteAntigo, Pessoa clienteNovo) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException, ElementoNaoEncontradoException, SenhaFracaException, AcessoInvalidoException {
        controladorCliente.atualizarCliente(clienteAntigo, clienteNovo);
    }

    public void atualizarClienteBD(String email) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException, ElementoNaoEncontradoException, SenhaFracaException, AcessoInvalidoException {
        controladorCliente.atualizarClienteBD(email);
    }

    public void removerCliente(String email) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorCliente.removerCliente(email);
    }

    public void removerClienteBD(String email) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorCliente.removerClienteBD(email);
    }
    public boolean VerificarUsuarioLoginBD(String email, String senha) throws ElementoNuloException, ElementoInvalidoException, AcessoInvalidoException {
        boolean result = controladorCliente.VerificarUsuarioLoginBD(email, senha);
        return result;

    }

    //Codigo
    public void inserirCodigo(String codigo) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorCodigo.inserir(codigo);
    }

    public void listarCodigos(){
        controladorCodigo.listar();
    }

    //Jogos
    public void inserirJogo(Jogo jogo) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorJogo.inserirJogo(jogo);
    }

    public void inserirJogoBD(Jogo jogo) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorJogo.inserirJogoBD(jogo);
    }

    public void listarJogos(){
        controladorJogo.listarJogos();
    }

    public List<Jogo> listarJogosBD(){
        return controladorJogo.listarJogosBD();
    }

    public void obterJogoPorId(int id) throws ElementoInvalidoException, ElementoNaoEncontradoException {
        controladorJogo.obterJogoPorId(id);
    }

    public Jogo obterJogoPorIdBD(int id) throws ElementoInvalidoException, ElementoNaoEncontradoException {
        return controladorJogo.obterJogoPorIdBD(id);
    }

    public void removerJogo(Jogo jogoParaExcluir) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorJogo.removerJogo(jogoParaExcluir);
    }

    public void removerJogoBD(int id) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorJogo.removerJogoBD(id);
    }

    public void atualizarJogo(Jogo jogoAntigo, Jogo jogoNovo) throws ElementoNuloException, ElementoNaoEncontradoException, ElementoDuplicadoException, ElementoInvalidoException {
        controladorJogo.atualizarJogo(jogoAntigo, jogoNovo);
    }

    public void atualizarJogoBD(Jogo jogoAntigo, Jogo jogoNovo) throws ElementoNuloException, ElementoNaoEncontradoException, ElementoDuplicadoException, ElementoInvalidoException {
        controladorJogo.atualizarJogoBD(jogoAntigo, jogoNovo);
    }

    //Promocoes
    public void inserirPromocao(Promocao promocao) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorPromocao.inserirPromocao(promocao);
    }

    public void listarPromocoes(){
        controladorPromocao.listarPromocoes();
    }

    public void atualizarPromocao(Promocao promocaoAntiga, Promocao promocaoNova) throws ElementoNuloException, ElementoDuplicadoException, ElementoNaoEncontradoException, ElementoInvalidoException {
        controladorPromocao.atualizarPromocao(promocaoAntiga, promocaoNova);
    }

    public void removerPromocao(Promocao promocao) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorPromocao.excluirPromocao(promocao);
    }

    //Vendas
    public void inserirVenda(Venda venda) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorVenda.inserirVenda(venda);
    }

    public void listarVendas(){
        controladorVenda.listarVendas();
    }

    public void atualizarVenda(Venda vendaAntiga, Venda vendaNova) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException, ElementoNaoEncontradoException {
        controladorVenda.atualizarVenda(vendaAntiga, vendaNova);
    }

    public void removerVenda(Venda venda) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorVenda.excluirVenda(venda);
    }
}