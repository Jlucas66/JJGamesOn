package br.ufrpe.jjgameson.gui;
import br.ufrpe.jjgameson.entidades.Avaliacao;
import br.ufrpe.jjgameson.entidades.Jogo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class CardTelaAvaliacaoControlador {

        @FXML
        private TextArea comentarioCardTelaAvaliacao;

        @FXML
        private Label notaCardTelaAvaliacao;

        @FXML
        private Label usuarioCardTelaAvaliacao;

        @FXML
        private VBox vboxCardTelaAvaliacao;

    public void setInformacoes(Avaliacao avaliacao){
        comentarioCardTelaAvaliacao.setText(avaliacao.getComentario());
        notaCardTelaAvaliacao.setText(Integer.toString(avaliacao.getNota()));
        //usuarioCardTelaAvaliacao.setText(avaliacao.getCliente());
    }
    }

