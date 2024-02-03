package br.ufrpe.jjgameson.dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.jjgameson.entidades.Avaliacao;
import br.ufrpe.jjgameson.exceptions.ElementoNuloException;
import br.ufrpe.jjgameson.exceptions.DBException;
import br.ufrpe.jjgameson.gui.GerenciadorDeTelas;
import javafx.scene.control.Alert;


public class RepositorioAvaliacao implements IRepositorioAvaliacao {

	private ArrayList<Avaliacao> avaliacoes;
	private static IRepositorioAvaliacao instance;

	private RepositorioAvaliacao() {
		avaliacoes = new ArrayList<>();
	}
	public static IRepositorioAvaliacao getInstance(){
		if(instance == null){
			instance = new RepositorioAvaliacao();
		}
		return instance;
	}

	@Override
	public void inserir(Avaliacao avaliacao){
			avaliacoes.add(avaliacao);
		}
	public void inserirBD(Avaliacao avaliacao) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = ConexaoBD.getConnection();
			st = conn.createStatement();
			st.executeUpdate("INSERT INTO Avaliacao (Cliente, Jogo. nota, comentario, data) VALUES('" + avaliacao.getCliente() +"', '" + avaliacao.getJogo() +"' , '" + avaliacao.getNota() +"' , '" + avaliacao.getComentario() + "', '" + avaliacao.getData() + "' ,)");
		} catch(SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			ConexaoBD.closeStatement(st);
			ConexaoBD.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Avaliacao> listar(){
		return avaliacoes;
		}
	
	public Avaliacao listarBD() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Avaliacao avaliacao = null;
		
		try {
			conn = ConexaoBD.getConnection();
			st = conn.createStatement();
			st.executeQuery("SELECT * FROM avaliacao");
		
		if (rs.next()) {
			avaliacao = new Avaliacao(rs.getString("Cliente"), rs.getString("Jogo"), rs.getString("Comentario"), rs.getString("Data"));
		 }
		}
		catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			ConexaoBD.closeStatement(st);
			ConexaoBD.closeResultSet(rs);
		}
		return avaliacao;
	}
	

	@Override
	public void atualizar(Avaliacao avaliacaoAntiga, Avaliacao novaAvaliacao) {
		for (Avaliacao avaliacao : avaliacoes) {
			if (avaliacao.equals(avaliacaoAntiga)) {
				int index = avaliacoes.indexOf(avaliacao);
				avaliacoes.set(index, novaAvaliacao);
				break;
			}
		}
	}

	@Override
	public void excluir(Avaliacao avaliacaoParaExcluir) {
		for (Avaliacao avaliacao : avaliacoes) {
			if (avaliacao.equals(avaliacaoParaExcluir)) {
				avaliacoes.remove(avaliacao);
				break;
			}
		}
	}
	public void atualizarBD(String comentario) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = ConexaoBD.getConnection();
			st = conn.createStatement();
			st.executeUpdate("UPDATE Avaliacao set comentario =  '" + comentario + "' WHERE comentario = '" + comentario + "'");
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			ConexaoBD.closeStatement(st);
			ConexaoBD.closeResultSet(rs);
		}
	}
	
	public void excluirBD(String comentario) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = ConexaoBD.getConnection();
			st = conn.createStatement();
			st.executeUpdate("DELETE FROM Avaliacao WHERE comentario = '" + comentario + "'");
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			ConexaoBD.closeStatement(st);
			ConexaoBD.closeResultSet(rs);
		}
	}
	
}
