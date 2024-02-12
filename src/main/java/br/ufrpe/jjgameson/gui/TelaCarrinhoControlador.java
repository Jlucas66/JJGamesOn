package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.ItemVenda;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class TelaCarrinhoControlador implements Initializable {

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                System.out.println("Tamanho da lista jogos: " + jogoNoCarrinho.size());
                System.out.println("Tamanho da lista itemvenda: " + itemNoCarrinho.size());
                vboxTelaCarrinho.getChildren().clear();
                try {
                        for (int i = 0; i < jogoNoCarrinho.size(); i++) {
                                for (int u = 0; u < itemNoCarrinho.size(); u++) {
                                        //itemNoCarrinho.get(u).setJogo(jogoNoCarrinho.get(i));
                                        FXMLLoader fxmlLoader = new FXMLLoader();
                                        fxmlLoader.setLocation(HelloApplication.class.getResource("cardTelaCarrinho.fxml"));
                                        VBox cardBox = fxmlLoader.load();
                                        CardTelaCarrinhoControlador cardTelaCarrinhoControlador = fxmlLoader.getController();
                                        cardTelaCarrinhoControlador.setInformacoes(TelaCarrinhoControlador.jogoNoCarrinho.get(i), TelaCarrinhoControlador.itemNoCarrinho.get(u));
                                        vboxTelaCarrinho.getChildren().add(cardBox);

                                }

                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
/*
        private List<Jogo> jogoNoCarrinho() {
                List<Jogo> car = new ArrayList<>();

                return car;
        }

        private List<ItemVenda> itemNoCarrinho() {
                List<ItemVenda> itens = new ArrayList<>();

                return itens;
        }
*/
        private static List<Jogo> jogoNoCarrinho = new ArrayList<>();
        private static List<ItemVenda> itemNoCarrinho = new ArrayList<>();

        @FXML
        private Button botaoFinalizarCompra;

        @FXML
        private Button botaoLimparCarrinho;

        @FXML
        private Button botaoVoltarParaALoja;

        @FXML
        private Label promocaoCarrinho;

        @FXML
        private Label valorTotalCarrinho;

        @FXML
        private ImageView capaTelaCarrinho;

        @FXML
        private ScrollPane scrollPaneTelaCarrinho;

        @FXML
        private VBox vboxTelaCarrinho;

        @FXML
        void btnFinalizarComprarTelaCarrinho(ActionEvent event) throws IOException {
                GerenciadorDeTelas.irParaTelaCompraFinalizada(event);
        }

        @FXML
        void btnLimparCarrinhoTelaCarrinho(ActionEvent event) throws IOException {
                itemNoCarrinho.clear();
        }

        @FXML
        void btnVoltaParaALojaTelaCarrinho(ActionEvent event) throws IOException {
                GerenciadorDeTelas.irParaTelaPrincipalCliente(event);
        }
/*
        public void atualizarCarrinho() {
                vboxTelaCarrinho.getChildren().clear();
                for (int i = 0; i < jogoNoCarrinho.size(); i++) {
                        for (int u = 0; u < itemNoCarrinho.size(); u++) {
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(HelloApplication.class.getResource("cardTelaCarrinho.fxml"));
                                try {
                                        VBox cardBox = fxmlLoader.load();
                                        CardTelaCarrinhoControlador cardTelaCarrinhoControlador = fxmlLoader.getController();
                                        cardTelaCarrinhoControlador.setInformacoes(jogoNoCarrinho.get(i), itemNoCarrinho.get(u));
                                        vboxTelaCarrinho.getChildren().add(cardBox);
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }
*/
        public void guardarJogo(Jogo jogo) {
                jogoNoCarrinho.add(jogo);
                Random rand = new Random();
                int id = rand.nextInt(101); // TEMPORÁRIO!!! Gerando ID aleatório entre 0 e 100
                ItemVenda itemVenda = new ItemVenda(jogo, 1, id);
                itemNoCarrinho.add(itemVenda);
        }

}

