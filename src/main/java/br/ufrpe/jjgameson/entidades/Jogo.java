package br.ufrpe.jjgameson.entidades;

import java.util.Objects;

public class Jogo {
    private int id;
    private String nome;
    private String codigo;
    private double valor;
    private String desenvolvedora;
    private String genero;
    private String resumo;
    private FaixaEtaria faixaEtaria;

    public Jogo(int id,String nome, double valor, String desenvolvedora, String genero, String resumo, FaixaEtaria faixaEtaria) {
        this.id = id;
        this.nome = nome;
        this.codigo = null;
        this.valor = valor;
        this.desenvolvedora = desenvolvedora;
        this.genero = genero;
        this.resumo = resumo;
        this.faixaEtaria = faixaEtaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return id == jogo.id && Double.compare(valor, jogo.valor) == 0 && Objects.equals(nome, jogo.nome) && Objects.equals(desenvolvedora, jogo.desenvolvedora) && Objects.equals(genero, jogo.genero) && Objects.equals(resumo, jogo.resumo) && faixaEtaria == jogo.faixaEtaria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, valor, desenvolvedora, genero, resumo, faixaEtaria);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getCodigo(){
        return codigo;
    }

}
