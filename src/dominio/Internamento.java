package dominio;

import java.util.Date;

public class Internamento {
	private String cpf;
	private int numLeito;
	private int numInternamento;
	private Date dataAlta;
	private Date dataBaixa;
	
	

	public Date getDataAlta() {
		return dataAlta;
	}
	public void setDataAlta(Date dataAlta) {
		this.dataAlta = dataAlta;
	}
	public Date getDataBaixa() {
		return dataBaixa;
	}
	public void setDataBaixa(Date dataBaixa) {
		this.dataBaixa = dataBaixa;
	}
	public int getNumLeito() {
		return numLeito;
	}
	public void setNumLeito(int numLeito) {
		this.numLeito = numLeito;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getNumInternamento() {
		return numInternamento;
	}
	public void setNumInternamento(int numInternamento) {
		this.numInternamento = numInternamento;
	}
	
	
}
