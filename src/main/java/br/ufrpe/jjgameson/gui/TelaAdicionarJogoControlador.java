package br.ufrpe.jjgameson.gui;

    import br.ufrpe.jjgameson.dados.RepositorioCliente;
    import br.ufrpe.jjgameson.dados.RepositorioJogo;
    import br.ufrpe.jjgameson.entidades.FaixaEtaria;
    import br.ufrpe.jjgameson.entidades.Jogo;
    import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

    import java.io.IOException;

public class TelaAdicionarJogoControlador {

        @FXML
        private Button botaoAdicionar;

        @FXML
        private Button botaoVoltar;

        @FXML
        private TextField devAdicionarJogo;

        @FXML
        private TextField faixaAdicionarJogo;

        @FXML
        private TextField generoAdicionarJogo;

        @FXML
        private TextField idAdicionarJogo;

        @FXML
        private ImageView logoAdicionarJogo;

        @FXML
        private TextField nomeAdicionarJogo;

        @FXML
        private TextField pathAdicionarJogo;

        @FXML
        private TextArea resumoAdicionarJogo;

        @FXML
        private TextField valorAdicionarJogo;

        @FXML
        void btnAdicionarAdicionarJogo(ActionEvent event) throws IOException{
                String nomeJogo = nomeAdicionarJogo.getText();
                int idJogo = Integer.parseInt(idAdicionarJogo.getText());
                Double valorJogo = Double.parseDouble(valorAdicionarJogo.getText());
                String desenvolvedoraJogo = devAdicionarJogo.getText();
                String generoJogo = generoAdicionarJogo.getText();
                String faixaEtariaJogo = faixaAdicionarJogo.getText();
                String resumoJogo = resumoAdicionarJogo.getText();
                String pathJogo = pathAdicionarJogo.getText();
                Jogo jogo = new Jogo(idJogo, pathJogo, nomeJogo, valorJogo, desenvolvedoraJogo, generoJogo, resumoJogo, FaixaEtaria.valueOf(faixaEtariaJogo));
                RepositorioJogo.getInstance().inserirJogo(new Jogo(idJogo, pathJogo, nomeJogo, valorJogo, desenvolvedoraJogo, generoJogo, resumoJogo, FaixaEtaria.valueOf(faixaEtariaJogo)));
                RepositorioJogo repositorioJogo = (RepositorioJogo) RepositorioJogo.getInstance();
                try {
                        repositorioJogo.inserirJogoBD(jogo);
                        GerenciadorDeTelas.irParaTelaPrincipalADM(event);
                } catch (Exception e) {
                        e.printStackTrace();
                }

        }

        @FXML
        void btnVoltarAdicionarJogo(ActionEvent event) throws IOException {
                GerenciadorDeTelas.irParaTelaPrincipalADM(event);
        }

    }

