package br.ufrpe.jjgameson.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaCompraFinalizadaControlador {

        @FXML
        private Button botaoVoltar;

        @FXML
        private TextArea codigosDeAcessoCompraFinalizada;

        @FXML
        private ImageView logoCompraFinalizada;

        @FXML
        void btnVoltarCompraFinalizada(ActionEvent event) throws IOException {
            GerenciadorDeTelas.irParaTelaPrincipalCliente(event);
        }

        public void setCodigosDeAcessoCompraFinalizada(String codigos){
            codigosDeAcessoCompraFinalizada.setText(codigos);
        }
    }

