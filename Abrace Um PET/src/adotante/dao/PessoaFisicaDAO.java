package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;

public class PessoaFisicaDAO {
	
	Conexao	conexao	= new Conexao();
	
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public boolean adicionarPessoaFisica(PessoaFisica pessoaFisica) throws Exception {
		boolean valido = false;
				
		try {
			
			int idEndereco = inserirEndereco(pessoaFisica);
			int idPessoa = inserirPessoa(pessoaFisica, idEndereco);
			inserirPessoaFisica(pessoaFisica, idPessoa);
			inserirAdotante(idPessoa);
			
			valido = true;
		} catch (Exception ex) {
			valido = false;
			throw new Exception("Erro ao adicionar pessoa física no banco de dados", ex);
		} 
		return valido;
	}
	
	/**
	 * QUERY PARA O METODO CONSULTAR
	 * 
	 * @param cpf
	 * @return
	 * @throws Exception
	 */
	public boolean consultarPessoaFisicaCPF(String cpf) throws Exception {
		String query = ("SELECT cpf FROM pessoafisica where cpf='" + cpf + "'");
		return (Conexao.consultar(query));
	}
	
	/**
	 * INSERE ENDERECO DA PESSOA FISICA NO BANCO DE DADOS
	 * 
	 * @param pessoaFisica
	 * @param con
	 * @return
	 * @throws Exception 
	 */
	public int inserirEndereco(PessoaFisica pessoaFisica) throws Exception {
		int id = 0;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;

		
		try {
			con = Conexao.abrir();
			
			String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			Endereco endereco = pessoaFisica.getPessoa().getEndereco();
			preparedStatement.setString(1, endereco.getEstado());
			preparedStatement.setString(2, endereco.getCidade());
			preparedStatement.setString(3, endereco.getBairro());
			preparedStatement.setString(4, endereco.getRua());
			preparedStatement.setString(5, endereco.getNumero());
			preparedStatement.setString(6, endereco.getCep());
			preparedStatement.setString(7, endereco.getComplemento());
			
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw new Exception("Erro ao cadastrar endereço", e);
		} finally {
			Conexao.fechar(con, preparedStatement, generatedKeys);
		}
		return id;
	}
	
	/**
	 * INSERE PESSOA NO BANCO
	 * 
	 * @param pessoaFisica
	 * @param con
	 * @param idEndereco
	 * @return
	 * @throws Exception 
	 */
	public int inserirPessoa(PessoaFisica pessoaFisica, int idEndereco) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		int id = 0;
		
