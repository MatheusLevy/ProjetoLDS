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
import model.Horário;
import model.Laboratorio;

public class HorárioDAO {
		
	public List<Horário> readHorario(int idLaboratório){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Horário> ListaHorarios = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT horário.idHorário,horário.Horário,horário.Segunda, horário.Terça, horário.Quarta, horário.Quinta, horário. Sexta\r\n" + 
					", laboratório.NúmeroLaboratório\r\n" + 
					"FROM horário JOIN laboratório\r\n" + 
					"ON laboratório.idLaboratório = horário.idLaboratório\r\n" + 
					"WHERE laboratório.idLaboratório = ?;");
			stmt.setInt(1, idLaboratório);
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Horário horario = new Horário();
				horario.setIdHorario(rs.getInt("idHorário"));
				horario.setHorario(rs.getString("Horário"));
				horario.setSegunda(rs.getString("Segunda"));
				horario.setTerça(rs.getString("Terça"));
				horario.setQuarta(rs.getString("Quarta"));
				horario.setQuinta(rs.getString("Quinta"));
				horario.setSexta(rs.getString("Sexta"));;
				horario.setNumeLaboratório(rs.getInt("NúmeroLaboratório"));
			    ListaHorarios.add(horario);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao buscar no banco de dados: "+e); //Mensagem de Erro
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs); //Fecha conecção
		}
		return ListaHorarios;
	}
	
	public void Atualizar(Horário horario,Laboratorio lab) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			//preapara o statement
			stmt = con.prepareStatement("UPDATE horário\r\n" + 
					"JOIN laboratório\r\n" + 
					"SET horário.Segunda = ?,\r\n" + 
					  "horário.Terça = ?,\r\n"
					+ "horário.Quarta = ?,"
					+ "horário.Quinta = ?,"
					+ "horário.Sexta = ?,"
					+ "horário.Horário = ?" + 
					"WHERE horário.idHorário = ? AND laboratório.NúmeroLaboratório = ?;\r\n" + 
					"");
			//Executa o statement
			stmt.setString(1, horario.getSegunda());
			stmt.setString(2, horario.getTerça());
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
	
	public void Inserir(Horário horario, Laboratorio lab) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			//preapara o statement
		    stmt = con.prepareStatement("INSERT INTO horário(Horário,Segunda,Terça,Quarta,Quinta,Sexta,idLaboratório) values (?,?,?,?,?,?,?)");
			stmt.setString(1, horario.getHorario());
			stmt.setString(2, horario.getSegunda());
			stmt.setString(3, horario.getTerça());
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
	