package br.ufrpe.jjgameson.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaGerenciarPromocoesControlador {


                @FXML
                private Button botaoCriarPromocao;

                @FXML
                private Button botaoDeletarPromocao;

                @FXML
                private Button botaoVoltar;

                @FXML
                private ChoiceBox<?> choiceBoxJogo2GerenciarPromocoes;

                @FXML
                private ChoiceBox<?> choiceBoxNomeGerenciarPromocoes;

                @FXML
                private DatePicker dataFim2GerenciarPromocoes;

                @FXML
                private DatePicker dataInicio2GerenciarPromocoes;

                @FXML
                private TextField desconto2GerenciarPromocoes;

                @FXML
                private ImageView logoGerenciarPromocoes;

                @FXML
                private TextField nomeGerenciarPromocoes;

                @FXML
                void btnCriarPromocaoGerenciarPromocoes(ActionEvent event) throws IOException{

                }

                @FXML
                void btnDeletarPromocaoGerenciarPromocoes(ActionEvent event) throws IOException{

                }

                @FXML
                void btnVoltarGerenciarPromocoes(ActionEvent event) throws IOException{
GerenciadorDeTelas.irParaTelaPrincipalADM(event);
                }

        }



