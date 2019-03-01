package model;

public class Administrador {
	private int idAdministrador;
	private String Usuario;
	private String senha;
	
	public Administrador(int idAdministrador, String usuario, String senha) {
		this.idAdministrador = idAdministrador;
		Usuario = usuario;
		this.senha = senha;
	}
	
	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
