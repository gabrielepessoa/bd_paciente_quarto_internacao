package infraestrutura.service;


public class ValidacaoService {


	/**
	 * VALIDAR SEXO DA PESSOA FISICA
	 * 
	 * @param genero
	 * @return
	 */
	public boolean validarSexo(String genero) {
		boolean valido;
		if (!genero.equals(" ")) {
			valido = true;
		} else {
			valido = false;
		}

		return valido;
	}

}
