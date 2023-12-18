package br.ufrpe.jjgameson.entidades;

import java.util.ArrayList;
import java.util.Random;

public class Codigo {
    private ArrayList<String> codigosGerados;

    public Codigo(int quantidade) {
        this.codigosGerados = gerarCodigos(quantidade);
    }

    public ArrayList<String> getCodigosGerados() {
        return codigosGerados;
    }

    public static ArrayList<String> gerarCodigos(int quantidade) {
        ArrayList<String> codigos = new ArrayList<>();

        for (int j = 0; j < quantidade; j++) {
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder codigo = new StringBuilder();

            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int indice = random.nextInt(caracteres.length());
                codigo.append(caracteres.charAt(indice));
            }

            codigos.add(codigo.toString());
        }
        return codigos;
    }
}
