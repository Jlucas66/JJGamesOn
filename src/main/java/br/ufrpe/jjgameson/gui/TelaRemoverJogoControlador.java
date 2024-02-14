package br.ufrpe.jjgameson.gui;


import br.ufrpe.jjgameson.entidades.Jogo;
import br.ufrpe.jjgameson.exceptions.ElementoNaoEncontradoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;
import br.ufrpe.jjgameson.negocio.Fachada;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelaRemoverJogoControlador {

        @FXML
        private Button botaoRemover;

        @FXML
        private Button botaoVoltar;

        @FXML
        private ChoiceBox<Jogo> choiceBoxRemoverJogo;

        @FXML
        private ImageView logoRemoverJogo;

        @FXML
        void initialize() {
                preencherChoiceBox();
        }

        private void preencherChoiceBox() {
                List<Jogo> listaJogos = Fachada.getInstance().listarJogos();
                choiceBoxRemoverJogo.setItems(FXCollections.observableArrayList(listaJogos));
        }

        @FXML
        void btnRemoverRemoverJogo(ActionEvent event) throws IOException, ElementoNuloException, ElementoNaoEncontradoException {
                Jogo jogo = choiceBoxRemoverJogo.getValue();
                if (jogo != null) {
                        try {
                                Fachada.getInstance().removerJogo(jogo);
                                preencherChoiceBox();
                        } catch (ElementoNuloException | ElementoNaoEncontradoException e) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Erro");
                                alert.setHeaderText("Erro ao remover jogo");
                                alert.setContentText(e.getMessage());
                                alert.showAndWait();
                                e.printStackTrace();
                        }
                }
        }

        @FXML
        void btnVoltarRemoverJogo(ActionEvent event) throws IOException {
GerenciadorDeTelas.irParaTelaPrincipalADM(event);
        }

    }


