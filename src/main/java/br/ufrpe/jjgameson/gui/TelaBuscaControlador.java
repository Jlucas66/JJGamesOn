package br.ufrpe.jjgameson.gui;
import br.ufrpe.jjgameson.HelloApplication;
import br.ufrpe.jjgameson.entidades.FaixaEtaria;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaBuscaControlador implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buscados = new ArrayList<>(buscados());
        try{
            for(int i = 0; i < buscados.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(HelloApplication.class.getResource("cardTelaBusca.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardTelaBuscaControlador cardTelaBuscaControlador = fxmlLoader.getController();
                cardTelaBuscaControlador.setInformacoes(buscados.get(i));
                hboxTelaBusca.getChildren().add(cardBox);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private List<Jogo> buscados(){
        List<Jogo> busc = new ArrayList<>();

        return busc;
    }

    private List<Jogo> buscados;

        @FXML
        private Button botaoBuscar;

        @FXML
        private Button botaoVoltar;

        @FXML
        private ImageView capaTelaBusca;

        @FXML
        private HBox hboxTelaBusca;

        @FXML
        private TextField nomeTelaBusca;

        @FXML
        private ScrollPane scrollPaneTelaBusca;

        @FXML
        void btnBuscarTelaBusca(ActionEvent event) throws IOException{

        }

        @FXML
        void btnVoltarTelaBusca(ActionEvent event) throws IOException{
GerenciadorDeTelas.irParaTelaPrincipalCliente(event);
        }


}

