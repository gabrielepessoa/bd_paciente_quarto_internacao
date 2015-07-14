package adotante.service;

import adotante.dao.PessoaFisicaDAO;
import adotante.dao.PessoaJuridicaDAO;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;

public class PessoaJuridicaService {
	private PessoaJuridicaDAO	pessoaJuridicaDAO	= new PessoaJuridicaDAO();
	PessoaFisicaDAO				pessoaFisicaDao		= new PessoaFisicaDAO();
	PessoaFisica				pessoaFisica		= new PessoaFisica();
	PessoaJuridica				pessoaJuridica		= new PessoaJuridica();
	
	public boolean adicionarPessoaJuridicaService(PessoaJuridica pessoaJuridica) throws Exception{
		return pessoaJuridicaDAO.adicionarPessoaJuridica(pessoaJuridica);
	}
	
	
	public PessoaJuridica consultarPessoaJuridica(String cnpj) throws Exception{
		PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
		return pessoaJuridicaDAO.consultarPessoaJuridica(cnpj);
	}
	
	public boolean validarCpfResponsavelJuridico(String cpf) throws Exception{
		boolean valido;
		pessoaFisica.setCpf(cpf);
		if (pessoaFisicaDao.consultarPessoaFisicaCPF(cpf)) {
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}
	
	/**
	 * VERIFICA SE O CNPJ JA ESTÁ CADASTRADO NO SISTEMA
	 * @param cnpj
	 * @return
	 */
	public boolean validarCadastroPessoaJuridica(String cnpj) throws Exception{
		boolean valido;
		pessoaJuridica.setCnpj(cnpj);
		
		if (pessoaJuridicaDAO.consultarPessoaJuridicaCNPJ(cnpj) == false) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	
	public void excluirPessoaJuridica(PessoaJuridica pessoaJuridica) throws Exception{
		PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
		pessoaJuridicaDAO.excluirPessoaJuridica(pessoaJuridica);
	}
}
