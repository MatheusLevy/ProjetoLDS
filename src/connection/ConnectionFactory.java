package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
	
	//Criando os Dados a serem passados para a conecção
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/mydb";
	private static final String USER = "root";
	private static final String PASS = "";
	
	//método que cria a conecção 
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conexão com o Banco de Dados:", e);
		}
	}
	
	public static void closeConnection(Connection con) {
		//Se a conecção estiver aberta ela é fechada
			try {
					if(con!=null) {
						con.close();
					}
				}catch(SQLException ex) {
					throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados:", ex);
			}
			
			}
	
		//Sobrecarga do metodo CloseConnection
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		//Chama o metodo CloseConnection() e fecha a conecção
			closeConnection(con);
			try {
					if(stmt!=null) {
						stmt.close();
					}
				}catch(SQLException ex) {
					throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados:", ex);
			}
			
			}
	
		//Sobrecarga do metodo CloseConnection
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		//Chama o metodo CloseConnection() e fecha a conecção e o statatement
			closeConnection(con, stmt);
			try {
					if(rs!=null) {
						rs.close();
					}
				}catch(SQLException ex) {
					throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados:", ex);
			}
			
			}
	
	
		}
	
	
