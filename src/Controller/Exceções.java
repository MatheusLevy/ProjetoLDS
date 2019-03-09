package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;
/*
 * @author Matheus Levy
 * @GitHub github.com/MatheusLevy
 */

public class Exce��es {
	private static Exce��es UnicaInstancia;
	
	
	public void VerificarExce��oLaboratorio(SQLException e) {
		
		switch (e.getErrorCode()) {
			case 1062:
				JOptionPane.showMessageDialog(null,"Erro ao atualizar: J� existe um laborat�rio com esse n�mero"); //Mensagem de Erro
				break;
			case 1451:
				JOptionPane.showMessageDialog(null,"Erro ao atualizar: H� um hor�rio em uso para esse labor�torio"); //Mensagem de Erro
				break;
			default:
				JOptionPane.showMessageDialog(null,"Erro ao atualizar:"+e); //Mensagem de Erro
		}		
	}
	
	public void VerificarExce��oCoordenador(SQLException e) {
		if(e.getErrorCode() == 1062) {
			JOptionPane.showMessageDialog(null,"Erro ao atualizar: Nome de Usu�rio j� em uso"); //Mensagem de Erro
		}else {
			JOptionPane.showMessageDialog(null,"Erro ao atualizar:"+e); //Mensagem de Erro
			System.out.println(e.getErrorCode());
		}
	}
	
	public static synchronized Exce��es getInstance() {
		if(UnicaInstancia == null)
			UnicaInstancia = new Exce��es();
		return UnicaInstancia;
	}
}
