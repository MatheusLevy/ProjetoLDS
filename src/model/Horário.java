package model;

public class Hor�rio {
	private int idHorario;
	private String Horario;
	private String Disciplina;
	private int idLaborat�rio;
	private int NumeLaborat�rio;
	
	public Hor�rio(int idHorario, String horario, String Disciplina, int idLaboratorio) {
		this.idHorario = idHorario;
		Horario = horario;
	}
	public Hor�rio() {
		
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
	public int getIdLaborat�rio() {
		return idLaborat�rio;
	}
	public void setIdLaborat�rio(int idLaborat�rio) {
		this.idLaborat�rio = idLaborat�rio;
	}
	public int getNumeLaborat�rio() {
		return NumeLaborat�rio;
	}
	public void setNumeLaborat�rio(int numeLaborat�rio) {
		NumeLaborat�rio = numeLaborat�rio;
	}
	
}
