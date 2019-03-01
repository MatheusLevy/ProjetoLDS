package model;

public class Professor {
	private int idProfessor;
	private String nome;
	private String matricula;
	
	public Professor(int idProfessor, String nome, String matricula) {
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.matricula = matricula;
	}
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
