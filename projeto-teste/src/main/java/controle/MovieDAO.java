package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Movie;

public class MovieDAO {

	public boolean inserir(Movie m) {
		
		Conexao_bd c = Conexao_bd.getInstancia();
		
		Connection con = c.conectar();
		
		String query = "INSERT INTO teste(idMovie, nomeMovie) values (?,?) ";
		
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
}
