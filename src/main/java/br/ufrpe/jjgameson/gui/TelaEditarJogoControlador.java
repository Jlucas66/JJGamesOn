package br.ufrpe.jjgameson.gui;


import br.ufrpe.jjgameson.entidades.FaixaEtaria;
import br.ufrpe.jjgameson.entidades.Jogo;
import br.ufrpe.jjgameson.exceptions.ElementoDuplicadoException;
import br.ufrpe.jjgameson.exceptions.ElementoInvalidoException;
import br.ufrpe.jjgameson.exceptions.ElementoNaoEncontradoException;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;
import br.ufrpe.jjgameson.negocio.Fachada;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.List;

public class TelaEditarJogoControlador {

        @FXML
        private Button botaoEditar;

        @FXML
        private Button botaoVoltar;

        @FXML
        private ChoiceBox<Jogo> choiceBoxEditarJogo;

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
        void initialize() {
                preencherChoiceBox();
        }
        private void preencherChoiceBox() {
                List<Jogo> listaJogos = Fachada.getInstance().listarJogos();
                choiceBoxEditarJogo.setItems(FXCollections.observableArrayList(listaJogos));
                choiceBoxEditarJogo.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                        if (newValue != null) {
                                Jogo jogo = choiceBoxEditarJogo.getValue();
                                idEditarJogo.setText(String.valueOf(jogo.getId()));
                                nomeEditarJogo.setText(jogo.getNome());
                                valorEditarJogo.setText(String.valueOf(jogo.getValor()));
                                devEditarJogo.setText(jogo.getDesenvolvedora());
                                generoEditarJogo.setText(jogo.getGenero());
                                resumoEditarJogo.setText(jogo.getResumo());
                                faixaEditarJogo.setText(String.valueOf(jogo.getFaixaEtaria()));
                                pathEditarJogo.setText(jogo.getPath());
                        }
                });
        }

        @FXML
        void btnEditarEditarJogo(ActionEvent event) throws IOException, ElementoInvalidoException, ElementoNuloException, ElementoDuplicadoException, ElementoNaoEncontradoException {
                Jogo jogoAntigo = choiceBoxEditarJogo.getValue();
                Jogo jogoNovo = new Jogo(pathEditarJogo.getText(), nomeEditarJogo.getText(), Double.parseDouble(valorEditarJogo.getText()) , devEditarJogo.getText(), generoEditarJogo.getText(),resumoEditarJogo.getText(), FaixaEtaria.valueOf(faixaEditarJogo.getText()));
                try {
                        Fachada.getInstance().atualizarJogo(jogoAntigo, jogoNovo);
                        GerenciadorDeTelas.exibirAlertaMensagem("Editar Jogo", "Jogo editado com sucesso!");
                }
                catch (ElementoNuloException | ElementoNaoEncontradoException e) {
                        GerenciadorDeTelas.exibirAlertaMensagem("Editar Jogo", e.getMessage());
                        e.printStackTrace();
                }
        }

        @FXML
        void btnVoltarEditarJogo(ActionEvent event) throws IOException{
                GerenciadorDeTelas.irParaTelaPrincipalADM(event);
        }

    }

