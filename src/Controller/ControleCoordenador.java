package Controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View.TelaCoordenador;
import View.TelaLoginCoordenador;
import dao.CoordenadorDAO;
import model.Coordenador;

public class ControleCoordenador {
	
	
	public ControleCoordenador() {
		
	}
	
	public boolean autenticar(String text, String senha) {
		CoordenadorDAO dao = new CoordenadorDAO();
		
		if(dao.checklogin(text, senha)){
			 TelaCoordenador telaCoordenador = new TelaCoordenador();
			 telaCoordenador.setVisible(true);
			 telaCoordenador.setExtendedState(telaCoordenador.MAXIMIZED_BOTH);
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Login Incorreto");
			return false;
		}
		
	}
	
	public void readJtableCoordenador(JTable JTableCoordenadores){
		DefaultTableModel modelo = (DefaultTableModel) JTableCoordenadores.getModel();
		modelo.setNumRows(0);
		CoordenadorDAO  cdao = new CoordenadorDAO();
		
		for(Coordenador c : cdao.read()) {
			modelo.addRow(new Object[] {
					c.getIdCoordenador(),
					c.getUsuario(),
					c.getSenha()
			});
		}
	}
	
	public void inserirCoordenador(String Usuário, String Senha) {
		CoordenadorDAO cdao = new CoordenadorDAO();
		Coordenador coordenador = new Coordenador();
		coordenador.setUsuario(Usuário);
		coordenador.setSenha(Senha);
		cdao.create(coordenador);
	}
	
	public void atualizarCoordenador(int IdCoordenador, String Usuário, String Senha) {
		CoordenadorDAO cdao = new CoordenadorDAO();
		Coordenador coordenador = new Coordenador(IdCoordenador,Usuário,Senha);
		cdao.Atualizar(coordenador);
		
	}
	
	public void deletarCoordenador(int idCoordenador) {
		CoordenadorDAO cdao = new CoordenadorDAO();
		Coordenador coordenador = new Coordenador();
		coordenador.setIdCoordenador(idCoordenador);
		cdao.Deletar(coordenador);
	}
	
	public void Logout() {
		TelaLoginCoordenador telaLogin = new TelaLoginCoordenador();
		telaLogin.setLocationRelativeTo(null);
		telaLogin.setVisible(true);
	}
}
