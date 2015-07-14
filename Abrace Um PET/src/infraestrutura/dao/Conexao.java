package infraestrutura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//AQUI TINHA OS ATRIBUTOS MAS ELE PAGOU PQ DISSE PARA TRANSFORMAR OS METODOS ABAIXO STATICOS POR ASSIM
//EU PODERIA CHAMA-LOS SEM PRECISAR CRIAR OBJETO, ISSO Q EU ENTENDI

public class Conexao {
	
	public static ResultSet getResultSet() {
		return getResultSet();
	}

	public static void setResultSet(ResultSet resultSet) {
		resultSet = resultSet;
	}

	/**
	 * ABRE CONEXÃO COM COM BANCO
	 */
	public static Connection abrir() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection result = DriverManager.getConnection(
					"jdbc:mysql://localhost/abrace_um_pet", "root", "");
			result.setAutoCommit(false);// NAO ADICIONA ATE Q CHAME ESSE COMMIT
			return result;
		}  catch (ClassNotFoundException e) {    
            throw new RuntimeException(e.getMessage());  
		}
	}

	/**
	 * FECHA CONEXÃO COM COM BANCO
	 */
	public static void fechar(Connection conn, Statement stmt, ResultSet rs) { //MUDOU ISSO
		RuntimeException erro = null;
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				erro = new RuntimeException(e);
			}
		}
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				erro = new RuntimeException(e);
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				erro = new RuntimeException(e);
			}
		} 
		if (erro != null) {
			throw erro;
		}
	}

	/**
	 * RESULTADO DA CONSULTA NO BANCO
	 * @throws Exception 
	 */
	public static ResultSet queryMySQL(String qry) throws Exception {
		Connection conexao = null;
		Statement statement = null;
		String stringSQL;
		try {
			statement = conexao.createStatement();
			stringSQL = qry;
			setResultSet(statement.executeQuery(stringSQL));
			getResultSet().first();
			return getResultSet();
		} catch (Exception erro) {
			throw new Exception("Erro ao retornar os registros do banco de dados", erro);
		}
	}

	/**
	 * EXECUTAR COMANDOS
	 */
	public static long comandoMySQL(String comando) {
		long x = -1;
		try {
			Connection conexao = null;
			Statement statement = (Statement) conexao.createStatement();
			statement.execute(comando);
		} catch (Exception erro) {
			System.out.println("MYSQL Erro: " + erro);
		}
		return x;
	}
	
	/**
	 * GERAL PARA CONSULTA COM RETORNO BOOLEAN
	 * 
	 * @param query
	 * @return
	 * @throws Exception 
	 */
	public static boolean consultar(String query) throws Exception { //TEM QUE SER ASSIM
		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean valido = false;
		try {
			conexao = Conexao.abrir();
			statement = (Statement) conexao.createStatement();
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				
				valido = true;
			} else {
				valido = false;
			}
		} catch (SQLException e) {
			throw new Exception("Erro ao consultar os registros no banco de dados", e);
		} finally {
			Conexao.fechar(conexao,statement,resultSet);
		}
		return valido;
	}
	
	

}
