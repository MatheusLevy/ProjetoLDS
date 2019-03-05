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
	
	public void AtualizarLaborat�rio(int IdLaborat�rio, int N�mero, String Nome) {
		Laborat�rioDAO ldao = new Laborat�rioDAO();
		Laboratorio laboratorio = new Laboratorio(IdLaborat�rio, Nome, N�mero);
		ldao.Atualiza(laboratorio);
	}
	
	public void DeletarLaborat�rio(int IdLaborat�rio) {
		Laborat�rioDAO ldao = new Laborat�rioDAO();
		Laboratorio laboratorio = new Laboratorio();
		laboratorio.setIdLaboratorio(IdLaborat�rio);
		ldao.Deletar(laboratorio);
	}
	
	public void BuscarLaborat�rio(int numeroLab, JTable JTableLaborat�rio) {
		Laborat�rioDAO ldao = new Laborat�rioDAO();
		Laboratorio laboratorio = new Laboratorio();
		laboratorio.setNumero(numeroLab);
		DefaultTableModel modelo = (DefaultTableModel) JTableLaborat�rio.getModel();
		modelo.setNumRows(0);
		
		for(Laboratorio l : ldao.BuscarLaboratorio(laboratorio)) {
			modelo.addRow(new Object[] {
					l.getIdLaboratorio(),
					l.getNumero(),
					l.getNome()
			});
		}
	}
	
	
	
	
	
	
}
