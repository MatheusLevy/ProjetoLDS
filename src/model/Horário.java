package model;

public class Horário {
	private int idHorario;
	private String Horario;
	private String Segunda;
	private String Terça;
	private String Quarta;
	private String Quinta;
	private String Sexta;
	private int idLaboratório;
	private int NumeLaboratório;
	
	public Horário(int idHorario, String horario, String Segunda,String Terça,String Quarta,String Quinta,String Sexta, int idLaboratorio) {
		this.idHorario = idHorario;
		this.Horario = horario;
		this.Segunda = Segunda;
		this.Terça = Terça;
		this.Quinta = Quinta;
		this.Sexta = Sexta;
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
	public String getSegunda() {
		return Segunda;
	}
	public void setSegunda(String segunda) {
		Segunda = segunda;
	}
	public String getTerça() {
		return Terça;
	}
	public void setTerça(String teça) {
		Terça = teça;
	}
	public String getQuarta() {
		return Quarta;
	}
	public void setQuarta(String quarta) {
		Quarta = quarta;
	}
	public String getQuinta() {
		return Quinta;
	}
	public void setQuinta(String quinta) {
		Quinta = quinta;
	}
	public String getSexta() {
		return Sexta;
	}
	public void setSexta(String sexta) {
		Sexta = sexta;
	}
	
}
