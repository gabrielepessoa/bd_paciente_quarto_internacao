package adocao.service;

import adocao.dao.AdocaoDAO;
import adocao.dominio.Adocao;
import adotante.dao.AdotanteDAO;
import adotante.dominio.Adotante;
import adotante.dominio.Pessoa;

public class AdocaoService {
	private AdocaoDAO adocaoDAO = new AdocaoDAO();

	public boolean adicionarAdocaoService(Adocao adocao) throws Exception{
		return adocaoDAO.adicionarAdocao(adocao);
	}
	
	public Adotante consultarAdotante(Pessoa pessoa){
		Adotante adotante = null;
		AdotanteDAO adotanteDAO = new AdotanteDAO();
		try{
			adotante = adotanteDAO.consultarAdotante(pessoa);
		} catch (Exception ex) {
			
		}
		return adotante;
	}
	
	public Adocao consultarAdocao(String cpf, String rga){
		Adocao adocao = null;
		AdocaoDAO adocaoDAO = new AdocaoDAO();
		try{
			adocao = adocaoDAO.consultarAdocao(cpf, rga);
		} catch (Exception ex) {
			
		}
		return adocao;
	}
	
	public Adocao consultarAdocaoJuridica(String cnpj, String rga) throws Exception{
		Adocao adocao = null;
		AdocaoDAO adocaoDAO = new AdocaoDAO();
	    adocao = adocaoDAO.consultarAdocaoJuridica(cnpj, rga);
		return adocao;
	}
	
	public boolean editarAdocao(Adocao adocao){
		AdocaoDAO adocaoDAO = new AdocaoDAO();
		return adocaoDAO.editarAdocao(adocao);
	}
}
