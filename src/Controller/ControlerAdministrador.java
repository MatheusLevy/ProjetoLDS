package Controller;

import javax.swing.JOptionPane;

import View.TelaAdministrador;
import dao.AdministradorDAO;

public class ControlerAdministrador {
	
	public boolean autenticar(String text, String senha) {
		AdministradorDAO dao = new AdministradorDAO();
		
		if(dao.checklogin(text, senha)){
			TelaAdministrador telaAdmin = new TelaAdministrador();
			telaAdmin.setExtendedState(telaAdmin.MAXIMIZED_BOTH);
			telaAdmin.setVisible(true);
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Login Incorreto");
			return false;
		}
		
	}
}
