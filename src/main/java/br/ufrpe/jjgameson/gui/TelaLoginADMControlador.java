package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.dados.IRepositorioAdmin;
import br.ufrpe.jjgameson.dados.RepositorioAdmin;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.ElementoInvalidoException;
import br.ufrpe.jjgameson.exceptions.ElementoNaoEncontradoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;
import br.ufrpe.jjgameson.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaLoginADMControlador {

    @FXML
    private Button botaoEntrarComoADM;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField emailLoginADM;

    @FXML
    private ImageView logoLoginADM;

    @FXML
    private PasswordField senhaLoginADM;

    @FXML
    void btnLoginADMEntrarComoADM(ActionEvent event) throws IOException, ElementoNuloException, ElementoNaoEncontradoException {
        Pessoa adminlogin = null;
        try {
            adminlogin = Fachada.getInstance().obterAdminPorEmail(emailLoginADM.getText());
        } catch (ElementoNaoEncontradoException e) {
            GerenciadorDeTelas.exibirAlertaMensagem("Erro", "Email inválido");
            e.printStackTrace();
        }
        if (adminlogin != null) {
            if (adminlogin.getSenha().equals(senhaLoginADM.getText())) {
                GerenciadorDeTelas.irParaTelaPrincipalADM(event);
            } else {
                GerenciadorDeTelas.exibirAlertaMensagem("Erro", "Senha incorreta");
            }
        }

    }
    @FXML
    void btnLoginADMVoltar(ActionEvent event) throws IOException {
        GerenciadorDeTelas.irParaTelaLoginCliente(event);
    }

}

