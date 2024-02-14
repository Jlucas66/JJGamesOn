package br.ufrpe.jjgameson.gui;
import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.ItemVenda;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaJogoControlador {

        private Jogo jogoA;

        @FXML
        private Button botaoAdicionarAoCarrinho;

        @FXML
        private Button botaoAvaliar;

        @FXML
        private Button botaoVoltar;

        @FXML
        private ImageView capaTelaJogo;

        @FXML
        private TextArea descricaoTelaJogo;

        @FXML
        private Label devTelaJogo;

        @FXML
        private Label faixaEtariaTelaJogo;

        @FXML
        private Label generoTelaJogo;

        @FXML
        private ImageView logoTelaJogo;

        @FXML
        private Label nomeTelaJogo;

        @FXML
        private Label notaTelaJogo;

        @FXML
        private Label precoTelaJogo;

        @FXML
        void btnAdicionarAoCarrinhoTelaJogo(ActionEvent event) throws IOException {
                ItemVenda compra = new ItemVenda(jogoA, 1);
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("tela_carrinho.fxml"));
                loader.setControllerFactory(controllerClass -> {
                        if (controllerClass.equals(TelaCarrinhoControlador.class)) {
                                TelaCarrinhoControlador controller = new TelaCarrinhoControlador();
                                controller.guardarCompra(compra);
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

        @FXML
        void btnAvaliarTelaJogo(ActionEvent event) throws IOException{

        }

        @FXML
        void btnVoltarTelaJogo(ActionEvent event) throws IOException{
                GerenciadorDeTelas.irParaTelaPrincipalCliente(event);

        }

        public void atualizarInformacoes(Jogo jogo){
                jogoA = jogo;
                Image image = null;
                try{
                        image = new Image(jogo.getPath());
                } catch (Exception e){
                        e.printStackTrace();
                }
                capaTelaJogo.setImage(image);
                nomeTelaJogo.setText(jogo.getNome());
                descricaoTelaJogo.setText(jogo.getResumo());
                generoTelaJogo.setText(jogo.getGenero());
                String valorr = Double.toString(jogo.getValor());
                precoTelaJogo.setText(valorr);
                devTelaJogo.setText(jogo.getDesenvolvedora());
                String idadee = String.valueOf(jogo.getFaixaEtaria().getIdade());
                faixaEtariaTelaJogo.setText(idadee);
        }


}

