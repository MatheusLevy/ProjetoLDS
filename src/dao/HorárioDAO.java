package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
			stmt = con.prepareStatement("SELECT horário.dia, horário.Horário,horário.disciplina,laboratório.NúmeroLaboratório\r\n" + 
					"FROM horário JOIN laboratório\r\n" + 
					"ON laboratório.idLaboratório = horário.idLaboratório\r\n" + 
					"WHERE laboratório.idLaboratório = ?;");
			stmt.setInt(1, idLaboratório);
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Horário horario = new Horário();
				horario.setHorario(rs.getString("Horário"));
				horario.setDisciplina(rs.getString("disciplina"));
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
	
}
	