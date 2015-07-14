package animal.service;

public class Validacoes {
	
	public boolean verificarVazio(String nome, String mensagem) throws Exception {
		int tamanoNome = nome.length();
		boolean valido = false;
		if (tamanoNome == 0)
			throw new Exception(mensagem);
		else {
			valido = true;
		}
		return valido;
	}
	

	
}
