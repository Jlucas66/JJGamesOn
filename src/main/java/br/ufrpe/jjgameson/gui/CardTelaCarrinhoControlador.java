package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.entidades.ItemVenda;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CardTelaCarrinhoControlador {

        private Jogo jogg;
        private ItemVenda item;
        private TelaCarrinhoControlador telaCarrinhoControlador;
        @FXML
        private ImageView capa;

        @FXML
        private VBox cardLayoutCarrinho;

        @FXML
        private Label nome;

        @FXML
        private Label preco;

        @FXML
        private Label quantidade;

        @FXML
        private Hyperlink removerDoCarrinho;

        @FXML
        private Label valorTotal;

        @FXML
        void removerDoCarrinhoJogoCard(ActionEvent event) throws IOException {
                telaCarrinhoControlador.removerDoCarrinho(jogg, item);
                telaCarrinhoControlador.atualizarCarrinho(event);
        }

        public void setInformacoes(Jogo jogo, ItemVenda itemVenda){
                Image image = null;
                jogg = jogo;
                item = itemVenda;
                try{
                        image = new Image(jogo.getPath());
                } catch (Exception e){
                         e.printStackTrace();
                }

                capa.setImage(image);
                nome.setText(jogo.getNome());
                String oValor = Double.toString(jogo.getValor());
                preco.setText(oValor);
                String quant = Integer.toString(itemVenda.getQuantidade());
                quantidade.setText(quant);
                String vTotal = Double.toString(itemVenda.getValorTotal());
                valorTotal.setText(vTotal);
        }
        public void setCarrinhoControlador(TelaCarrinhoControlador carrinhoControlador) {
                this.telaCarrinhoControlador = carrinhoControlador;
        }
    }

