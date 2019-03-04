package model;

public class Horário {
	private int idHorario;
	private String Horario;
	private String Disciplina;
	private int idLaboratório;
	private int NumeLaboratório;
	
	public Horário(int idHorario, String horario, String Disciplina, int idLaboratorio) {
		this.idHorario = idHorario;
		Horario = horario;
	}
	public Horário() {
		
	}
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public String getHorario() {
		return Horario;
	}
	public void setHorario(String horario) {
		Horario = horario;
	}
	public String getDisciplina() {
		return Disciplina;
	}
	public void setDisciplina(String disciplina) {
		Disciplina = disciplina;
	}
	public int getIdLaboratório() {
		return idLaboratório;
	}
	public void setIdLaboratório(int idLaboratório) {
		this.idLaboratório = idLaboratório;
	}
	public int getNumeLaboratório() {
		return NumeLaboratório;
	}
	public void setNumeLaboratório(int numeLaboratório) {
		NumeLaboratório = numeLaboratório;
	}
	
}
