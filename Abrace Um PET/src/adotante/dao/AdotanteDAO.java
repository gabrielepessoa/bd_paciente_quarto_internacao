package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import adotante.dominio.Adotante;
import adotante.dominio.Pessoa;

public class AdotanteDAO {
	/**
	 * CONSULTA ADOTANTE PELO ID DA PESSOA
	 * 
	 * @param pessoa
	 * @return
	 * @throws SQLException
	 */
	public Adotante consultarAdotante(Pessoa pessoa) throws SQLException {
		Connection connection = Conexao.abrir();
		PreparedStatement statementAdotante = null;
		ResultSet resultAdotante = null;

		try {
			String queryAdotante = "SELECT pf.id, pf.idPessoa FROM adotante as pf WHERE idPessoa = ?";
			statementAdotante = connection.prepareStatement(queryAdotante);
			statementAdotante.setInt(1, pessoa.getId());
			resultAdotante = statementAdotante.executeQuery();

			Adotante adotante = new Adotante();
			Pessoa pessoaadotante = new Pessoa();

			if (resultAdotante.next()) {

				adotante.setId(resultAdotante.getInt("id"));
				pessoaadotante.setId(resultAdotante.getInt("idPessoa"));
				adotante.setPessoa(pessoaadotante);

			}
			return adotante;
		} finally {
			if (resultAdotante != null) {
				resultAdotante.close();
			}
			if (statementAdotante != null) {
				statementAdotante.close();
			}
		}
	}
}
