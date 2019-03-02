package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;

public class AdministradorDAO {
		
	
	public boolean checklogin(String usuario, String senha){
		//Cria a conecção e o statement
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			//Cria e prepara o statement
			stmt = con.prepareStatement("SELECT * FROM administrador WHERE UsuárioAdministrador = ? and SenhaAdministrador = ? ");
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			//Executando o statement e colocando o resultado dentro do ResultSet	
			rs = stmt.executeQuery();
			
			//Precorrendo o resultado e adicionando em uma Lista de Objetos
			if(rs.next()) {
				check = true;
				
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao buscar no banco de dados: "+e); //Mensagem de Erro
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs); //Fecha conecção
		}
		return check;
	}
}
