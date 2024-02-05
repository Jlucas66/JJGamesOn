package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.ItemVenda;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaCarrinhoControlador implements Initializable {

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                jogoNoCarrinho = new ArrayList<>(jogoNoCarrinho());
                try{
                        for(int i = 0; i < jogoNoCarrinho.size(); i++){
                                for(int u = 0; i < itemNoCarrinho.size(); i++){
                                        FXMLLoader fxmlLoader = new FXMLLoader();
                                        fxmlLoader.setLocation(HelloApplication.class.getResource("cardTelaCarrinho.fxml"));
                                        VBox cardBox = fxmlLoader.load();
                                        CardTelaCarrinhoControlador cardTelaCarrinhoControlador = fxmlLoader.getController();
                                        cardTelaCarrinhoControlador.setInformacoes(jogoNoCarrinho.get(i), itemNoCarrinho.get(i));
                                        vboxTelaCarrinho.getChildren().add(cardBox);
                                }

                        }
                }
                catch (IOException e){
                        e.printStackTrace();
                }
        }

        private List<Jogo> jogoNoCarrinho(){
                List<Jogo> car = new ArrayList<>();

                return car;
        }
        private List<ItemVenda> itemNoCarrinho(){
                List<ItemVenda> itens = new ArrayList<>();

                return itens;
        }

        private List<Jogo> jogoNoCarrinho;
        private List<ItemVenda> itemNoCarrinho;

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
        void btnLimparCarrinhoTelaCarrinho(ActionEvent event) throws IOException{

        }

        @FXML
        void btnVoltaParaALojaTelaCarrinho(ActionEvent event) throws IOException{
                GerenciadorDeTelas.irParaTelaPrincipalCliente(event);
        }


}

