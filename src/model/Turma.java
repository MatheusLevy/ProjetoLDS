package model;

public class Turma {
	private int idTurma;
	private String curso;
	private String NumeroTurma;
	
	public Turma(int idTurma, String curso, String numeroTurma) {
		this.idTurma = idTurma;
		this.curso = curso;
		NumeroTurma = numeroTurma;
	}
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getNumeroTurma() {
		return NumeroTurma;
	}
	public void setNumeroTurma(String numeroTurma) {
		NumeroTurma = numeroTurma;
	}
}
