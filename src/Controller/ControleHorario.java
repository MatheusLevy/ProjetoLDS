package Controller;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View.Horario;
import dao.CoordenadorDAO;
import dao.Hor�rioDAO;
import model.Coordenador;
import model.Hor�rio;
import model.Laboratorio;
public class ControleHorario {

	public void AbrirHorarios(String IdLaboratorio, String Nome, String Numero) {
		Laboratorio lab = new Laboratorio(Integer.parseInt(IdLaboratorio),Nome, Integer.parseInt(Numero));
		Horario frame = Horario.getInstance(lab);
		frame.setVisible(true);
	}
	
	public void readJtableHorario(JTable JtableHorario,int IdLaboratorio) {
		DefaultTableModel modelo = (DefaultTableModel) JtableHorario.getModel();
		modelo.setNumRows(0);
		Hor�rioDAO  hdao = new Hor�rioDAO();
		
		for(Hor�rio h : hdao.readHorario(IdLaboratorio)) {
			modelo.addRow(new Object[] {
					h.getHorario(),
					h.getDisciplina()
			});
		}
	}
}
