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

    private Fachada() {
        controladorAdministrador = ControladorAdmin.getInstance();
        controladorAvaliacao = ControladorAvaliacao.getInstance();
        controladorCliente = ControladorCliente.getInstance();
        controladorCodigo = ControladorCodigo.getInstance();
        controladorJogo = ControladorJogo.getInstance();
        controladorPromocao = ControladorPromocao.getInstance();
        controladorVenda = ControladorVenda.getInstance();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    public void inserirAdmin(Pessoa admin)
            throws ElementoInvalidoException, ElementoNuloException, SenhaFracaException, ElementoDuplicadoException, AcessoInvalidoException {
        controladorAdministrador.inserir(admin);
    }

    public void listarAdmins() {
        controladorAdministrador.listar();
    }

    public void removerAdmin(Pessoa admin) throws ElementoNaoEncontradoException, ElementoNuloException {
        controladorAdministrador.excluir(admin);
    }

    public void atualizarAdmin(Pessoa adminAntigo, Pessoa adminNovo) throws ElementoNaoEncontradoException, ElementoNuloException, ElementoInvalidoException, SenhaFracaException, ElementoDuplicadoException, AcessoInvalidoException {
        controladorAdministrador.atualizar(adminAntigo, adminNovo);
    }

    public void inserirAvaliacao(Avaliacao avaliacao) throws ElementoNuloException, ElementoInvalidoException {
        controladorAvaliacao.inserirAvaliacao(avaliacao);
    }

    public void listarAvaliacoes() {
        controladorAvaliacao.listarAvaliacoes();
    }

    public void atualizarAvaliacao(Avaliacao avaliacaoAntiga, Avaliacao novaAvaliacao) throws ElementoNuloException, ElementoInvalidoException, ElementoNaoEncontradoException, ElementoDuplicadoException {
        controladorAvaliacao.atualizarAvaliacao(avaliacaoAntiga, novaAvaliacao);
    }

    public void excluirAvaliacao(Avaliacao avaliacao) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorAvaliacao.excluirAvaliacao(avaliacao);
    }

    public void inserirCliente(Pessoa cliente) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException, SenhaFracaException, AcessoInvalidoException {
        controladorCliente.inserirCliente(cliente);
    }

    public void listarClientes() {
        controladorCliente.listarClientes();
    }

    public void obterClientePorEmail(String email) throws ElementoNuloException, ElementoInvalidoException, ElementoNaoEncontradoException {
        controladorCliente.obterClientePorEmail(email);
    }

    public void atualizarCliente(Pessoa clienteAntigo, Pessoa clienteNovo) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException, ElementoNaoEncontradoException, SenhaFracaException, AcessoInvalidoException {
        controladorCliente.atualizarCliente(clienteAntigo, clienteNovo);
    }

    public void removerCliente(String email) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorCliente.removerCliente(email);
    }

    public void inserirCodigo(String codigo) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorCodigo.inserir(codigo);
    }

    public void listarCodigos() {
        controladorCodigo.listar();
    }

    public void inserirJogo(Jogo jogo) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorJogo.inserirJogo(jogo);
    }

    public void listarJogos() {
        controladorJogo.listarJogos();
    }

    public void obterJogoPorId(int id) throws ElementoInvalidoException, ElementoNaoEncontradoException {
        controladorJogo.obterJogoPorId(id);
    }

    public void removerJogo(Jogo jogoParaExcluir) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorJogo.removerJogo(jogoParaExcluir);
    }

    public void atualizarJogo(Jogo jogoAntigo, Jogo jogoNovo) throws ElementoNuloException, ElementoNaoEncontradoException, ElementoDuplicadoException, ElementoInvalidoException {
        controladorJogo.atualizarJogo(jogoAntigo, jogoNovo);
    }

    public void inserirPromocao(Promocao promocao) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorPromocao.inserirPromocao(promocao);
    }

    public void listarPromocoes() {
        controladorPromocao.listarPromocoes();
    }

    public void atualizarPromocao(Promocao promocaoAntiga, Promocao promocaoNova) throws ElementoNuloException, ElementoDuplicadoException, ElementoNaoEncontradoException, ElementoInvalidoException {
        controladorPromocao.atualizarPromocao(promocaoAntiga, promocaoNova);
    }

    public void removerPromocao(Promocao promocao) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorPromocao.excluirPromocao(promocao);
    }

    public void inserirVenda(Venda venda) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorVenda.inserirVenda(venda);
    }

    public void listarVendas() {
        controladorVenda.listarVendas();
    }

    public void atualizarVenda(Venda vendaAntiga, Venda vendaNova) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException, ElementoNaoEncontradoException {
        controladorVenda.atualizarVenda(vendaAntiga, vendaNova);
    }

    public void removerVenda(Venda venda) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorVenda.excluirVenda(venda);
    }

    // metodos BD
    public void inserirAdminBD(Pessoa admin) throws ElementoInvalidoException, ElementoNuloException, SenhaFracaException, ElementoDuplicadoException, AcessoInvalidoException {
        controladorAdministrador.inserirPessoaAdminBD(admin);
    }

    public boolean verificarloginADMBD(String email, String senha) throws AcessoInvalidoException, ElementoNuloException {
        return controladorAdministrador.verificarloginADMBD(email, senha);
    }

    public void removerPessoaAdminBD(Pessoa pessoa) throws ElementoNaoEncontradoException, ElementoNuloException {
        controladorAdministrador.removerPessoaAdminBD(pessoa);
    }

    /*
    public void atualizarPessoaAdminBD(Pessoa pessoaAntiga, Pessoa pessoa) throws ElementoNaoEncontradoException, ElementoNuloException, AcessoInvalidoException, SenhaFracaException, ElementoDuplicadoException, ElementoInvalidoException{
    controladorAdministrador.atualizarPessoaAdminBD(pessoaAntiga, pessoa);
    }
    */
    // Corrigir IRepositorioAdmin / RepositorioAdmin
    // public List<Pessoa> listarPessoaAdminsBD(){
    //    return controladorAdministrador.listarPessoaAdminsBD();}
    public void inserirAvaliacaoBD(Avaliacao avaliacao) throws ElementoNuloException, ElementoInvalidoException {
        controladorAvaliacao.inserirBD(avaliacao);
    }

    /* public void atualizarAvaliacaoBD(Avaliacao avaliacaoAntiga, Avaliacao avaliacaoNova) throws ElementoNuloException, ElementoInvalidoException, ElementoNaoEncontradoException, ElementoDuplicadoException {
       controladorAvaliacao.atualizarBD(avaliacaoAntiga, avaliacaoNova);
     */
    public void excluirAvaliacaoBD(Avaliacao avaliacao) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorAvaliacao.excluirBD(avaliacao);
    }
    // public void listarAvaliacaoBD() {
    //   controladorAvaliacao.listarBD();}

    public void inserirClienteBD(Pessoa cliente) throws ElementoNuloException, AcessoInvalidoException, ElementoDuplicadoException, SenhaFracaException, ElementoInvalidoException {
        controladorCliente.inserirClienteBD(cliente);
    }

    /*  public Pessoa obterClientePorEmailBD(String email) throws ElementoNuloException, ElementoInvalidoException, ElementoNaoEncontradoException {
    return controladorCliente.obterClientePorEmailBD(email);
    }
    */

    public boolean VerificarUsuarioLoginBD(String email, String senha) throws AcessoInvalidoException{
        return controladorCliente.VerificarUsuarioLoginBD(email, senha);
    }

    /*
    public void removerClienteBD(String email) throws ElementoNuloException, ElementoNaoEncontradoException {
    controladorCliente.removerClienteBD(email);
    }
    */

     /*
    public void atualizarClienteBD(Pessoa clienteAntigo, Pessoa clienteNovo) throws ElementoNuloException, AcessoInvalidoException, ElementoNaoEncontradoException, SenhaFracaException, ElementoInvalidoException, ElementoDuplicadoException {
    controladorCliente.atualizarClienteBD(clienteAntigo, clienteNovo);
    }
      */
