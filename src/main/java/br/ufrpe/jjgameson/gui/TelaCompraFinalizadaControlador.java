package br.ufrpe.jjgameson.gui;


import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.ItemVenda;
import br.ufrpe.jjgameson.entidades.Jogo;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.entidades.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaCompraFinalizadaControlador implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
setCodigosDeAcessoCompraFinalizada(aVenda);
    }

        private Venda aVenda;
        private Pessoa clienteLogado;
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

        public void setCodigosDeAcessoCompraFinalizada(Venda venda){
            codigosDeAcessoCompraFinalizada.setText(venda.listarCodigosVenda());
        }

        public void vendaRealizada(Venda venda){
            aVenda = venda;
        }

        public void pegarCliente(Pessoa cliente){
            clienteLogado = cliente;
        }


}

