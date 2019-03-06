package Controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import View.Horario;
import dao.Hor�rioDAO;
import model.Hor�rio;
import model.Laboratorio;
/*
 * @author Matheus Levy
 * @GitHub github.com/MatheusLevy
 */

public class ControleHorario {

	public void AbrirHorarios(String IdLaboratorio, String Nome, String Numero) {
		Laboratorio lab = new Laboratorio(Integer.parseInt(IdLaboratorio),Nome, Integer.parseInt(Numero));
		Horario frame = new Horario(lab);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void readJtableHorario(JTable JtableHorario,int IdLaboratorio) {
		DefaultTableModel modelo = (DefaultTableModel) JtableHorario.getModel();
		modelo.setNumRows(0);
		Hor�rioDAO  hdao = new Hor�rioDAO();
		
		for(Hor�rio h : hdao.readHorario(IdLaboratorio)) {
			modelo.addRow(new Object[] {
					h.getIdHorario(),
					h.getHorario(),
					h.getSegunda(),
					h.getTer�a(),
					h.getQuarta(),
					h.getQuinta(),
					h.getSexta()
			});
		}
	}
	
	public void atualizar(int idHor�rio, String Hor�rio, String Segunda, String Ter�a, String Quarta, String Quinta, String Sexta
			, int numeroLab) {
		Hor�rioDAO hdao = new Hor�rioDAO();
		Hor�rio horario = new Hor�rio();
		Laboratorio lab = new Laboratorio();
		lab.setNumero(numeroLab);
		horario.setIdHorario(idHor�rio);
		horario.setHorario(Hor�rio);
		horario.setSegunda(Segunda);
		horario.setTer�a(Ter�a);
		horario.setQuarta(Quarta);
		horario.setQuinta(Quinta);
		horario.setSexta(Sexta);
		hdao.Atualizar(horario,lab);
	}
	
	public void criarhorario(String horarios, String segunda, String ter�a, String quarta, String quinta, String sexta, int idLaborat�rio) {
		
			Hor�rioDAO hdao = new Hor�rioDAO();
			Hor�rio horario = new Hor�rio();
			Laboratorio lab = new Laboratorio();
			horario.setHorario(horarios);
			horario.setSegunda(segunda);
			horario.setTer�a(ter�a);
			horario.setQuarta(quarta);
			horario.setQuinta(quinta);
			horario.setSexta(sexta);
			lab.setIdLaboratorio(idLaborat�rio);
			hdao.Inserir(horario, lab);
	}
	
	public void DeletarHorario(int IdHorario) {
		Hor�rioDAO hdao = new Hor�rioDAO();
		Hor�rio horario = new Hor�rio();
		horario.setIdHorario(IdHorario);
		hdao.Deletar(horario);
	}
}
