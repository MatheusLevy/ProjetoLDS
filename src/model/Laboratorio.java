package model;

public class Laboratorio {
	private int idLaboratorio;
	private String nome;
	private int numero;
	
	public Laboratorio(int idLaboratorio, String nome, int numero) {
		this.idLaboratorio = idLaboratorio;
		this.nome = nome;
		this.setNumero(numero);
	}
	
	public Laboratorio() {
		
	}
	
	public int getIdLaboratorio() {
		return idLaboratorio;
	}
	public void setIdLaboratorio(int idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
