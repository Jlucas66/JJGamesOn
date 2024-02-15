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

        Pessoa cliente = new Pessoa("exemplo", "exemplo@gmail.com","Senha123@",LocalDate.now(),false);
        Fachada.getInstance().inserirCliente(cliente);
        Pessoa admin1 = new Pessoa("João", "joaoemail@gmail.com", "Senha@123", LocalDate.of(1999,12,12),true);
        Fachada.getInstance().inserirAdmin(admin1);

        Jogo jogo1 = new Jogo("https://upload.wikimedia.org/wikipedia/pt/9/9c/Minecraft_capa.png","Minecraft",29.90,"Mojang Studios","Casual","Um jogo casual de construção", FaixaEtaria.LIVRE);
        Jogo jogo2 = new Jogo("https://s2.glbimg.com/CA-YqcadfhLkfw53DX3h6DHzx5BwmWUnVlCB89ixErNIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/jo/g1/f/original/2012/11/08/coverreg610.jpg","GTA V",69.90,"Rockstar Games","Ação","Um jogo de ação", FaixaEtaria.DEZESSEIS);
        Jogo jogo3 = new Jogo("https://images.igdb.com/igdb/image/upload/t_cover_big_2x/co2hby.jpg", "Phasmophobia", 27.89, "Kinect Games", "Terror", "Phasmophobia is a 4 player online co-op psychological horror.", FaixaEtaria.DEZESSEIS);
        Fachada.getInstance().inserirJogo(jogo1);
        Fachada.getInstance().inserirJogo(jogo2);
        Fachada.getInstance().inserirJogo(jogo3);


        launch();
    }
}