package Controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.LaboratórioDAO;
import model.Laboratorio;


public class ControleLaboratório {
	
	

	public void readJtableLaboratório(JTable JTableLaboratório){
		DefaultTableModel modelo = (DefaultTableModel) JTableLaboratório.getModel();
		modelo.setNumRows(0);
		LaboratórioDAO  ldao = new LaboratórioDAO();
		
		for(Laboratorio l : ldao.readLaboratórios()) {
			modelo.addRow(new Object[] {
					l.getIdLaboratorio(),
					l.getNumero(),
					l.getNome()
			});
		}
	}
	
	public void inserirLaboratório(int Número, String Nome) {
		LaboratórioDAO ldao = new LaboratórioDAO();
		Laboratorio laboratorio = new Laboratorio();
		laboratorio.setNumero(Número);
		laboratorio.setNome(Nome);
		ldao.create(laboratorio);
	}
	
	
	
	
	
	
}
