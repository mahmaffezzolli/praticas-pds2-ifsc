package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao_bd {	
		private static Connection conexao;
		private static Conexao_bd instancia;
		private static final String DATABASE = "bancoteste";
		private static final String USER     = "root";
		private static final String PSW      = "aluno";
		
		private Conexao_bd() {}
		
		public static Conexao_bd getInstancia() {
			if (instancia == null) { 
				instancia = new Conexao_bd(); 
			}
			return instancia;	
		}
		
		public Connection conectar() {
			try {
				conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+ DATABASE + "?serverTimezone=UTC", USER, PSW);
			} catch (Exception e) { 
				e.printStackTrace(); 
			}
			return conexao;		
		}
		
		public boolean fecharConexao() { 
			try { 
				conexao.close(); 
			} 
			catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

			return true;
		}
}
