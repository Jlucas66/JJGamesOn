package br.ufrpe.jjgameson.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaCadastroClienteControlador {

    public TelaCadastroClienteControlador() {
    }

    @FXML
    private Button botaoRealizarCadastro;

    @FXML
    private Button botaoVoltar;

    @FXML
    private ImageView capaCadastro;

    @FXML
    private DatePicker dataNascimentoCadastro;

    @FXML
    private TextField emailCadastro;

    @FXML
    private ImageView logoCadastro;

    @FXML
    private TextField nomeCadastro;

    @FXML
    private PasswordField senhaCadastro;

    @FXML
    public void btnCadastroClienteRealizarCadastro(ActionEvent event) throws IOException {

    }

    @FXML
    public void btnCadastroClienteVoltar(ActionEvent event) throws IOException{

    }



    public Button getBotaoRealizarCadastro() {
        return botaoRealizarCadastro;
    }

    public void setBotaoRealizarCadastro(Button botaoRealizarCadastro) {
        this.botaoRealizarCadastro = botaoRealizarCadastro;
    }

    public Button getBotaoVoltar() {
        return botaoVoltar;
    }

    public void setBotaoVoltar(Button botaoVoltar) {
        this.botaoVoltar = botaoVoltar;
    }

    public ImageView getCapaCadastro() {
        return capaCadastro;
    }

    public void setCapaCadastro(ImageView capaCadastro) {
        this.capaCadastro = capaCadastro;
    }

    public DatePicker getDataNascimentoCadastro() {
        return dataNascimentoCadastro;
    }

    public void setDataNascimentoCadastro(DatePicker dataNascimentoCadastro) {
        this.dataNascimentoCadastro = dataNascimentoCadastro;
    }

    public TextField getEmailCadastro() {
        return emailCadastro;
    }

    public void setEmailCadastro(TextField emailCadastro) {
        this.emailCadastro = emailCadastro;
    }

    public ImageView getLogoCadastro() {
        return logoCadastro;
    }

    public void setLogoCadastro(ImageView logoCadastro) {
        this.logoCadastro = logoCadastro;
    }

    public TextField getNomeCadastro() {
        return nomeCadastro;
    }

    public void setNomeCadastro(TextField nomeCadastro) {
        this.nomeCadastro = nomeCadastro;
    }

    public PasswordField getSenhaCadastro() {
        return senhaCadastro;
    }

    public void setSenhaCadastro(PasswordField senhaCadastro) {
        this.senhaCadastro = senhaCadastro;
    }
}
