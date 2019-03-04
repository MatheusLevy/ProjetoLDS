package model;

public class Aula {
	private int idAula;
	private Turma turma;
	private Hor�rio horario;
	private Laboratorio laboratorio;
	private Professor professor;
	private Disciplina disciplina;
	
	public Aula(int idAula, Turma turma, Hor�rio horario,
			Laboratorio laboratorio, Professor professor, Disciplina disciplina) {
		this.idAula = idAula;
		this.turma = turma;
		this.horario = horario;
		this.laboratorio = laboratorio;
		this.professor = professor;
		this.disciplina = disciplina;
	}
	public int getIdAula() {
		return idAula;
	}
	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Hor�rio getHorario() {
		return horario;
	}
	public void setHorario(Hor�rio horario) {
		this.horario = horario;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
