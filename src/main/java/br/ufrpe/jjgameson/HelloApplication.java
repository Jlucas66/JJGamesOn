package br.ufrpe.jjgameson;

import br.ufrpe.jjgameson.dados.*;
import br.ufrpe.jjgameson.entidades.FaixaEtaria;
import br.ufrpe.jjgameson.entidades.Jogo;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.*;
import br.ufrpe.jjgameson.negocio.Fachada;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static br.ufrpe.jjgameson.entidades.FaixaEtaria.LIVRE;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_login_cliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) throws ElementoInvalidoException, ElementoNuloException, ElementoDuplicadoException, SenhaFracaException, AcessoInvalidoException {

        Pessoa pessoaLogada = null;

        Pessoa cliente = new Pessoa("exemplo", "exemplo@gmail.com","Senha123@",LocalDate.now(),false);
        Fachada.getInstance().inserirCliente(cliente);

        Jogo jogo = new Jogo(1,"https://super.abril.com.br/wp-content/uploads/2018/08/futebol-brasil.png?w=1024&resize=1200,800", "Jogo1", 10, "Rural", "Aventura", "resumoJogo", FaixaEtaria.LIVRE);
        Jogo jogo2 = new Jogo(2,"https://super.abril.com.br/wp-content/uploads/2018/08/futebol-brasil.png?w=1024&resize=1200,800", "Jogo2", 10, "Rural", "Terror", "resumoJogo", FaixaEtaria.LIVRE);
        Jogo jogo3 = new Jogo(3,"https://super.abril.com.br/wp-content/uploads/2018/08/futebol-brasil.png?w=1024&resize=1200,800", "Jogo3", 10, "Rural", "Casual", "resumoJogo", FaixaEtaria.LIVRE);
        Fachada.getInstance().inserirJogo(jogo);
        Fachada.getInstance().inserirJogo(jogo2);
        Fachada.getInstance().inserirJogo(jogo3);


        launch();
    }
}