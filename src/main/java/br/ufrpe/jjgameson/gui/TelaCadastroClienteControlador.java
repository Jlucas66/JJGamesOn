package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.dados.RepositorioCliente;
import br.ufrpe.jjgameson.entidades.FaixaEtaria;
import br.ufrpe.jjgameson.entidades.Jogo;
import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.*;
import br.ufrpe.jjgameson.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLData;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class TelaCadastroClienteControlador implements Initializable {

    public TelaCadastroClienteControlador() {
    }

    LocalDate dataNascimento;

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

        String nomeCadastroString = nomeCadastro.getText();
        String emailCadastroString = emailCadastro.getText();
        String senhaCadastroString = senhaCadastro.getText();

        Pessoa cliente = new Pessoa(nomeCadastroString,emailCadastroString,senhaCadastroString,dataNascimento,false);
        try {
            Fachada.getInstance().inserirCliente(cliente);
            GerenciadorDeTelas.exibirAlertaMensagem("Conta Criada!", "Sua conta foi criada com sucesso!");
            GerenciadorDeTelas.irParaTelaLoginCliente(event);
        } catch (ElementoInvalidoException e) {
            GerenciadorDeTelas.exibirAlertaMensagem("ERRO","Elemento Inválido");
            throw new RuntimeException(e);
        } catch (ElementoNuloException e) {
            GerenciadorDeTelas.exibirAlertaMensagem("ERRO", "Os Campos não podem ficar vazios");
            throw new RuntimeException(e);
        } catch (SenhaFracaException e) {
            GerenciadorDeTelas.exibirAlertaMensagem("ERRO", "Senha fraca\n\n- Mínimo 8 caracteres\n- Letra maiúscula\n- Número\n- Caracter Especial");
            throw new RuntimeException(e);
        } catch (ElementoDuplicadoException e) {
            throw new RuntimeException(e);
        } catch (AcessoInvalidoException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void btnCadastroClienteVoltar(ActionEvent event) throws IOException{
        GerenciadorDeTelas.irParaTelaLoginCliente(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Adiciona um listener para a propriedade value do DatePicker
        dataNascimentoCadastro.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Atualiza a variável aData com o valor selecionado no DatePicker
            dataNascimento = newValue;
        });
    }
}
