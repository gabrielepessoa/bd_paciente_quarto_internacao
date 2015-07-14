package animal.raca.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import animal.raca.dominio.Raca;

public class RacaDAO {
	Conexao	conexao	= new Conexao();
	
	/**
	 * RETORNA OS OBJETOS DE RAÇAS EXISTENTES NO BANCO DE DADOS
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List < Raca> getRaca() throws SQLException {
		
		Connection conn = (Connection) Conexao.abrir();
		PreparedStatement statement = conn.prepareStatement("select * from raca");
		ResultSet resultSet = statement.executeQuery();
		
		List < Raca> racas = new ArrayList < Raca>();
		while (resultSet.next()) {
			
			Raca raca = new Raca();
			raca.setId(resultSet.getInt("id"));
			raca.setNome(resultSet.getString("nome"));
			raca.setOrigem(resultSet.getString("origem"));
			raca.setTipo(resultSet.getString("tipo"));
			raca.setTamanhoMax(resultSet.getInt("tamanhoMax"));
			raca.setTamanhoMin(resultSet.getInt("tamanhoMin"));
			raca.setExpectativaVida(resultSet.getInt("expectativaVida"));
			raca.setTemperamento(resultSet.getString("temperamento"));
			
			racas.add(raca);
		}
		return racas;
	}
	
	/**
	 * USADO PARA INSERIR CADASTRO DE RAÇA NO BANCO DE DADOS
	 * 
	 * @param raca
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public int inserirRaca(Raca raca) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = 0;
		String query = "INSERT INTO raca(nome, origem, tamanhoMax, tamanhoMin, expectativaVida, temperamento,tipo) values (?, ?, ?, ?, ?, ?,?)";
		
		try {
			con = (Connection) Conexao.abrir();
			preparedStatement = (PreparedStatement) con.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, raca.getNome());
			preparedStatement.setString(2, raca.getOrigem());
			preparedStatement.setDouble(3, raca.getTamanhoMax());
			preparedStatement.setDouble(4, raca.getTamanhoMin());
			preparedStatement.setInt(5, raca.getExpectativaVida());
			preparedStatement.setString(6, raca.getTemperamento());
			preparedStatement.setString(7, raca.getTipo());
			
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
			throw new Exception("Erro ao cadastrar a raça", ex);
		}
		return id;
	}
	
	/**
	 * USADO PARA ADICIONAR A TABELA BANCO DE DADOS
	 * 
	 * @author Lisandra Cruz
	 * @param raca
	 * @return
	 */
	public boolean adicionarRaca(Raca raca) {
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		Connection con = null;
		RacaDAO racaDAO = new RacaDAO();
		try {
			con = (Connection) Conexao.abrir();
			racaDAO.inserirRaca(raca);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			Conexao.fechar(con, preparedStatement, generatedKeys);
		}
	}
	
	/**
	 * 
	 * @param nome
	 * @return
	 */
	public boolean booleanConsultarRaca(String nome) throws Exception {
		String query = ("SELECT nome FROM raca where nome='" + nome + "'");
		return (Conexao.consultar(query));
	}
	
	public Raca consultarRaca(String nome) throws Exception {
		Connection connection = Conexao.abrir();
		PreparedStatement statementAnimal = null;
		ResultSet resultAnimal = null;
		
		try {
			String queryRaca = "SELECT raca.nome, raca.origem, raca.tamanhoMax, raca.tamanhoMin, "
					+ "raca.expectativaVida, raca.temperamento, raca.tipo FROM raca as a WHERE nome = ?";
			
			statementAnimal = connection.prepareStatement(queryRaca);
			statementAnimal.setString(1, nome);
			resultAnimal = statementAnimal.executeQuery();
			
			Raca raca = new Raca();
			
			if(resultAnimal.next()){
				raca.setId(resultAnimal.getInt("id"));
				raca.setNome(resultAnimal.getString("nome"));
				raca.setOrigem(resultAnimal.getString("origem"));
				raca.setTamanhoMax(resultAnimal.getDouble("tamanhoMax"));
				raca.setTamanhoMin(resultAnimal.getDouble("tamanhoMin"));
				raca.setTipo(resultAnimal.getString("tipo"));
				raca.setExpectativaVida(resultAnimal.getInt("expectativaVida"));
			}
			return raca;
		} catch(Exception e){
			throw new Exception("Raça não pôde ser consultada.", e);
		}
		finally {
			Conexao.fechar(connection, statementAnimal, resultAnimal);
		}
		
	}
}