// public List<Pessoa> listarClientesBD() {
//   return controladorCliente.listarClientesBD();
//   }

    /*

    public void inserirCodigoBD(String codigo) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorCodigo.inserirBD(codigo);
    }

    public void listarCodigosBD() {
        controladorCodigo.listarBD();
    }

    public void inserirJogoBD(Jogo jogo) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorJogo.inserirJogoBD(jogo);
    }

    public void listarJogosBD() {
        controladorJogo.listarJogosBD();
    }

    public Jogo obterJogoPorIdBD(int id) throws ElementoInvalidoException, ElementoNaoEncontradoException {
        return controladorJogo.obterJogoPorIdBD(id);
    }

    public void removerJogoBD(Jogo jogoParaExcluir) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorJogo.removerJogoBD(jogoParaExcluir);
    }

    public void atualizarJogoBD(Jogo jogoAntigo, Jogo jogoNovo) throws ElementoNuloException, ElementoNaoEncontradoException, ElementoDuplicadoException, ElementoInvalidoException {
        controladorJogo.atualizarJogoBD(jogoAntigo, jogoNovo);
    }

    public void inserirPromocaoBD(Promocao promocao) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorPromocao.inserirPromocaoBD(promocao);
    }

    public void listarPromocoesBD() {
        controladorPromocao.listarPromocoesBD();
    }

    public void atualizarPromocaoBD(Promocao promocaoAntiga, Promocao promocaoNova) throws ElementoNuloException, ElementoDuplicadoException, ElementoNaoEncontradoException, ElementoInvalidoException {
        controladorPromocao.atualizarPromocaoBD(promocaoAntiga, promocaoNova);
    }

    public void removerPromocaoBD(Promocao promocao) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorPromocao.excluirPromocaoBD(promocao);
    }

    public void inserirVendaBD(Venda venda) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException {
        controladorVenda.inserirVendaBD(venda);
    }

    public void listarVendasBD() {
        controladorVenda.listarVendasBD();
    }

    public void atualizarVendaBD(Venda vendaAntiga, Venda vendaNova) throws ElementoNuloException, ElementoInvalidoException, ElementoDuplicadoException, ElementoNaoEncontradoException {
        controladorVenda.atualizarVendaBD(vendaAntiga, vendaNova);
    }

    public void removerVendaBD(Venda venda) throws ElementoNuloException, ElementoNaoEncontradoException {
        controladorVenda.excluirVendaBD(venda);
    }
    */
}
