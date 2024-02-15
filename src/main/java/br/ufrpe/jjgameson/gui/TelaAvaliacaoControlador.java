package br.ufrpe.jjgameson.gui;
import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.Avaliacao;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaAvaliacaoControlador implements Initializable {

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,5);
            valueFactory.setValue(1);
            notaTelaAvaliacao.setValueFactory(valueFactory);
            nota = notaTelaAvaliacao.getValue();

            avaliacoes = new ArrayList<>(avaliacoes());
            try{
                for(int i = 0; i < avaliacoes.size(); i++){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(HelloApplication.class.getResource("cardTelaAvaliacao.fxml"));
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
        Jogo jogo1;
        List<Avaliacao> avaliacoes;
        int nota = 0;
        LocalDateTime dataAgora = LocalDateTime.now();

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
            // Avaliacao avaliacao = new Avaliacao (clienteLogado(), jogo1, nota, comentarioTelaAvaliacao.getText(), dataAgora);

            //Alert de avaliação concluída com sucesso
            //Precisa ser feito a verificação se é possível avaliar o jogo
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Concluído");
            alert.setHeaderText("Avaliação de jogo");
            alert.setContentText("Sua avaliação do jogo " + jogo1 + " foi registrada com sucesso!");
            alert.showAndWait();

            // Salvar a avaliação nos arquivos

            GerenciadorDeTelas.irParaTelaPrincipalCliente(event);
        }

        @FXML
        void btnCancelarTelaAvaliacao(ActionEvent event) throws IOException{

            //Alert

         GerenciadorDeTelas.irParaTelaJogo(event);
        }

        public void jogoParaAvaliar(Jogo jogo){
            jogo1 = jogo;
            capaTelaAvaliacao.setImage(new Image(jogo.getPath()));
            nomeTelaAvaliacao.setText(jogo.getNome());
        }


}

