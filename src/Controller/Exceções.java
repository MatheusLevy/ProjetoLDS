package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Exce��es {

	public void VerificarExce��oLaboratorio(SQLException e) {
		if(e.getErrorCode() == 1062) {
			JOptionPane.showMessageDialog(null,"Erro ao atualizar: J� existe um laborat�rio com esse n�mero"); //Mensagem de Erro
		}else {
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
}
