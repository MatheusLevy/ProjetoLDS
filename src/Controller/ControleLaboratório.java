package Controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Laborat�rioDAO;
import model.Laboratorio;


public class ControleLaborat�rio {
	
	

	public void readJtableLaborat�rio(JTable JTableLaborat�rio){
		DefaultTableModel modelo = (DefaultTableModel) JTableLaborat�rio.getModel();
		modelo.setNumRows(0);
		Laborat�rioDAO  ldao = new Laborat�rioDAO();
		
		for(Laboratorio l : ldao.readLaborat�rios()) {
			modelo.addRow(new Object[] {
					l.getIdLaboratorio(),
					l.getNumero(),
					l.getNome()
			});
		}
	}
	
	public void inserirLaborat�rio(int N�mero, String Nome) {
		Laborat�rioDAO ldao = new Laborat�rioDAO();
		Laboratorio laboratorio = new Laboratorio();
		laboratorio.setNumero(N�mero);
		laboratorio.setNome(Nome);
		ldao.create(laboratorio);
	}
	
	
	
	
	
	
}
