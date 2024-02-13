package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.dados.RepositorioCliente;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    void btnLoginClienteEntrar(ActionEvent event) throws IOException{

        Fachada fachada = (Fachada) Fachada.getInstance();
        try{
            if(fachada.VerificarUsuarioLoginBD(emailLogin.getText(), senhaLogin.getText())) {
                Pessoa Cliente = fachada.obterClientePorEmailBD(emailLogin.getText());
                fachada.inserirCliente(Cliente);
                System.out.println(Cliente.toString());
                GerenciadorDeTelas.irParaTelaPrincipalCliente(event);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @FXML
    void btnLoginClienteEntrarComoADM(ActionEvent event) throws IOException{
        GerenciadorDeTelas.irParaTelaLoginADM(event);
    }

}

