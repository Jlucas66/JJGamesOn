package br.ufrpe.jjgameson.gui;

    import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

    import java.io.IOException;

public class TelaPrincipalADMControlador {

        @FXML
        private Button botaoAdicionarJogo;

        @FXML
        private Button botaoEditarJogo;

        @FXML
        private Button botaoGerenciarPromocoes;

        @FXML
        private Button botaoRelatorioDeVendas;

        @FXML
        private Button botaoRemoverJogo;

        @FXML
        private Button botaoSair;

        @FXML
        private ImageView logoPrincipalADM;

        @FXML
        void btnAdicionarJogoADM(ActionEvent event) throws IOException {
GerenciadorDeTelas.irParaTelaAdicionarJogo(event);
        }

        @FXML
        void btnEditarJogoADM(ActionEvent event) throws IOException {
GerenciadorDeTelas.irParaTelaEditarJogo(event);
        }

        @FXML
        void btnRelatorioDeVendasADM(ActionEvent event) throws IOException {
GerenciadorDeTelas.irParaTelaRelatorioDeVendas(event);
        }

        @FXML
        void btnRemoverJogoADM(ActionEvent event) throws IOException {
GerenciadorDeTelas.irParaTelaRemoverJogo(event);
        }

        @FXML
        void btnSairADM(ActionEvent event) throws IOException{
              GerenciadorDeTelas.irParaTelaLoginADM(event);
        }

    }


