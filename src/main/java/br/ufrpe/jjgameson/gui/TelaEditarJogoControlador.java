package br.ufrpe.jjgameson.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaEditarJogoControlador {

        @FXML
        private Button botaoEditar;

        @FXML
        private Button botaoVoltar;

        @FXML
        private ChoiceBox<?> choiceBoxEditarJogo;

        @FXML
        private TextField devEditarJogo;

        @FXML
        private TextField faixaEditarJogo;

        @FXML
        private TextField generoEditarJogo;

        @FXML
        private TextField idEditarJogo;

        @FXML
        private ImageView logoEditarJogo;

        @FXML
        private TextField nomeEditarJogo;

        @FXML
        private TextField pathEditarJogo;

        @FXML
        private TextArea resumoEditarJogo;

        @FXML
        private TextField valorEditarJogo;

        @FXML
        void btnEditarEditarJogo(ActionEvent event) throws IOException {

        }

        @FXML
        void btnVoltarEditarJogo(ActionEvent event) throws IOException{
GerenciadorDeTelas.irParaTelaPrincipalADM(event);
        }

    }

