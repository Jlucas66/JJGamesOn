package br.ufrpe.jjgameson.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private TextField senhaLoginADM;

    @FXML
    void btnLoginADMEntrarComoADM(ActionEvent event) throws IOException{

    }

    @FXML
    void btnLoginADMVoltar(ActionEvent event) throws IOException {
GerenciadorDeTelas.irParaTelaLoginCliente(event);
    }

}

