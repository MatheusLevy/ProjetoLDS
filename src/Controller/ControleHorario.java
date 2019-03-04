package Controller;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View.Horario;
import dao.CoordenadorDAO;
import dao.HorárioDAO;
import model.Coordenador;
import model.Horário;
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
		HorárioDAO  hdao = new HorárioDAO();
		
		for(Horário h : hdao.readHorario(IdLaboratorio)) {
			modelo.addRow(new Object[] {
					h.getHorario(),
					h.getDisciplina()
			});
		}
	}
}
