package usuario.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import usuario.dominio.Usuario;
import usuario.service.CriptografiaService;

import com.mysql.jdbc.PreparedStatement;

public class UsuarioDAO {
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */
	public int adicionarUsuario(Usuario usuario) throws Exception { //METODO CORRETO TB	
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = -1;
		try {
			con = Conexao.abrir();
			
			String login = usuario.getLogin();
			String senha = usuario.getSenha();
			String email = usuario.getEmail();
			
			CriptografiaService criptografia = new CriptografiaService();
			senha = criptografia.criptografar(senha);
			
			String query = "INSERT INTO usuario (login, senha, email) values (?, ?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, senha);
			preparedStatement.setString(3, email);
			
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();//IMPORTANTE POIS SEM ISSO NAO INSERE NO BANCO
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao cadastrar o usuário",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);//IMPORTANTE FECHAR A CONEXAO DPS
		}
		return id;
	}
	
	
	/**
	 * CONSULTA O USUARIO NO BANCO DE DADOS, USADO NO LOGIN
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws Exception 
	 */
	public boolean consultarLogin(String login, String senha) throws Exception {
		String resultSet = ("select login, senha from usuario where login='" + login + "'and senha='" + senha + "'");
		return Conexao.consultar(resultSet);
	}
	
	/**
	 * @param login
	 * @return
	 * @throws Exception 
	 */
	public boolean consultarUsuario(String login) throws Exception {
		String resultSet = ("select login from usuario where login='" + login + "'");
		return Conexao.consultar(resultSet);
	}
	
//	public int getIdUsuario(Usuario usuario) throws SQLException {
//		Connection connection = Conexao.abrir();
//		PreparedStatement statement = null;
//		ResultSet resultAdotante = null;
////        int id =-1;
//		String login = usuario.getLogin();
//		String senha = usuario.getSenha();
//
//		try {
//			String resultSet = ("select id from usuario where login='" + login + "'and senha='" + senha + "'");
//			statement = (PreparedStatement) connection.prepareStatement(resultSet);
//			resultAdotante = statement.executeQuery();
//
//			if (resultAdotante.next()) {
//
//			usuario.setId(resultAdotante.getInt("id"));
//			}
//			return usuario.getId();
//		} finally {
//			if (resultAdotante != null) {
//				resultAdotante.close();
//			}
//			if (statement != null) {
//				statement.close();
//			}
//		}
//	}

}
