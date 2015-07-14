package base;

public class Internacao {
	private Paciente paciente;
	private Leito leito;
	private int numeroInternamento;
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Leito getLeito() {
		return leito;
	}
	public void setLeito(Leito leito) {
		this.leito = leito;
	}
	public int getNumeroInternamento() {
		return numeroInternamento;
	}
	public void setNumeroInternamento(int numeroInternamento) {
		this.numeroInternamento = numeroInternamento;
	}
	
	
}
