package br.ufrpe.jjgameson.gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaJogoControlador {

        @FXML
        private Button botaoAdicionarAoCarrinho;

        @FXML
        private Button botaoAvaliar;

        @FXML
        private Button botaoVoltar;

        @FXML
        private ImageView capaTelaJogo;

        @FXML
        private TextArea descricaoTelaJogo;

        @FXML
        private Label devTelaJogo;

        @FXML
        private Label faixaEtariaTelaJogo;

        @FXML
        private Label generoTelaJogo;

        @FXML
        private ImageView logoTelaJogo;

        @FXML
        private Label nomeTelaJogo;

        @FXML
        private Label notaTelaJogo;

        @FXML
        private Label precoTelaJogo;

        @FXML
        void btnAdicionarAoCarrinhoTelaJogo(ActionEvent event) throws IOException {

        }

        @FXML
        void btnAvaliarTelaJogo(ActionEvent event) throws IOException{

        }

        @FXML
        void btnVoltarTelaJogo(ActionEvent event) throws IOException{
GerenciadorDeTelas.irParaTelaPrincipalCliente(event);
        }

    }

