package br.ufrpe.jjgameson.gui;
import br.ufrpe.jjgameson.entidades.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaHistoricoControlador {

        private Pessoa clienteLogado;

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

        public void pegarCliente(Pessoa cliente){
                clienteLogado = cliente;
        }

    }
