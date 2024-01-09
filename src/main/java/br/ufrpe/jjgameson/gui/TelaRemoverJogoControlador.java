package br.ufrpe.jjgameson.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaRemoverJogoControlador {

        @FXML
        private Button botaoRemover;

        @FXML
        private Button botaoVoltar;

        @FXML
        private ChoiceBox<?> choiceBoxRemoverJogo;

        @FXML
        private ImageView logoRemoverJogo;

        @FXML
        void btnRemoverRemoverJogo(ActionEvent event) throws IOException{

        }

        @FXML
        void btnVoltarRemoverJogo(ActionEvent event) throws IOException {
GerenciadorDeTelas.irParaTelaPrincipalADM(event);
        }

    }


