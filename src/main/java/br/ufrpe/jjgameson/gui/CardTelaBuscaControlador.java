package br.ufrpe.jjgameson.gui;
import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CardTelaBuscaControlador {

        private Jogo jogoo;

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
                try {
                        Stage stage;
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_jogo.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
                        stage.setTitle("Mais sobre o jogo");
                        stage.setResizable(false);
                        stage.show();

                        TelaJogoControlador telaJogoControlador = fxmlLoader.getController();
                        telaJogoControlador.atualizarInformacoes(jogoo);
                }catch (IOException e){e.printStackTrace();}
        }

        public void setInformacoes(Jogo jogo){
                jogoo = jogo;
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

