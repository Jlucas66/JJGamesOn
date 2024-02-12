package br.ufrpe.jjgameson.gui;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class CardTelaBuscaControlador {

        @FXML
        private ImageView capa;

        @FXML
        private HBox cardLayoutBusca;

        @FXML
        private Label dev;

        @FXML
        private Hyperlink nome;

        @FXML
        private Label preco;

        @FXML
        void nomeBuscaCard(ActionEvent event) throws IOException {

        }

        public void setInformacoes(Jogo jogo){
                Image image = null;
                try{
                        image = new Image(getClass().getResourceAsStream(jogo.getPath()));
                } catch (Exception e){
                         e.printStackTrace();
                }

                capa.setImage(image);
                nome.setText(jogo.getNome());
                dev.setText(jogo.getDesenvolvedora());
                String oValor = Double.toString(jogo.getValor());
                preco.setText(oValor);
        }

    }

