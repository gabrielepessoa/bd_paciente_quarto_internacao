package adotante.dominio;

public class Adotante {
	private int id;
	private Pessoa pessoa;
	private boolean impedimento;
	private String motivoImpedimento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public boolean isImpedimento() {
		return impedimento;
	}
	public void setImpedimento(boolean impedimento) {
		this.impedimento = impedimento;
	}
	public String getMotivoImpedimento() {
		return motivoImpedimento;
	}
	public void setMotivoImpedimento(String motivoImpedimento) {
		this.motivoImpedimento = motivoImpedimento;
	}	
}