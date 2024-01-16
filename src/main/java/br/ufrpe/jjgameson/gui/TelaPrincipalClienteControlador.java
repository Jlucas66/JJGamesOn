package br.ufrpe.jjgameson.gui;
    import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

    import java.io.IOException;

public class TelaPrincipalClienteControlador {

        @FXML
        private VBox VBoxPrincipalCliente;

        @FXML
        private Button botaoAcao;

        @FXML
        private Button botaoAventura;

        @FXML
        private Button botaoCarrinho;

        @FXML
        private Button botaoCasual;

        @FXML
        private Button botaoFPS;

        @FXML
        private Button botaoHistorico;

        @FXML
        private Button botaoMoba;

        @FXML
        private Button botaoPesquisar;

        @FXML
        private Button botaoSairDaConta;

        @FXML
        private Button botaoSimulacao;

        @FXML
        private Button botaoTerror;

        @FXML
        private ImageView capaPrincipalCliente;

        @FXML
        private TextField nomePesquisa;

        @FXML
        private ScrollPane scrollPanePrincipalCliente;

        @FXML
        void btnAcaoPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnAventuraPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnCarrinhoPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnCasualPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnFPSPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnHistoricoPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnMobaPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnPesquisarPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnSairDaContaPrincipalCliente(ActionEvent event) throws IOException {
GerenciadorDeTelas.irParaTelaLoginCliente(event);
        }

        @FXML
        void btnSimulacaoPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnTerrorPrincipalCliente(ActionEvent event) throws IOException{

        }

    }
