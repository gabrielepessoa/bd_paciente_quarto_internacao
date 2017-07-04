package dominio;
import java.util.Date;


public class Paciente {
	private String codPac;
	private String nomePac;
	private Date dataNascimento;
	public String getCodPac() {
		return codPac;
	}
	public void setCodPac(String codPac) {
		this.codPac = codPac;
	}
	public String getNomePac() {
		return nomePac;
	}
	public void setNomePac(String nomePac) {
		this.nomePac = nomePac;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
