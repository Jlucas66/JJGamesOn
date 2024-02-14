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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                oValorTotal = 0.0;

                try {
                        for (int i = 0; i < jogoNoCarrinho.size(); i++) {
                                Jogo jogo = jogoNoCarrinho.get(i);
                                ItemVenda itemVenda = itemNoCarrinho.get(i);
                                oValorTotal += jogo.getValor();
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(HelloApplication.class.getResource("cardTelaCarrinho.fxml"));
                                VBox cardBox = fxmlLoader.load();
                                CardTelaCarrinhoControlador cardTelaCarrinhoControlador = fxmlLoader.getController();
                                cardTelaCarrinhoControlador.setInformacoes(jogo, itemVenda);
                                cardTelaCarrinhoControlador.setCarrinhoControlador(this);
                                vboxTelaCarrinho.getChildren().add(cardBox);

                        }
                        DecimalFormat df = new DecimalFormat("#,##0.00");
                        String valorTotalFormatado = df.format(oValorTotal);
                        valorTotalCarrinho.setText(valorTotalFormatado);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        private static List<Jogo> jogoNoCarrinho = new ArrayList<>();
        private static List<ItemVenda> itemNoCarrinho = new ArrayList<>();
        
        /*
                ***********************************************************
                *   ATENÇÃO PARA ARRUMAR ISSO AQUI, É APENAS PROVISÓRIO   *
                ***********************************************************

        */

        static Pessoa provisorio = new Pessoa("Josimar", "josimar@gmail.com", "123", LocalDate.now(), false);
        private static Venda venda = new Venda(provisorio, LocalDateTime.now());
        private static Double oValorTotal = 0.0;

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
                jogoNoCarrinho.clear();
                atualizarCarrinho(event);
        }

        @FXML
        void btnVoltaParaALojaTelaCarrinho(ActionEvent event) throws IOException {
                GerenciadorDeTelas.irParaTelaPrincipalCliente(event);
        }

        public void atualizarCarrinho(ActionEvent event) throws IOException{
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("tela_carrinho.fxml"));
                loader.setControllerFactory(controllerClass -> {
                        if (controllerClass.equals(TelaCarrinhoControlador.class)) {
                                TelaCarrinhoControlador controller = new TelaCarrinhoControlador();
                                return controller;
                        } else {return null;}
                });

                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root, 900, 600));
                stage.setTitle("Seu carrinho");
                stage.setResizable(false);
                stage.show();
        }

        public void guardarCompra(ItemVenda compra) {
                jogoNoCarrinho.add(compra.getJogo());
                itemNoCarrinho.add(compra);
                venda.adicionarItemVenda(compra);
        }

        public void removerDoCarrinho(Jogo jogo, ItemVenda itemVenda) {
                jogoNoCarrinho.remove(jogo);
                itemNoCarrinho.remove(itemVenda);
                venda.removerItemVenda(itemVenda);
        }

}

