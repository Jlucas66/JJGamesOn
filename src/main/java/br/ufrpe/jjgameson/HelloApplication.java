package br.ufrpe.jjgameson;

import br.ufrpe.jjgameson.dados.*;
import br.ufrpe.jjgameson.entidades.Pessoa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_principal_cliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {

        //Instanciando Repositórios
        RepositorioAdmin repositorioAdmin = (RepositorioAdmin) RepositorioAdmin.getInstance();
        RepositorioCliente repositorioCliente = (RepositorioCliente) RepositorioCliente.getInstance();
        RepositorioCodigo repositorioCodigo = (RepositorioCodigo) RepositorioCodigo.getInstance();
        RepositorioJogo repositorioJogo = (RepositorioJogo) RepositorioJogo.getInstance();
        RepositorioVenda repositorioVenda = (RepositorioVenda) RepositorioVenda.getInstance();

        Pessoa pessoaLogada = null;

        launch();
    }
}