package br.ufrpe.jjgameson.gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaHistoricoControlador {

        @FXML
        private Button botaoVoltar;

        @FXML
        private TextArea comprasAnterioresTelaHistorico;

        @FXML
        private ImageView logoTelaHistorico;

        @FXML
        void btnVoltarTelaHistorico(ActionEvent event) throws IOException {
GerenciadorDeTelas.irParaTelaPrincipalCliente(event);
        }

    }
