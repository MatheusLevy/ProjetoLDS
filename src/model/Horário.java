package model;

public class Hor�rio {
	private int idHorario;
	private String Horario;
	private String Segunda;
	private String Ter�a;
	private String Quarta;
	private String Quinta;
	private String Sexta;
	private int idLaborat�rio;
	private int NumeLaborat�rio;
	
	public Hor�rio(int idHorario, String horario, String Segunda,String Ter�a,String Quarta,String Quinta,String Sexta, int idLaboratorio) {
		this.idHorario = idHorario;
		this.Horario = horario;
		this.Segunda = Segunda;
		this.Ter�a = Ter�a;
		this.Quinta = Quinta;
		this.Sexta = Sexta;
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
	public String getSegunda() {
		return Segunda;
	}
	public void setSegunda(String segunda) {
		Segunda = segunda;
	}
	public String getTer�a() {
		return Ter�a;
	}
	public void setTer�a(String te�a) {
		Ter�a = te�a;
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
