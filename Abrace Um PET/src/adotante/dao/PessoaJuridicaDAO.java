package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;

public class PessoaJuridicaDAO {
	Conexao	conexao	= new Conexao();
	
	/**
	 * ADICIONA PESSOA JURIDICA NO BANCO
	 * 
	 * @param pessoaJuridica
	 * @return
	 */
	public boolean adicionarPessoaJuridica(PessoaJuridica pessoaJuridica) throws Exception{
		try {
			int idEndereco = inserirEndereco(pessoaJuridica);
			int idPessoa = inserirPessoa(pessoaJuridica, idEndereco);
			inserirPessoaJuridica(pessoaJuridica, idPessoa);
			inserirAdotante(idPessoa);
			return true;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	/**
	 * CONSULTA A EXISTENCIA DE PESSOA JURIDICA NO BANCO
	 * 
	 * @param cnpj
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings ("static-access" )
	public boolean consultarPessoaJuridicaCNPJ(String cnpj) throws Exception {
		String resultSet = ("select cnpj from pessoajuridica where cnpj='" + cnpj + "'");
		return (conexao.consultar(resultSet));
	}
	
	/**
	 * INSERE ENDERECO DA PESSOA JURIDICA
	 * 
	 * @param pessoaJuridica
	 * @param con
	 * @return
	 */
	public int inserirEndereco(PessoaJuridica pessoaJuridica) throws Exception{
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = 0;
		
		try {
			con = Conexao.abrir();
			
			Pessoa pessoa = pessoaJuridica.getPessoa();
			Endereco endereco = pessoa.getEndereco();
			
			String estado = endereco.getEstado();
			String cidade = endereco.getCidade();
			String bairro = endereco.getBairro();
			String rua = endereco.getRua();
			String numero = endereco.getNumero();
			String cep = endereco.getCep();
			String complemento = endereco.getComplemento();
			
			String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			
			preparedStatement.setString(1, estado);
			preparedStatement.setString(2, cidade);
			preparedStatement.setString(3, bairro);
			preparedStatement.setString(4, rua);
			preparedStatement.setString(5, numero);
			preparedStatement.setString(6, cep);
			preparedStatement.setString(7, complemento);
			
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao cadastrar o endereço",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
		return id;
	}
	
	/**
	 * INSERE PESSOA DA PESSOA JURIDICA
	 * 
	 * @param pessoaJuridica
	 * @param con
	 * @param idEndereco
	 * @return
	 */
	public int inserirPessoa(PessoaJuridica pessoaJuridica, int idEndereco) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = 0;
		
		
		try {
			con = Conexao.abrir();
			
			String nome = pessoaJuridica.getPessoa().getNome();
			String telefoneFixo = pessoaJuridica.getPessoa().getTelefoneFixo();
			String telefoneCelular = pessoaJuridica.getPessoa().getTelefoneCelular();
			String email = pessoaJuridica.getPessoa().getEmail();
			
			String query = "insert into pessoa (nome, idEndereco, telefoneFixo, telefoneCelular, email) values (?, ?, ?, ?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, nome);
			preparedStatement.setInt(2, idEndereco);
			preparedStatement.setString(3, telefoneFixo);
			preparedStatement.setString(4, telefoneCelular);
			preparedStatement.setString(5, email);
			
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao cadastrar o pessoa",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
		return id;
		
	}
	
	/**
	 * INSERE ADOTANTE DA PESSOA JURIDICA
	 * 
	 * @param con
	 * @param idPessoa
	 * @return
	 */
	public int inserirAdotante(int idPessoa) throws Exception{
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
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao cadastrar o adotante",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
		return id;
	}
	
	/**
	 * INSERE PESSOA JURIDICA
	 * 
	 * @param pessoaJuridica
	 * @param con
	 * @param idPessoa
	 * @return
	 */
	public int inserirPessoaJuridica(PessoaJuridica pessoaJuridica, int idPessoa) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = 0;
		
		try {
			con = Conexao.abrir();
			
			String cnpj = pessoaJuridica.getCnpj();
			int idResponavel = pessoaJuridica.getResponsavel().getId();
			
			String query = "insert into pessoajuridica (cnpj, idPessoa, idPessoaFisica) values (?, ?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, cnpj);
			preparedStatement.setInt(2, idPessoa);
			preparedStatement.setInt(3, idResponavel);
			
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao cadastrar o pessoa jurídica", ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
		return id;
	}
	
	/**
	 * CONSULTA PESSOA JURIDICA ATRAVEZ DO CNPJ E RETORNA VALORES
	 * 
	 * @param cnpj
	 * @return
	 * @throws SQLException
	 */
	public PessoaJuridica consultarPessoaJuridica(String cnpj) throws Exception {
		Connection connection = Conexao.abrir();
		PreparedStatement statementPessoaJuridica = null;
		ResultSet resultPessoaJuridica = null;
		
		try {
			String queryPessoaJuridicaPessoa = "SELECT pj.id, pj.cnpj, pj.idPessoa, pj.idPessoaFisica, pj.status, p.nome, "
					+ "p.idEndereco, p.telefoneFixo, p.telefoneCelular, p.email FROM pessoajuridica as"
					+ " pj INNER JOIN pessoa as p ON pj.idPessoa = p.id WHERE pj.status <> 0 and cnpj = ?";
			statementPessoaJuridica = connection.prepareStatement(queryPessoaJuridicaPessoa);
			statementPessoaJuridica.setString(1, cnpj);
			resultPessoaJuridica = statementPessoaJuridica.executeQuery();
			
			Pessoa pessoa = new Pessoa();
			PessoaJuridica pessoaJuridica = new PessoaJuridica();
			Endereco endereco = new Endereco();
			PessoaFisica pessoaFisica = new PessoaFisica();
			if (resultPessoaJuridica.next()) {
				
				pessoa.setId(resultPessoaJuridica.getInt("idPessoa"));
				pessoa.setNome(resultPessoaJuridica.getString("nome"));
				pessoa.setEmail(resultPessoaJuridica.getString("email"));
				pessoa.setTelefoneCelular(resultPessoaJuridica.getString("telefoneCelular"));
				pessoa.setTelefoneFixo(resultPessoaJuridica.getString("telefoneFixo"));
				
				pessoaJuridica.setId(resultPessoaJuridica.getInt("id"));
				pessoaJuridica.setCnpj(resultPessoaJuridica.getString("cnpj"));
				
				endereco.setId(resultPessoaJuridica.getInt("idEndereco"));
				
				pessoaFisica.setId(resultPessoaJuridica.getInt("idPessoaFisica"));
				pessoaJuridica.setResponsavel(pessoaFisica);
				
				pessoaJuridica.setPessoa(pessoa);
				pessoaJuridica.setResponsavel(pessoaFisica);
				pessoaJuridica.getPessoa().setEndereco(endereco);
			}
			
			return pessoaJuridica;
		} catch (Exception ex) {
			throw new Exception("Pessoa jurídica não encontrada.", ex);
		} finally {
			if (resultPessoaJuridica != null) {
				resultPessoaJuridica.close();
			}
			if (statementPessoaJuridica != null) {
				statementPessoaJuridica.close();
			}
		}
		
	}

	public void excluirPessoaJuridica(PessoaJuridica pessoaJuridica) throws Exception{
		excluindoEndereco(pessoaJuridica.getPessoa().getEndereco());
		excluindoAdotante(pessoaJuridica.getPessoa());
		excluindoPessoa(pessoaJuridica.getPessoa());
		excluindoPessoaJuridica(pessoaJuridica);

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
    
	public void excluindoPessoaJuridica(PessoaJuridica pessoaJuridica) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		try {
			con = Conexao.abrir();
			
			int idPessoaJuridica = pessoaJuridica.getId();

			
			String query = "update pessoajuridica set status = 0 where id = ?";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idPessoaJuridica);
			
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
