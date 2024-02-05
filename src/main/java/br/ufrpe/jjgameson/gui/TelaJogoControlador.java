package br.ufrpe.jjgameson.gui;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

