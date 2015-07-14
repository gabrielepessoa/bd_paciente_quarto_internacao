package adotante.service;

import usuario.dominio.Usuario;

public class PessoaService {
	Usuario	usuario	= new Usuario();

	/**
	 * VALIDAR NOME DA PESSOA
	 * 
	 * @param nome
	 * @return
	 */
	public boolean validarNome(String nome) {
		boolean valido;

		if (!nome.equals("")) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	/**
	 * VALIDAR RG
	 * 
	 * @param rg
	 * @return
	 */
	public boolean validarRg(String rg) {
		boolean valido;
		int tamanhoRg = rg.length();

		if ((!rg.equals("")) && (tamanhoRg == 7)) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR EMAIL
	 * 
	 * @param email
	 * @return
	 */
	public boolean validarEmail(String email) {
		boolean valido;
		usuario.setEmail(email);

		if (!email.equals("")) {
			if ((usuario.getEmail().contains("@")) && (usuario.getEmail().contains(".com")) && (!(usuario.getEmail()).contains(" "))) {

				String nomeEmail = new String(email.substring(0, email.lastIndexOf('@')));

				String dominio = new String(email.substring(email.lastIndexOf('@') + 1, email.length()));

				if (!(nomeEmail.length() >= 1) && (!nomeEmail.contains("@")) && (dominio.contains(".com")) && (!dominio.contains("@"))
						&& (dominio.indexOf(".com") >= 1) && (dominio.lastIndexOf(".com") < dominio.length() - 1)) {
					valido = false;
				} else {
					valido = true;
				}
			} else {
				valido = false;
			}

		} else {
			valido = false;
		}
		return valido;
	}

	
	
}
