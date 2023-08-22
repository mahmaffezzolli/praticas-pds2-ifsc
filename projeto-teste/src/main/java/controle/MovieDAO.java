package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Movie;

public class MovieDAO {

	
	public ArrayList<Movie> listar(){
		
        Conexao_bd c = Conexao_bd.getInstancia();
		
		Connection con = c.conectar();
		ArrayList<Movie> movies = new ArrayList();
		
		String query = "SELECT FROM * MOVIES";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			int movieId = rs.getInt("id_movie");
			String nomeMovie = rs.getString("titulo_movie");
			
			Movie m = new Movie();
			m.setIdMovie(movieId);
			m.setNomeMovie(nomeMovie);
			
			movies.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		c.fecharConexao();

		
		
		return movies;
	}
	
	public boolean inserir(Movie m) {
		
		Conexao_bd c = Conexao_bd.getInstancia();
		
		Connection con = c.conectar();
		
		String query = "INSERT INTO bancoteste(idMovie, nomeMovie) values (?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, m.getIdMovie());
			ps.setString(2, m.getNomeMovie());
			
			ps.executeUpdate();
			c.fecharConexao();
			
			return true; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean excluir (Movie m) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = 'DELETE FROM movie WHERE id_movie = ?';
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.SetInt(1, m.getId());
			ps.executeDelete();
			c.fecharConexao();
			
			return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean atualizar (Movie m) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = 'UPDATE movie SET titulo_movie = ? WHERE id_movie = ?'
				
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.SetString(1, m.gettitulo_movie());
			ps.SetInt(2, m.getId());
			
			ps.executeUpdate();
			c.fecharConexao();
			
			return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false; 
	}
}
