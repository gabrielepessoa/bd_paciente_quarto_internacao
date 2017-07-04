package dominio;

public class Leito {
	private int numLeito;
	private int numQuarto;
	
	public int getNumLeito() {
		return numLeito;
	}
	public void setNumLeito(int numLeito) {
		this.numLeito = numLeito;
	}
	public int getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}
	public String getTipoLeito() {
		return tipoLeito;
	}
	public void setTipoLeito(String tipoLeito) {
		this.tipoLeito = tipoLeito;
	}
	private String tipoLeito;
}
