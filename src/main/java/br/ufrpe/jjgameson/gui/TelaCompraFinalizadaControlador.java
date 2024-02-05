package br.ufrpe.jjgameson.gui;


import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.ItemVenda;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaCompraFinalizadaControlador implements Initializable {



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itens = new ArrayList<>(itens());
        for(int i = 0; i < itens.size(); i++){
            setCodigosDeAcessoCompraFinalizada(itens.get(i).getCodigos());
        }


    }
    private List<ItemVenda> itens(){
        List<ItemVenda> its = new ArrayList<>();

        return its;
    }
        private List<ItemVenda> itens;
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

        public void setCodigosDeAcessoCompraFinalizada(ArrayList<String> codigos){
            codigosDeAcessoCompraFinalizada.setText(codigos.toString());
        }


}

