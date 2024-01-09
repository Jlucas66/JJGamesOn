package br.ufrpe.jjgameson.gui;

    import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

    import java.io.IOException;

public class TelaAdicionarJogoControlador {

        @FXML
        private Button botaoAdicionar;

        @FXML
        private Button botaoVoltar;

        @FXML
        private TextField devAdicionarJogo;

        @FXML
        private TextField faixaAdicionarJogo;

        @FXML
        private TextField generoAdicionarJogo;

        @FXML
        private TextField idAdicionarJogo;

        @FXML
        private ImageView logoAdicionarJogo;

        @FXML
        private TextField nomeAdicionarJogo;

        @FXML
        private TextField pathAdicionarJogo;

        @FXML
        private TextArea resumoAdicionarJogo;

        @FXML
        private TextField valorAdicionarJogo;

        @FXML
        void btnAdicionarAdicionarJogo(ActionEvent event) throws IOException{

        }

        @FXML
        void btnVoltarAdicionarJogo(ActionEvent event) throws IOException {
GerenciadorDeTelas.irParaTelaPrincipalADM(event);
        }

    }

