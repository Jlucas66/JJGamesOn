package br.ufrpe.jjgameson.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class TelaLoginClienteControlador {

    public void initialize(){
        //capaLoginCliente.setImage(new Image(getClass().getResourceAsStream("capaofc1.jpg")));
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
    void btnLoginClienteCadastrar(ActionEvent event) {

    }

    @FXML
    void btnLoginClienteEntrar(ActionEvent event) {

    }

    @FXML
    void btnLoginClienteEntrarComoADM(ActionEvent event) {

    }

    public ImageView getCapaLoginCliente() {
        return capaLoginCliente;
    }

    public void setCapaLoginCliente(ImageView capaLoginCliente) {
        this.capaLoginCliente = capaLoginCliente;
    }

    public ImageView getLogoLoginCliente() {
        return logoLoginCliente;
    }

    public void setLogoLoginCliente(ImageView logoLoginCliente) {
        this.logoLoginCliente = logoLoginCliente;
    }

}

