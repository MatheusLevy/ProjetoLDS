package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;
/*
 * @author Matheus Levy
 * @GitHub github.com/MatheusLevy
 */

public class Exceções {
	private static Exceções UnicaInstancia;
	
	
	public void VerificarExceçãoLaboratorio(SQLException e) {
		
		switch (e.getErrorCode()) {
			case 1062:
				JOptionPane.showMessageDialog(null,"Erro ao atualizar: Já existe um laboratório com esse número"); //Mensagem de Erro
				break;
			case 1451:
				JOptionPane.showMessageDialog(null,"Erro ao atualizar: Há um horário em uso para esse laborátorio"); //Mensagem de Erro
				break;
			default:
				JOptionPane.showMessageDialog(null,"Erro ao atualizar:"+e); //Mensagem de Erro
		}		
	}
	
	public void VerificarExceçãoCoordenador(SQLException e) {
		if(e.getErrorCode() == 1062) {
			JOptionPane.showMessageDialog(null,"Erro ao atualizar: Nome de Usuário já em uso"); //Mensagem de Erro
		}else {
			JOptionPane.showMessageDialog(null,"Erro ao atualizar:"+e); //Mensagem de Erro
			System.out.println(e.getErrorCode());
		}
	}
	
	public static synchronized Exceções getInstance() {
		if(UnicaInstancia == null)
			UnicaInstancia = new Exceções();
		return UnicaInstancia;
	}
}
