package br.ufrpe.jjgameson.dados;

import br.ufrpe.jjgameson.entidades.Pessoa;
import br.ufrpe.jjgameson.exceptions.*;
import br.ufrpe.jjgameson.gui.GerenciadorDeTelas;
import br.ufrpe.jjgameson.exceptions.AcessoInvalidoException;
import br.ufrpe.jjgameson.exceptions.DBException;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAdmin implements IRepositorioAdmin {
    private ArrayList<Pessoa> admins;
    private static IRepositorioAdmin instance;
    private RepositorioAdmin() {
        admins = new ArrayList<>();
    }
    public static IRepositorioAdmin getInstance() {
        if (instance == null) {
            instance = new RepositorioAdmin();
        }
        return instance;
    }
    @Override
    public void inserir(Pessoa admin) {
        admins.add(admin);
    }
    @Override
    public Pessoa obterAdminPorEmail(String email) {
        for (Pessoa admin : admins) {
            if (admin.getEmail().equals(email)) return admin;
        }
        return null;
    }
    @Override
    public List<Pessoa> listar() {
        return admins;
    }
    @Override
    public void atualizar(Pessoa adminAntigo, Pessoa adminNovo) {
        admins.set(admins.indexOf(adminAntigo), adminNovo);
    }
    @Override
    public void excluir(Pessoa adminParaExcluir) {
        admins.remove(adminParaExcluir);
    }
}
