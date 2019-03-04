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
import model.Hor�rio;
import model.Laboratorio;

public class Hor�rioDAO {
		
	public List<Hor�rio> readHorario(int idLaborat�rio){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Hor�rio> ListaHorarios = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT hor�rio.idHor�rio,hor�rio.Hor�rio,hor�rio.Segunda, hor�rio.Ter�a, hor�rio.Quarta, hor�rio.Quinta, hor�rio. Sexta\r\n" + 
					", laborat�rio.N�meroLaborat�rio\r\n" + 
					"FROM hor�rio JOIN laborat�rio\r\n" + 
					"ON laborat�rio.idLaborat�rio = hor�rio.idLaborat�rio\r\n" + 
					"WHERE laborat�rio.idLaborat�rio = ?;");
			stmt.setInt(1, idLaborat�rio);
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Hor�rio horario = new Hor�rio();
				horario.setIdHorario(rs.getInt("idHor�rio"));
				horario.setHorario(rs.getString("Hor�rio"));
				horario.setSegunda(rs.getString("Segunda"));
				horario.setTer�a(rs.getString("Ter�a"));
				horario.setQuarta(rs.getString("Quarta"));
				horario.setQuinta(rs.getString("Quinta"));
				horario.setSexta(rs.getString("Sexta"));;
				horario.setNumeLaborat�rio(rs.getInt("N�meroLaborat�rio"));
			    ListaHorarios.add(horario);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao buscar no banco de dados: "+e); //Mensagem de Erro
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs); //Fecha conec��o
		}
		return ListaHorarios;
	}
	
	public void Atualizar(Hor�rio horario,Laboratorio lab) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			//preapara o statement
			stmt = con.prepareStatement("UPDATE hor�rio\r\n" + 
					"JOIN laborat�rio\r\n" + 
					"SET hor�rio.Segunda = ?,\r\n" + 
					  "hor�rio.Ter�a = ?,\r\n"
					+ "hor�rio.Quarta = ?,"
					+ "hor�rio.Quinta = ?,"
					+ "hor�rio.Sexta = ?,"
					+ "hor�rio.Hor�rio = ?" + 
					"WHERE hor�rio.idHor�rio = ? AND laborat�rio.N�meroLaborat�rio = ?;\r\n" + 
					"");
			//Executa o statement
			stmt.setString(1, horario.getSegunda());
			stmt.setString(2, horario.getTer�a());
			stmt.setString(3, horario.getQuarta());
			stmt.setString(4, horario.getQuinta());
			stmt.setString(5, horario.getSexta());
			stmt.setString(6, horario.getHorario());
			stmt.setInt(7, horario.getIdHorario());
			stmt.setInt(8, lab.getNumero());
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null,"Atualizado com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}		
		
	}
	
	public void Inserir(Hor�rio horario, Laboratorio lab) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			//preapara o statement
		    stmt = con.prepareStatement("INSERT INTO hor�rio(Hor�rio,Segunda,Ter�a,Quarta,Quinta,Sexta,idLaborat�rio) values (?,?,?,?,?,?,?)");
			stmt.setString(1, horario.getHorario());
			stmt.setString(2, horario.getSegunda());
			stmt.setString(3, horario.getTer�a());
			stmt.setString(4, horario.getQuarta());
			stmt.setString(5, horario.getQuinta());
			stmt.setString(6, horario.getSexta());
			stmt.setInt(7, lab.getIdLaboratorio());
		    //Executa o statement
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null,"Inserido com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}		
		
	}
	
}
	