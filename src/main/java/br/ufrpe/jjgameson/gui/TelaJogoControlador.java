package br.ufrpe.jjgameson.gui;
import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.ItemVenda;
import br.ufrpe.jjgameson.entidades.Jogo;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaJogoControlador implements Initializable {

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10);
                valueFactory.setValue(1);
                quantidadeJogo.setValueFactory(valueFactory);
                quantidade = quantidadeJogo.getValue();
        }

        private Jogo jogoA;

        private int quantidade;

        private Pessoa clienteLogado;

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
        private Spinner<Integer> quantidadeJogo;

        @FXML
        void btnAdicionarAoCarrinhoTelaJogo(ActionEvent event) throws IOException {
                ItemVenda compra = new ItemVenda(jogoA, quantidade);
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
        void btnAvaliarTelaJogo(ActionEvent event) throws IOException {

                // Tentar implementar if else ou try catch caso o cliente tenha ou não o jogo assim que os arquivos estiverem ok
                try {
                        /*
                        * Método pra ver se o cliente tem o jogo
                        *
                        * se sim
                        * */
                        Stage stage;
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_avaliacao.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
                        stage.setTitle("Avalie o jogo!");
                        stage.setResizable(false);
                        stage.show();

                        TelaAvaliacaoControlador telaAvaliacaoControlador = fxmlLoader.getController();
                        telaAvaliacaoControlador.jogoParaAvaliar(jogoA);

                }catch (Exception e){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Aviso");
                        alert.setHeaderText("Ausência de jogo");
                        alert.setContentText("Você não possui o jogo em seu histórico de compras, para avaliar um jogo na loja é necessário obter pelo menos uma unidade.");
                        alert.showAndWait();
                }




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

        public void pegarCliente(Pessoa cliente){
                clienteLogado = cliente;
        }

}

