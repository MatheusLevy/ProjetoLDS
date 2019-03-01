package Controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View.TelaCoordenador;
import dao.CoordenadorDAO;
import model.Coordenador;

public class ControleCoordenador {
	
	
	public ControleCoordenador() {
		
	}
	
	public boolean autenticar(String text, String senha) {
		CoordenadorDAO dao = new CoordenadorDAO();
		
		if(dao.checklogin(text, senha)){
			new TelaCoordenador().setVisible(true);
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
}