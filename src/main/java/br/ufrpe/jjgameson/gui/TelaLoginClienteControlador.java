package br.ufrpe.jjgameson.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TelaLoginClienteControlador {
/*
    public void initialize() {
        // Carregar a imagem
        Image capa = new Image(getClass().getResourceAsStream("capaofc1.jpg"));
        Image logo = new Image(getClass().getResourceAsStream("JJ-GamesON.png"));

        // Definir a imagem no ImageView
        capaLoginCliente.setImage(capa);
        logoLoginCliente.setImage(logo);
    }
*/
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
    void btnLoginClienteCadastrar(ActionEvent event) {

    }

    @FXML
    void btnLoginClienteEntrar(ActionEvent event) {

    }

    @FXML
    void btnLoginClienteEntrarComoADM(ActionEvent event) {

    }

}

