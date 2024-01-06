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
GerenciadorDeTelas.irParaTelaLoginCliente(event);
    }

}
