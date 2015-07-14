package base;

import java.util.Date;

public class Internamento {
	private String codPaciente;
	private int numLeito;
	private int numeroInternamento;
	private Date dataAlta;
	private Date dataBaixa;
	
	
	public int getNumeroInternamento() {
		return numeroInternamento;
	}
	public void setNumeroInternamento(int numeroInternamento) {
		this.numeroInternamento = numeroInternamento;
	}
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
	public String getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(String codPaciente) {
		this.codPaciente = codPaciente;
	}
	public int getNumLeito() {
		return numLeito;
	}
	public void setNumLeito(int numLeito) {
		this.numLeito = numLeito;
	}
	
	
}
