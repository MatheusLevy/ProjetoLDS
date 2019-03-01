package model;

public class Horario {
	private int idHorario;
	private String Horario;
	
	public Horario(int idHorario, String horario) {
		this.idHorario = idHorario;
		Horario = horario;
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
	
}
