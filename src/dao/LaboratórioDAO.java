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
}
