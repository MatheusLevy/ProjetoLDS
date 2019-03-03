package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Coordenador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * @author Matheus Levy
 */
public class CoordenadorDAO {
	  
	
	public void create(Coordenador c) {
		//Cria a conecção e o statement
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			//preapara o statement
			stmt = con.prepareStatement("INSERT INTO coordenador(UsuárioCoordenador, SenhaCoordenador) values(?,?)");
			stmt.setString(1, c.getUsuario());
			stmt.setString(2, c.getSenha());
			//Executa o statement
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Salvo com sucesso"); // Mensagem de Sucesso
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao salvar: "+e); //Mensagem de Erro
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	
	public boolean checklogin(String usuario, String senha){
		//Cria a conecção e o statement
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			//Cria e prepara o statement
			stmt = con.prepareStatement("SELECT * FROM coordenador WHERE UsuárioCoordenador = ? and SenhaCoordenador = ? ");
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
				coordenador.setUsuario(rs.getString("UsuárioCoordenador"));
				coordenador.setSenha(rs.getString("SenhaCoordenador"));
				Listacoordenadores.add(coordenador);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao buscar no banco de dados: "+e); //Mensagem de Erro
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs); //Fecha conecção
		}
		return Listacoordenadores;
	}
	
	
	
}
