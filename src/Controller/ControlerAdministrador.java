package Controller;

import javax.swing.JOptionPane;

import View.TelaAdministrador;
import View.TelaLoginCoordenador;
import dao.AdministradorDAO;
/*
 * @author Matheus Levy
 * @GitHub github.com/MatheusLevy
 */

public class ControlerAdministrador {
	
	public static ControlerAdministrador UnicaInstancia;
	
	@SuppressWarnings("static-access")
	public boolean autenticar(String text, String senha) {
		AdministradorDAO dao = AdministradorDAO.getInstance();
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
	
	public void Logout() {
		TelaLoginCoordenador TelaLogin = new TelaLoginCoordenador();
		TelaLogin.setLocationRelativeTo(null);
		TelaLogin.setVisible(true);
	}
	
	public static synchronized ControlerAdministrador getInstance() {
		if(UnicaInstancia == null) {
			UnicaInstancia = new ControlerAdministrador();
		}
		return UnicaInstancia;
	}
}
