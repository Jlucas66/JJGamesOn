package br.ufrpe.jjgameson.gui;


import br.ufrpe.jjgameson.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaRelatorioDeVendasControlador {

        @FXML
        private Button botaoVoltar;

        @FXML
        private ImageView logoRelatorioDeVendas;

        @FXML
        private TextArea textAreaRelatorioDeVendas;

        @FXML
        void initialize() {
                preencherRelatorioDeVendas();
        }

        private void preencherRelatorioDeVendas() {
                String relatorio = Fachada.getInstance().obterRelatorioVendas();
                textAreaRelatorioDeVendas.setText(relatorio);
        }

        @FXML
        void btnVoltarRelatorioDeVendas(ActionEvent event) throws IOException {
                GerenciadorDeTelas.irParaTelaPrincipalADM(event);
        }

    }

