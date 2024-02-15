package br.ufrpe.jjgameson.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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


                // Caso tenha dado algum erro
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Edição de jogo");
                alert.setContentText("Não foi possível concluir a edição.");
                alert.showAndWait();

                // Caso tenha sido possivel editar o jogo
                Alert alertOk = new Alert(Alert.AlertType.WARNING);
                alertOk.setTitle("Sucesso");
                alertOk.setHeaderText("Edição de jogo");
                alertOk.setContentText("O jogo foi editado com sucesso.");
                alertOk.showAndWait();
        }

        @FXML
        void btnVoltarEditarJogo(ActionEvent event) throws IOException{
                GerenciadorDeTelas.irParaTelaPrincipalADM(event);
        }

    }

