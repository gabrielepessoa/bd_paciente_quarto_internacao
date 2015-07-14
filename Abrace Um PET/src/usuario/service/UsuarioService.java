package usuario.service;

import usuario.dao.UsuarioDAO;
import usuario.dominio.Usuario;
import usuario.gui.CadastroUsuarioGUI;

public class UsuarioService {
	private UsuarioDAO usuarioDao = new UsuarioDAO();
	CadastroUsuarioGUI cadastroUsuario = new CadastroUsuarioGUI();
	Usuario usuario = new Usuario();
	
	public boolean consultarUsuarioService(String login, String senha) throws Exception {
		return usuarioDao.consultarLogin(login, senha);
	}

	public boolean adicionarUsuarioService(Usuario usuario) throws Exception {
		int id;
		boolean valido = false;
		id = usuarioDao.adicionarUsuario(usuario);
		if (id != -1){
			valido = true;
		}
		return valido;
	}
	/**
	 * VALIDAR SE LOGIN JA EXISTE NO BANCO DE DADOS
	 * @param login
	 * @return
	 * @throws Exception 
	 */
	public boolean validarCadastroUsuario(String login) throws Exception {
		boolean valido;
		usuario.setLogin(login);

		if (usuarioDao.consultarUsuario(login)) {
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}
	
	/**
	 * VALIDAR CAMPO LOGIN (MINIMO 3 CARACTERES)
	 * 
	 * @param login
	 * @return
	 */
	public boolean validarLogin(String login) {
		boolean valido;
		int tamanhoLogin = login.length();

		if (tamanhoLogin > 3) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	
	/**
	 * VALIDAR CAMPO SENHA (MINIMO 6 CARACTERES E PELO MENOS UM CARACTER
	 * ESPECIAL)
	 * 
	 * @param senha
	 * @return
	 */
	public boolean validarSenha(String senha) {
		boolean valido;
		int tamanhoSenha = senha.length();
		usuario.setSenha(senha);

		if (!senha.equals( "")) {
			if (tamanhoSenha < 6
					&& (!(senha.contains("!") || senha.contains("@")
							|| senha.contains("#") || senha.contains("%")
							|| senha.contains("&") || senha.contains("$")))) {
				valido = false;
			} else {
				valido = true;
			}

		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR SE SENHA E CONFIRMAR SENHA CONFEREM
	 * 
	 * @param senha
	 * @param confirmacaoSenha
	 * @return
	 */
	public boolean validarConfirmacaoSenha(String senha, String confirmacaoSenha) {
		boolean valido;

		cadastroUsuario.setConfirmarSenha(confirmacaoSenha);
		usuario.setSenha(senha);

		if ((cadastroUsuario.getConfirmarSenha().equals(usuario.getSenha()))) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

}
