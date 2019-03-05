package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.Exceções;
import connection.ConnectionFactory;
import model.Coordenador;
import model.Laboratorio;

public class LaboratórioDAO {

	
	public List<Laboratorio> readLaboratórios(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Laboratorio> ListaLaboratorios = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM laboratório");
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Laboratorio laboratorio = new Laboratorio();
				laboratorio.setIdLaboratorio(rs.getInt("idLaboratório"));
				laboratorio.setNumero(rs.getInt("NúmeroLaboratório"));
				laboratorio.setNome(rs.getString("NomeLaboratório"));
				ListaLaboratorios.add(laboratorio);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao buscar no banco de dados: "+e); //Mensagem de Erro
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs); //Fecha conecção
		}
		return ListaLaboratorios;
	}
	
	public void create(Laboratorio l) {
		//Cria a conecção e o statement
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			//preapara o statement
			stmt = con.prepareStatement("INSERT INTO laboratório(NúmeroLaboratório, NomeLaboratório) values(?,?)");
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
			stmt = con.prepareStatement("UPDATE laboratório SET NúmeroLaboratório = ?, NomeLaboratório  = ? WHERE idLaboratório = ?;");
			//Executa o statement
			stmt.setInt(1, laboratorio.getNumero());
			stmt.setString(2, laboratorio.getNome());
			stmt.setInt(3, laboratorio.getIdLaboratorio());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Atualizado com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			new Exceções().VerificarExceçãoLaboratorio(e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}		
		
	}
	
	public void Deletar(Laboratorio laboratorio) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			//preapara o statement
			stmt = con.prepareStatement("DELETE FROM laboratório WHERE idLaboratório = ?");
			//Executa o statement
			stmt.setInt(1, laboratorio.getIdLaboratorio());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Deletado com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			new Exceções().VerificarExceçãoLaboratorio(e);
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
			stmt = con.prepareStatement("SELECT * FROM laboratório WHERE  NúmeroLaboratório= ?");
			//Executa o statement
			stmt.setInt(1, lab.getNumero());
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Laboratorio laboratorio = new Laboratorio();
				laboratorio.setIdLaboratorio(rs.getInt("idLaboratório"));
				laboratorio.setNumero(rs.getInt("NúmeroLaboratório"));
				laboratorio.setNome(rs.getString("NomeLaboratório"));
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
