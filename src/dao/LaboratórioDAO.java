package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
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
}
