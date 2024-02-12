package br.ufrpe.jjgameson.gui;
    import br.ufrpe.jjgameson.HelloApplication;
    import br.ufrpe.jjgameson.entidades.FaixaEtaria;
    import br.ufrpe.jjgameson.entidades.Jogo;
    import javafx.event.ActionEvent;
import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Node;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.ResourceBundle;

public class TelaPrincipalClienteControlador implements Initializable {

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                 catalogo = new ArrayList<>(catalogo());

        try{
                for(int i = 0; i < catalogo.size(); i++){
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(HelloApplication.class.getResource("cardPrincipalCliente.fxml"));
                        HBox cardBox = fxmlLoader.load();
                        CardTelaPrincipalClienteControlador cardTelaPrincipalClienteControlador = fxmlLoader.getController();
                        cardTelaPrincipalClienteControlador.setInformacoes(catalogo.get(i));
                        hboxPrincipalCliente.getChildren().add(cardBox);
                }
        }
           catch (IOException e){
                e.printStackTrace();
           }

        }

        private List<Jogo> catalogo(){
                List<Jogo> cata = new ArrayList<>();
                Jogo jogo1 = new Jogo(1,"@imagens/minecraft.jpg","Minecraft",29.99,"Mojang Studios","Casual","Um jogo casual de construção", FaixaEtaria.LIVRE);
                cata.add(jogo1);
                Jogo jogo2 = new Jogo(2,"@imagens/gtaV.jpg","GTA V",69.99,"Rockstar Games","Ação","Um jogo de ação", FaixaEtaria.DEZESSEIS);
                cata.add(jogo2);
                return cata;
        }



        private ArrayList<Jogo> filtro = new ArrayList<>();
        private List<Jogo> catalogo;

        @FXML
        private HBox hboxPrincipalCliente;

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
        void btnCasualPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnFPSPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnMobaPrincipalCliente(ActionEvent event) throws IOException{

        }
        @FXML
        void btnSimulacaoPrincipalCliente(ActionEvent event) throws IOException{

        }

        @FXML
        void btnTerrorPrincipalCliente(ActionEvent event) throws IOException{

        }
        @FXML
        void btnPesquisarPrincipalCliente(ActionEvent event) throws IOException{

String oNomeDoJogo = nomePesquisa.getText();
for(int i = 0; i < catalogo.size(); i++){
        if(catalogo.get(i).getNome().equalsIgnoreCase(oNomeDoJogo.trim())){
                filtro.add(catalogo.get(i));
        }
}
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("tela_busca.fxml"));
            loader.setControllerFactory(controllerClass -> {
                if (controllerClass.equals(TelaBuscaControlador.class)) {
                    TelaBuscaControlador controller = new TelaBuscaControlador();
                    controller.setarInformacoes(filtro);
                    return controller;
                } else {return null;}
            });

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 900, 600));
            stage.setTitle("Sua busca");
            stage.setResizable(false);
            stage.show();
        }
        @FXML
        void btnCarrinhoPrincipalCliente(ActionEvent event) throws IOException{
                GerenciadorDeTelas.irParaTelaCarrinho(event);
        }

        @FXML
        void btnHistoricoPrincipalCliente(ActionEvent event) throws IOException{
GerenciadorDeTelas.irParaTelaHistorico(event);
        }

        @FXML
        void btnSairDaContaPrincipalCliente(ActionEvent event) throws IOException {
                GerenciadorDeTelas.irParaTelaLoginCliente(event);
        }

}
