package usuario.service;

import adocao.dominio.Adocao;
import usuario.dominio.Usuario;


public class SessaoUsuario {
	Adocao adocao;
	Usuario usuarioLogado;
	private static SessaoUsuario instancia = new SessaoUsuario();
	private SessaoUsuario(){}
	public static SessaoUsuario getInstancia() {
		return instancia;
	}
	
	public void setUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;
	}
	public void setAdocao(Adocao adocao){
		this.adocao=adocao;
	}
	public Usuario getUsuarioLogado(){
		return usuarioLogado;
	}
}
