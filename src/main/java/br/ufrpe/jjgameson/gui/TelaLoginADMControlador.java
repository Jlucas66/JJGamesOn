package br.ufrpe.jjgameson.gui;

import br.ufrpe.jjgameson.dados.IRepositorioAdmin;
import br.ufrpe.jjgameson.dados.RepositorioAdmin;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaLoginADMControlador {

    @FXML
    private Button botaoEntrarComoADM;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField emailLoginADM;

    @FXML
    private ImageView logoLoginADM;

    @FXML
    private PasswordField senhaLoginADM;

    @FXML
    void btnLoginADMEntrarComoADM(ActionEvent event) throws IOException{
        //RepositorioAdmin repositorioAdmin = (RepositorioAdmin) RepositorioAdmin.getInstance();
        try{
           /* if (repositorioAdmin.verificarloginADMBD(emailLoginADM.getText(), senhaLoginADM.getText())){
                GerenciadorDeTelas.irParaTelaPrincipalADM(event);
            } */
            if(Fachada.getInstance().verificarloginADMBD(emailLoginADM.getText(), senhaLoginADM.getText())){
                GerenciadorDeTelas.irParaTelaPrincipalADM(event);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnLoginADMVoltar(ActionEvent event) throws IOException {
        GerenciadorDeTelas.irParaTelaLoginCliente(event);
    }

}

