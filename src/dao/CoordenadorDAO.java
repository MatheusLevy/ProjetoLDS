package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.Exce��es;
import connection.ConnectionFactory;
import model.Coordenador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * @author Matheus Levy
 */
public class CoordenadorDAO {
	  
	
	public void create(Coordenador c) {
		//Cria a conec��o e o statement
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			//preapara o statement
			stmt = con.prepareStatement("INSERT INTO coordenador(Usu�rioCoordenador, SenhaCoordenador) values(?,?)");
			stmt.setString(1, c.getUsuario());
			stmt.setString(2, c.getSenha());
			//Executa o statement
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Salvo com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			Exce��es lidar = new Exce��es();
			lidar.VerificarExce��oCoordenador(e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	
	public boolean checklogin(String usuario, String senha){
		//Cria a conec��o e o statement
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			//Cria e prepara o statement
			stmt = con.prepareStatement("SELECT * FROM coordenador WHERE Usu�rioCoordenador = ? and SenhaCoordenador = ? ");
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
			ConnectionFactory.closeConnection(con, stmt, rs); //Fecha conec��o
		}
		return check;
	}
	
	public List<Coordenador> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Coordenador> Listacoordenadores = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM coordenador");
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Coordenador coordenador = new Coordenador();
				coordenador.setIdCoordenador(rs.getInt("idCoordenador"));
				coordenador.setUsuario(rs.getString("Usu�rioCoordenador"));
				coordenador.setSenha(rs.getString("SenhaCoordenador"));
				Listacoordenadores.add(coordenador);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao buscar no banco de dados: "+e); //Mensagem de Erro
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs); //Fecha conec��o
		}
		return Listacoordenadores;
	}


	public void Atualizar(Coordenador coordenador) {
		//Cria a conec��o e o statement
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			//preapara o statement
			stmt = con.prepareStatement("UPDATE coordenador SET Usu�rioCoordenador = ?, SenhaCoordenador = ? WHERE idCoordenador = ?;");
			//Executa o statement
			stmt.setString(1, coordenador.getUsuario());
			stmt.setString(2, coordenador.getSenha());
			stmt.setInt(3, coordenador.getIdCoordenador());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Atualziado com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			new Exce��es().VerificarExce��oCoordenador(e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public void Deletar(Coordenador coordenador) {
		//Cria a conec��o e o statement
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
	
		try {
			//preapara o statement
			stmt = con.prepareStatement("DELETE FROM coordenador WHERE idCoordenador = ?");
			//Executa o statement
			stmt.setInt(1, coordenador.getIdCoordenador());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Deletado com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			new Exce��es().VerificarExce��oCoordenador(e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Coordenador> BuscarCoordenador(Coordenador coorde){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Coordenador> ListaCoordenadores = new ArrayList<>();
		
		try {
			//preapara o statement
			stmt = con.prepareStatement("SELECT * FROM coordenador WHERE  Usu�rioCoordenador= ?");
			//Executa o statement
			stmt.setString(1, coorde.getUsuario());
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Coordenador coordenador = new Coordenador();
				coordenador.setIdCoordenador(rs.getInt("idCoordenador"));
				coordenador.setUsuario(rs.getString("Usu�rioCoordenador"));
				coordenador.setSenha(rs.getString("SenhaCoordenador"));
				ListaCoordenadores.add(coordenador);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro:" + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return ListaCoordenadores;
	}
	
}
