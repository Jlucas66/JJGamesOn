package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.Jogo;
import br.ufrpe.jjgameson.entidades.Pessoa;
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
import java.util.ArrayList;

public class CardTelaPrincipalClienteControlador {

    private Jogo joguinho;
    private Pessoa clienteLogado;

        @FXML
        private ImageView capa;

        @FXML
        private Label dev;

        @FXML
        private Hyperlink nome;

        @FXML
        private HBox cardLayout;

        @FXML
        private Label preco;

        @FXML
        void nomeJogoCard(ActionEvent event) throws IOException {
try {
    Stage stage;
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_jogo.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
    stage.setTitle("Mais sobre o jogo");
    stage.setResizable(false);
    stage.show();

    TelaJogoControlador telaJogoControlador = fxmlLoader.getController();
    telaJogoControlador.atualizarInformacoes(joguinho);
}catch (IOException e){e.printStackTrace();}

        }

        public void setInformacoes(Jogo jogo){
            joguinho = jogo;
            Image image = null;
            try{
               image = new Image(jogo.getPath());
            } catch (Exception e){
                e.printStackTrace();
            }

            capa.setImage(image);
            nome.setText(jogo.getNome());
            dev.setText(jogo.getDesenvolvedora());
            String oValor = Double.toString(jogo.getValor());
            preco.setText(oValor);
        }

        public void pegarCliente(Pessoa cliente){
            clienteLogado = cliente;
        }
    public Jogo getJoguinho() {
        return joguinho;
    }

    public void setJoguinho(Jogo joguinho) {
        this.joguinho = joguinho;
    }
}

