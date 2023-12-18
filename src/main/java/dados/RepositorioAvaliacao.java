package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Avaliacao;	


public class RepositorioAvaliacao implements IRepositorioAvaliacao {
	private Connection conexao;
	
	public void AvaliacaoDAO() throws SQLException {
		this.conexao = ConexaoBD.obterConexao();
	}
  
	
	
// métodos do CRUD para avaliação
    
    public void inserir (Avaliacao avaliacao) {
    	String sql = "INSERT INTO avaliacao (comentario, dtAvaliacao, emailCliente, idAvaliacao, nomeJogo, nota) VALUES (?, ?, ?, ?, ?, ?)";
    			
    	try (PreparedStatement ps = conexao.prepareStatement(sql)){
    		ps.setString(1, avaliacao.getComentario());
    		ps.setTimestamp(2, avaliacao.getData());
    		ps.setString(3, avaliacao.getCliente().getEmail());
    		ps.setInt(4,  avaliacao.getIdAvaliacao());
    		ps.setString(5, avaliacao.getJogo().getNome());
    		ps.setDouble(6, avaliacao.getNota());
    		ps.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}			
    }
    
    public List<Avaliacao> listar() {
    	List<Avaliacao> avaliacao = new ArrayList <>();
    	String sql = "SELECT * FROM avaliacao";
    	
    	try (PreparedStatement ps = conexao.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

               while (rs.next()) {
                   Avaliacao avaliacao = new Avaliacao();
                   avaliacao.setIdAvaliacao(rs.getInt("id"));
                   avaliacao.add(avaliacao);
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return avaliacao;
       }

	public void atualizar (Avaliacao avaliacao) {
		String sql = "UPDATE avaliacao SET comentario = ?, dtAvaliacao = ?, emailCliente = ?, idAvaliacao = ?, nomeJogo = ?, nota = ? ";
		
		try (PreparedStatement ps = conexao.prepareStatement(sql)){
			ps.setString(1, avaliacao.getComentario());
    		ps.setTimestamp(2, avaliacao.getData());
    		ps.setString(3, avaliacao.getCliente().getEmail());
    		ps.setInt(4,  avaliacao.getIdAvaliacao());
    		ps.setString(5, avaliacao.getJogo().getNome());
    		ps.setDouble(6, avaliacao.getNota());
    		ps.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}			
	}
	
    public void excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }	
}	
