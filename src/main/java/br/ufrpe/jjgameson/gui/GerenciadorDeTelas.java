package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    public static void irParaTelaPrincipalCliente (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_principal_cliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Seja bem-vindo(a)!");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaBusca (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_busca.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Buscar");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaCarrinho (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_carrinho.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Seu carrinho");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaJogo (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_jogo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Mais sobre o jogo");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaAvaliacao (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_avaliacao.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Avalie o jogo");
        stage.setResizable(false);
        stage.show();
    }
    public static void irParaTelaHistorico (ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_historico.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 600));
        stage.setTitle("Seu histórico");
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

    //Avisos
    public static void exibirAlertaMensagem(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); // Sem cabeçalho adicional
        alerta.setContentText(mensagem);

        alerta.showAndWait();
    }

}
