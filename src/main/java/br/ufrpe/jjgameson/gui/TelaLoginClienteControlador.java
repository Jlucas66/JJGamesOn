package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.dados.RepositorioCliente;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.*;
import br.ufrpe.jjgameson.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.ObservableFaceArray;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaLoginClienteControlador {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize(){

    }

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoEntrar;

    @FXML
    private Button botaoEntrarComoADM;

    @FXML
    private ImageView capaLoginCliente;

    @FXML
    private TextField emailLogin;

    @FXML
    private ImageView logoLoginCliente;

    @FXML
    private PasswordField senhaLogin;



    @FXML
    void btnLoginClienteCadastrar(ActionEvent event) throws IOException{
        GerenciadorDeTelas.irParaTelaCadastro(event);
    }

    @FXML
    void btnLoginClienteEntrar(ActionEvent event) throws IOException, ElementoInvalidoException, ElementoNuloException, ElementoNaoEncontradoException {
        Pessoa pessoaLogin = null;
        try {
            pessoaLogin = Fachada.getInstance().obterClientePorEmail(emailLogin.getText());
        }catch (ElementoInvalidoException e) {
            GerenciadorDeTelas.exibirAlertaMensagem("Erro","Email inválido");
            e.printStackTrace();
        }
        if(pessoaLogin != null){
            if(pessoaLogin.getSenha().equals(senhaLogin.getText())){
                GerenciadorDeTelas.irParaTelaPrincipalCliente(event);
            }
            else{
                GerenciadorDeTelas.exibirAlertaMensagem("Erro","Senha inválida");
            }
        }

    }

    @FXML
    void btnLoginClienteEntrarComoADM(ActionEvent event) throws IOException{
        GerenciadorDeTelas.irParaTelaLoginADM(event);
    }

}

