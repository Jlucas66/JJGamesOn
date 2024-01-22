package br.ufrpe.jjgameson.gui;
import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.Avaliacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaAvaliacaoControlador implements Initializable {

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,5);
            valueFactory.setValue(1);
            notaTelaAvaliacao.setValueFactory(valueFactory);

            avaliacoes = new ArrayList<>(avaliacoes());
            try{
                for(int i = 0; i < avaliacoes.size(); i++){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(HelloApplication.class.getResource("cardPrincipalCliente.fxml"));
                    VBox cardBox = fxmlLoader.load();
                    CardTelaAvaliacaoControlador cardTelaAvaliacaoControlador = fxmlLoader.getController();
                    cardTelaAvaliacaoControlador.setInformacoes(avaliacoes.get(i));
                    vboxTelaAvaliacao.getChildren().add(cardBox);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        private List<Avaliacao> avaliacoes(){
            List<Avaliacao> ava = new ArrayList<>();

            return ava;
        }
        List<Avaliacao> avaliacoes;
        @FXML
        private Button botaoAvaliar;

        @FXML
        private Button botaoCancelar;

        @FXML
        private ImageView capaTelaAvaliacao;

        @FXML
        private TextArea comentarioTelaAvaliacao;

        @FXML
        private ImageView logoTelaAvaliacao;

        @FXML
        private Label nomeTelaAvaliacao;

        @FXML
        private Spinner<Integer> notaTelaAvaliacao;

        @FXML
        private VBox vboxTelaAvaliacao;

        @FXML
        void btnAvaliarTelaAvaliacao(ActionEvent event) throws IOException{

        }

        @FXML
        void btnCancelarTelaAvaliacao(ActionEvent event) throws IOException{
GerenciadorDeTelas.irParaTelaJogo(event);
        }


}

