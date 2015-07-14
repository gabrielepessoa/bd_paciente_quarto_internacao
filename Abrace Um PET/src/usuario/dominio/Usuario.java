package usuario.dominio;

import adotante.dominio.PessoaFisica;

public class Usuario {

	private int id;
	private String login;
	private String senha;
	private String email;
	private PessoaFisica pessoaFisica;

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id=id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
