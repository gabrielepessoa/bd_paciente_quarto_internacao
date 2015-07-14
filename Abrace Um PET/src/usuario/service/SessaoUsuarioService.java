package usuario.service;

import usuario.dominio.Usuario;


public class SessaoUsuarioService {
	Usuario usuarioLogado;
	private static SessaoUsuarioService instancia = new SessaoUsuarioService();
	private SessaoUsuarioService(){}
	public static SessaoUsuarioService getInstancia() {
		return instancia;
	}
	
	public void setUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;
	}
}
