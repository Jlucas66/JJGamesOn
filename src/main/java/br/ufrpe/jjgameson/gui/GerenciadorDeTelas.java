package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GerenciadorDeTelas {

    public static void irParaTelaLoginCliente (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_login_cliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaCadastro (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_cadastro_cliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Cadastre-se");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaLoginADM (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_login_adm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("LOGIN ADMs");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaPrincipalADM (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_principal_adm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Opções de administrador");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaAdicionarJogo (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_adicionar_jogo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Adicionar um jogo");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaRemoverJogo (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_remover_jogo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Remover um jogo");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaEditarJogo (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_editar_jogo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Editar um jogo");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaRelatorioDeVendas (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_relatorio_de_vendas.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Relatório de vendas");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaGerenciarPromocoes (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_gerenciar_promocoes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Gerenciar promoções");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaCompraFinalizada (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_compra_finalizada.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Compra finalizada");
        stage.setResizable(false);
        stage.show();
    }
}