		try {
			con = Conexao.abrir();
			
			String query = "insert into pessoa (nome, idEndereco, telefoneFixo, telefoneCelular, email) values (?, ?, ?, ?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, pessoaFisica.getPessoa().getNome());
			preparedStatement.setInt(2, idEndereco);
			preparedStatement.setString(3, pessoaFisica.getPessoa().getTelefoneFixo());
			preparedStatement.setString(4, pessoaFisica.getPessoa().getTelefoneCelular());
			preparedStatement.setString(5, pessoaFisica.getPessoa().getEmail());
			
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw new Exception("Erro ao inserir pessoa", e);
		} finally {
			Conexao.fechar(con, preparedStatement, generatedKeys);
		}
		return id;
	}
	
	/**
	 * INSERE ADOTANTE NO BANCO DE DADOS
	 * 
	 * @param con
	 * @param idPessoa
	 * @return
	 * @throws Exception 
	 */
	public int inserirAdotante(int idPessoa) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		int id = 0;
		
		try {
			con = Conexao.abrir();
			
			String query = "insert into adotante (idPessoa) values (?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idPessoa);

			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw new Exception("Erro ao cadastrar adotante", e);
		} finally {
			Conexao.fechar(con, preparedStatement, generatedKeys);
		}
		return id;
	}
	
	/**
	 * INSERE PESSOA FISICA NO BANCO DE DADOS
	 * 
	 * @param pessoaFisica
	 * @param con
	 * @param idPessoa
	 * @return
	 * @throws Exception 
	 */
	public int inserirPessoaFisica(PessoaFisica pessoaFisica, int idPessoa) throws Exception {
		int id = 0;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		try {
			con = Conexao.abrir();
			
			String query = "insert into pessoafisica (rg, cpf, genero, idPessoa) values (?, ?, ?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, pessoaFisica.getRg());
			preparedStatement.setString(2, pessoaFisica.getCpf());
			preparedStatement.setString(3, pessoaFisica.getGenero());
			preparedStatement.setInt(4, idPessoa);
			
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw new Exception("Erro ao inserir pessoa fisica", e);
		} finally {
			Conexao.fechar(con, preparedStatement, generatedKeys);
		}
		return id;
	}
	
	/**
	 * CONSULTA PESSOA FISICA NO BD ATAVES DO CPF
	 * 
	 * @param cpf
	 * @return
	 * @throws SQLException
	 */
	public PessoaFisica consultarPessoaFisica(String cpf) throws Exception {
		Connection connection = Conexao.abrir();
		PreparedStatement statementPessoaFisica = null;
		ResultSet resultPessoaFisica = null;
		
		try {
			String queryPessoaFisicaPessoa = "SELECT pf.id, pf.cpf, pf.idPessoa, pf.rg, pf.genero, pf.status, "
					+ "p.id,  p.nome, p.idEndereco, p.telefoneFixo, p.telefoneCelular, p.email "
					+ "FROM pessoafisica as pf INNER JOIN pessoa as p "
					+ "ON pf.idPessoa = p.id WHERE pf.status <> 0 and cpf = ?";
			statementPessoaFisica = connection.prepareStatement(queryPessoaFisicaPessoa);
			statementPessoaFisica.setString(1, cpf);
			resultPessoaFisica = statementPessoaFisica.executeQuery();
			
			Pessoa pessoa = new Pessoa();
			PessoaFisica pessoaFisica = new PessoaFisica();
			Endereco endereco = new Endereco();
			
			if (resultPessoaFisica.next()) {
				
				pessoa.setId(resultPessoaFisica.getInt("p.id"));
				pessoa.setNome(resultPessoaFisica.getString("p.nome"));
				pessoa.setEmail(resultPessoaFisica.getString("email"));
				pessoa.setTelefoneCelular(resultPessoaFisica.getString("telefoneCelular"));
				pessoa.setTelefoneFixo(resultPessoaFisica.getString("telefoneFixo"));
				pessoaFisica.setId(resultPessoaFisica.getInt("pf.id"));
				pessoaFisica.setCpf(resultPessoaFisica.getString("cpf"));
				pessoaFisica.setRg(resultPessoaFisica.getString("rg"));
				pessoaFisica.setGenero(resultPessoaFisica.getString("genero"));
				endereco.setId(resultPessoaFisica.getInt("idEndereco"));
				pessoaFisica.setPessoa(pessoa);
				pessoa.setEndereco(endereco);
			}
			return pessoaFisica;
		} catch (Exception e) {
			throw new Exception("Pessoa não encontrada", e);
		} finally {
			Conexao.fechar(connection, statementPessoaFisica, resultPessoaFisica);
		}
		
	}
	
	/**
	 * CONSULTA PESSOA FISICA NO BD ATAVES DO id
	 * 
	 * @param cpf
	 * @return
	 * @throws SQLException
	 */
	public PessoaFisica consultarPessoaFisica(int id) throws SQLException {
		Connection connection = Conexao.abrir();
		PreparedStatement statementPessoaFisica = null;
		ResultSet resultPessoaFisica = null;
		
		try {
			String queryPessoaFisicaPessoa = "SELECT pf.id, pf.cpf, pf.idPessoa, pf.rg, pf.genero,"
					+ "p.id,  p.nome, p.idEndereco, p.telefoneFixo, p.telefoneCelular, p.email "
					+ "FROM pessoafisica as pf INNER JOIN pessoa as p "
					+ "ON pf.idPessoa = p.id WHERE pf.id = ?";
			statementPessoaFisica = connection.prepareStatement(queryPessoaFisicaPessoa);
			statementPessoaFisica.setInt(1, id);
			resultPessoaFisica = statementPessoaFisica.executeQuery();
			
			Pessoa pessoa = new Pessoa();
			PessoaFisica pessoaFisica = new PessoaFisica();
			Endereco endereco = new Endereco();
			if (resultPessoaFisica.next()) {
				
				pessoa.setId(resultPessoaFisica.getInt("p.id"));
				pessoa.setNome(resultPessoaFisica.getString("p.nome"));
				pessoa.setEmail(resultPessoaFisica.getString("email"));
				pessoa.setTelefoneCelular(resultPessoaFisica.getString("telefoneCelular"));
				pessoa.setTelefoneFixo(resultPessoaFisica.getString("telefoneFixo"));
				pessoaFisica.setId(resultPessoaFisica.getInt("pf.id"));
				pessoaFisica.setCpf(resultPessoaFisica.getString("cpf"));
				pessoaFisica.setRg(resultPessoaFisica.getString("rg"));
				pessoaFisica.setGenero(resultPessoaFisica.getString("genero"));
				endereco.setId(resultPessoaFisica.getInt("idEndereco"));
				pessoaFisica.setPessoa(pessoa);
				pessoa.setEndereco(endereco);
			}
			
			return pessoaFisica;
		} finally {
			Conexao.fechar(connection, statementPessoaFisica, resultPessoaFisica);
		}
		
	}
	
	public void editarPessoa() throws SQLException {
		Connection connection = Conexao.abrir();
		PreparedStatement statementPessoaFisica = null;
		ResultSet resultPessoaFisica = null;
		String query = "UPDATE pessoafisica SET nome = ?, telefoneCelular = ?, telefoneFixo = ?, email = ?";
		
	}
	
	public void excluirPessoaFisica(PessoaFisica pessoaFisica) throws Exception{
		excluindoEndereco(pessoaFisica.getPessoa().getEndereco());
		excluindoAdotante(pessoaFisica.getPessoa());
		excluindoPessoa(pessoaFisica.getPessoa());
		excluindoPessoaFisica(pessoaFisica);

	}
	
	public void excluindoEndereco(Endereco endereco) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		try {
			con = Conexao.abrir();
			
			int idEndereco = endereco.getId();

			
			String query = "update endereco set status = 0 where id = ?";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idEndereco);

			
			preparedStatement.executeUpdate();
			
			
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao exclui o endereço",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
	}
	
	public void excluindoAdotante(Pessoa pessoa) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		try {
			con = Conexao.abrir();
			
			int idPessoa = pessoa.getId();

			
			String query = "update adotante set status = 0 where idPessoa = ?";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idPessoa);

			
			preparedStatement.executeUpdate();
			
			
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao excluir o adotante",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
		
	}
	
	
	public void excluindoPessoa(Pessoa pessoa) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		try {
			con = Conexao.abrir();
			
			int idPessoa = pessoa.getId();

			
			String query = "update pessoa set status = 0 where id = ?";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idPessoa);

			
			preparedStatement.executeUpdate();
			
			
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao excluir a pessoa",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
	}
    
	public void excluindoPessoaFisica(PessoaFisica pessoaFisica) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		try {
			con = Conexao.abrir();
			
			int idPessoaFisica = pessoaFisica.getId();

			
			String query = "update pessoafisica set status = 0 where id = ?";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idPessoaFisica);
			
			preparedStatement.executeUpdate();
			
			
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao cadastrar o pessoa",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
	}
}
