package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.conexao.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dominio.Paciente;

public class PacienteControl {
	public void insereDados(String cpf, String nome, String dataNascimento) {
		Conexao hospital = new Conexao();
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "INSERT INTO hospital.pacientes VALUES ('" + cpf + "','" + nome + "','" + dataNascimento + "');";
			System.out.println(sSQL);
			boolean res = stmt.execute(sSQL);
			
			JOptionPane.showMessageDialog(null,
					(!res) ? "Dados inseridos com sucesso!!!" : ""
							+ "Os dados não puderam ser inseridos!!!");
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados nãoo puderam ser inseridos");
		}
	}

	public void ExcluirCliente(String cpf) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "DELETE FROM hospital.pacientes WHERE cpf = "+ cpf + ";";
			boolean rs = stmt.execute(sSQL);
			JOptionPane.showMessageDialog(null,(!rs) ? "Dados do paciente excluidos com sucesso.": 
				"Dados do paciente não foram excluidos com sucesso.");

			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados não foram encontrado!!!");
		}
	}

	public String AtualizarDados(String cpf, String nome, String dataNascimento) {
		Conexao hospital = new Conexao();
		String retorno = "erro";
		int res;
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();

			res = stmt.executeUpdate("UPDATE hospital.pacientes SET cpf = '"
					+ cpf + "', nome = '" + nome + "', dataNascimento = '"
					+ dataNascimento + "'WHERE cpf = " + cpf);
			if (res == 1)
				JOptionPane.showMessageDialog(null,
						"Os dados  foram atualizados com sucesso!!!");
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados não puderam ser atualizados!!!");
		}
		return retorno;
	}

	public void BuscarDados(String cpf, Paciente paciente) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "SELECT * FROM hospital.pacientes WHERE cpf = "
					+ cpf;
			ResultSet rs = stmt.executeQuery(sSQL);

			while (rs.next()) {
				paciente.setCpf(rs.getString("cpf"));
				paciente.setNome(rs.getString("nome"));
				paciente.setDataNascimento((rs.getDate("dataNascimento")));
			}
			
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados não puderam ser encontrado!!!");
		}
	}
	
	public void preencher_tabela(JTable Tabela) throws SQLException{
		Conexao bd = new Conexao();
		Connection conn = (Connection) bd.abrirBDConn();
		try{
			
			DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
			modelo.setNumRows(0);
			
			Statement statement = (Statement) conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet st = statement.executeQuery("Select * from hospital.pacientes");
			while(st.next()){
				
				modelo.addRow(new Object[]{
						st.getString("cpf"),
						st.getString("nome"),
						st.getDate("dataNascimento"),
				});
			}
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro ao adicionar na tabela" + erro, "Erro no sistema", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
