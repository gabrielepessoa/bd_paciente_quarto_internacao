package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;

public class EnderecoDAO {
	/**
	 * COSULTA ENDERECO NO BANCO DE DADOS ATRAVÉS DO ID
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Endereco consultarEndereco(int id) throws SQLException {
		Connection connection = Conexao.abrir();
		PreparedStatement statementEndereco = null;
		ResultSet resultEndereco = null;
		
		try {
			
			String queryEndereco = "SELECT id, rua, bairro, numero, cidade,estado, cep, complemento FROM endereco WHERE id='"
					+ id + "'";
			statementEndereco = connection.prepareStatement(queryEndereco);
			resultEndereco = statementEndereco.executeQuery();
			
			Pessoa pessoa = new Pessoa();
			Endereco endereco = new Endereco();
			
			if (resultEndereco.next()) {
				
				endereco.setId(resultEndereco.getInt("id"));
				endereco.setRua(resultEndereco.getString("rua"));
				endereco.setNumero(resultEndereco.getString("numero"));
				endereco.setEstado(resultEndereco.getString("estado"));
				endereco.setComplemento(resultEndereco.getString("complemento"));
				endereco.setCidade(resultEndereco.getString("complemento"));
				endereco.setCep(resultEndereco.getString("cep"));
				endereco.setBairro(resultEndereco.getString("bairro"));
				pessoa.setEndereco(endereco);
				
			}
			
			return endereco;
		} finally {
			if (resultEndereco != null) {
				resultEndereco.close();
			}
			if (statementEndereco != null) {
				statementEndereco.close();
			}
		}
	}
}
