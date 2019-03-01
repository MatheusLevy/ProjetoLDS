package model;

public class Coordenador {
	private int idCoordenador;
	private String usuario;
	private String senha;
	
	public Coordenador(int idCoordenador, String usuario, String senha) {
		this.idCoordenador = idCoordenador;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Coordenador() {
	}
	public int getIdCoordenador() {
		return idCoordenador;
	}
	public void setIdCoordenador(int idCoordenador) {
		this.idCoordenador = idCoordenador;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
