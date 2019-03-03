package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Exceções {

	public void VerificarExceçãoLaboratorio(SQLException e) {
		if(e.getErrorCode() == 1062) {
			JOptionPane.showMessageDialog(null,"Erro ao atualizar: Já existe um laboratório com esse número"); //Mensagem de Erro
		}else {
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
}
