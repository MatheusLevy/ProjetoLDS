package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.Exce��es;
import connection.ConnectionFactory;
import model.Coordenador;
import model.Laboratorio;

public class Laborat�rioDAO {

	
	public List<Laboratorio> readLaborat�rios(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Laboratorio> ListaLaboratorios = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM laborat�rio");
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Laboratorio laboratorio = new Laboratorio();
				laboratorio.setIdLaboratorio(rs.getInt("idLaborat�rio"));
				laboratorio.setNumero(rs.getInt("N�meroLaborat�rio"));
				laboratorio.setNome(rs.getString("NomeLaborat�rio"));
				ListaLaboratorios.add(laboratorio);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao buscar no banco de dados: "+e); //Mensagem de Erro
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs); //Fecha conec��o
		}
		return ListaLaboratorios;
	}
	
	public void create(Laboratorio l) {
		//Cria a conec��o e o statement
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			//preapara o statement
			stmt = con.prepareStatement("INSERT INTO laborat�rio(N�meroLaborat�rio, NomeLaborat�rio) values(?,?)");
			stmt.setInt(1, l.getNumero());
			stmt.setString(2, l.getNome());
			//Executa o statement
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Salvo com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao salvar: "+e); //Mensagem de Erro
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}		
	}
	
	public void Atualiza(Laboratorio laboratorio) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			//preapara o statement
			stmt = con.prepareStatement("UPDATE laborat�rio SET N�meroLaborat�rio = ?, NomeLaborat�rio  = ? WHERE idLaborat�rio = ?;");
			//Executa o statement
			stmt.setInt(1, laboratorio.getNumero());
			stmt.setString(2, laboratorio.getNome());
			stmt.setInt(3, laboratorio.getIdLaboratorio());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Atualizado com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			new Exce��es().VerificarExce��oLaboratorio(e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}		
		
	}
	
	public void Deletar(Laboratorio laboratorio) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			//preapara o statement
			stmt = con.prepareStatement("DELETE FROM laborat�rio WHERE idLaborat�rio = ?");
			//Executa o statement
			stmt.setInt(1, laboratorio.getIdLaboratorio());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Deletado com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			new Exce��es().VerificarExce��oLaboratorio(e);
			System.out.println(e.getErrorCode());
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}		
	}
	
	public List<Laboratorio> BuscarLaboratorio(Laboratorio lab){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Laboratorio> ListaLaboratorios = new ArrayList<>();
		
		try {
			//preapara o statement
			stmt = con.prepareStatement("SELECT * FROM laborat�rio WHERE  N�meroLaborat�rio= ?");
			//Executa o statement
			stmt.setInt(1, lab.getNumero());
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Laboratorio laboratorio = new Laboratorio();
				laboratorio.setIdLaboratorio(rs.getInt("idLaborat�rio"));
				laboratorio.setNumero(rs.getInt("N�meroLaborat�rio"));
				laboratorio.setNome(rs.getString("NomeLaborat�rio"));
				ListaLaboratorios.add(laboratorio);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro: " +e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return ListaLaboratorios;
	}
	
}
