package Controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import View.Horario;
import dao.HorárioDAO;
import model.Horário;
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
		HorárioDAO  hdao = new HorárioDAO();
		
		for(Horário h : hdao.readHorario(IdLaboratorio)) {
			modelo.addRow(new Object[] {
					h.getIdHorario(),
					h.getHorario(),
					h.getSegunda(),
					h.getTerça(),
					h.getQuarta(),
					h.getQuinta(),
					h.getSexta()
			});
		}
	}
	
	public void atualizar(int idHorário, String Horário, String Segunda, String Terça, String Quarta, String Quinta, String Sexta
			, int numeroLab) {
		HorárioDAO hdao = new HorárioDAO();
		Horário horario = new Horário();
		Laboratorio lab = new Laboratorio();
		lab.setNumero(numeroLab);
		horario.setIdHorario(idHorário);
		horario.setHorario(Horário);
		horario.setSegunda(Segunda);
		horario.setTerça(Terça);
		horario.setQuarta(Quarta);
		horario.setQuinta(Quinta);
		horario.setSexta(Sexta);
		hdao.Atualizar(horario,lab);
	}
	
	public void criarhorario(String horarios, String segunda, String terça, String quarta, String quinta, String sexta, int idLaboratório) {
		
			HorárioDAO hdao = new HorárioDAO();
			Horário horario = new Horário();
			Laboratorio lab = new Laboratorio();
			horario.setHorario(horarios);
			horario.setSegunda(segunda);
			horario.setTerça(terça);
			horario.setQuarta(quarta);
			horario.setQuinta(quinta);
			horario.setSexta(sexta);
			lab.setIdLaboratorio(idLaboratório);
			hdao.Inserir(horario, lab);
	}
	
	public void DeletarHorario(int IdHorario) {
		HorárioDAO hdao = new HorárioDAO();
		Horário horario = new Horário();
		horario.setIdHorario(IdHorario);
		hdao.Deletar(horario);
	}
}
