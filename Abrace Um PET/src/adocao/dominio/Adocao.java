package adocao.dominio;

import usuario.dominio.Usuario;
import adotante.dominio.Adotante;
import animal.dominio.Animal;

public class Adocao {

	private int id;
	private Adotante adotante;
	private Animal animal;
	private String dataAdocao;
	private String dataDevolucao;
	private Usuario usuario;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Adotante getAdotante() {
		return adotante;
	}
	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public String getDataAdocao() {
		return dataAdocao;
	}
	public void setDataAdocao(String dataAdocao) {
		this.dataAdocao = dataAdocao;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
