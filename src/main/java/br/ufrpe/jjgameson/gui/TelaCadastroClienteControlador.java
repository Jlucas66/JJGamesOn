package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.dados.RepositorioCliente;
import br.ufrpe.jjgameson.entidades.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.sql.SQLData;
import java.time.LocalDate;
import java.util.Date;

public class TelaCadastroClienteControlador {

    public TelaCadastroClienteControlador() {
    }

    @FXML
    private Button botaoRealizarCadastro;

    @FXML
    private Button botaoVoltar;

    @FXML
    private ImageView capaCadastro;

    @FXML
    private DatePicker dataNascimentoCadastro;

    @FXML
    private TextField emailCadastro;

    @FXML
    private ImageView logoCadastro;

    @FXML
    private TextField nomeCadastro;

    @FXML
    private PasswordField senhaCadastro;

    @FXML
    public void btnCadastroClienteRealizarCadastro(ActionEvent event) throws IOException {
        String nomeCliente = nomeCadastro.getText();
        String emailCliente = emailCadastro.getText();
        String senhaCliente = senhaCadastro.getText();
        LocalDate dataNascimento = dataNascimentoCadastro.getValue();
        Pessoa Cliente = new Pessoa(nomeCliente, emailCliente, senhaCliente, dataNascimento, false);
        RepositorioCliente.getInstance().inserirCliente(new Pessoa(nomeCliente, emailCliente, senhaCliente, dataNascimento, false));

        RepositorioCliente repositorioCliente = (RepositorioCliente) RepositorioCliente.getInstance();
        try {
            repositorioCliente.inserirClienteBD(Cliente);
            GerenciadorDeTelas.irParaTelaLoginCliente(event);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void btnCadastroClienteVoltar(ActionEvent event) throws IOException{
        GerenciadorDeTelas.irParaTelaLoginCliente(event);
    }

}
