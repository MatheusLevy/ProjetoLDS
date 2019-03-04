package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
			stmt = con.prepareStatement("SELECT hor�rio.dia, hor�rio.Hor�rio,hor�rio.disciplina,laborat�rio.N�meroLaborat�rio\r\n" + 
					"FROM hor�rio JOIN laborat�rio\r\n" + 
					"ON laborat�rio.idLaborat�rio = hor�rio.idLaborat�rio\r\n" + 
					"WHERE laborat�rio.idLaborat�rio = ?;");
			stmt.setInt(1, idLaborat�rio);
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Hor�rio horario = new Hor�rio();
				horario.setHorario(rs.getString("Hor�rio"));
				horario.setDisciplina(rs.getString("disciplina"));
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
	
}
	