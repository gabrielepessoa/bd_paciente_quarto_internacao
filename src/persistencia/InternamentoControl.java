package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.conexao.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dominio.Internamento;

public class InternamentoControl {
	Internamento internamento = new Internamento();

	public void insereDados(String cpf, int numInternamento, String dataAlta, String dataBaixa, int numLeito) {
		Conexao hospital = new Conexao();
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "INSERT INTO hospital.internamentos VALUES ('" + cpf + "','" + numInternamento + "','"
					+ dataAlta + "','" + dataBaixa + "','" + numLeito + "');";
			System.out.println(sSQL);
			boolean res = stmt.execute(sSQL);

			JOptionPane.showMessageDialog(null,
					(!res) ? "Dados inseridos com sucesso!!!" : "" + "Os dados não puderam ser inseridos!!!");
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Os dados nãoo puderam ser inseridos");
		}
	}

	public void preencher_tabela(JTable Tabela) throws SQLException {
		Conexao bd = new Conexao();
		Connection conn = (Connection) bd.abrirBDConn();
		try {

			DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
			modelo.setNumRows(0);

			Statement statement = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet st = statement.executeQuery("Select * from hospital.internamentos");
			while (st.next()) {

				modelo.addRow(
						new Object[] {st.getString("cpf"), st.getInt("numInternamento"),
								st.getString("dataBaixa"), st.getString("dataAlta"), st.getString("numLeito") });
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar na tabela" + erro, "Erro no sistema",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void ExcluirInternamento(String cpf, int numInternamento) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "DELETE FROM hospital.internamentos WHERE cpf = "+ cpf + " and numInternamento = " + numInternamento +";";
			boolean rs = stmt.execute(sSQL);
			JOptionPane.showMessageDialog(null,(!rs) ? "Dados do internamento excluidos com sucesso.": 
				"Dados do internamento não foram excluidos com sucesso.");

			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados não foram encontrado!!!");
		}
	}
	
	public void BuscarDadosResultInternamento(String cpf, int numInternamento, Internamento internamento) {
		Conexao hospital = new Conexao();
		try {
			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "SELECT cpf, numInternamento, dataBaixa, dataAlta, numLeito FROM hospital.internamentos WHERE cpf = "+ cpf + " and numInternamento = " + numInternamento+";";
			ResultSet rs = stmt.executeQuery(sSQL);
			while (rs.next()) {
				internamento.setCpf(rs.getString("cpf"));
				internamento.setNumInternamento(rs.getInt("numInternamento"));
				internamento.setDataBaixa(rs.getDate("dataBaixa"));
				internamento.setDataAlta(rs.getDate("dataAlta"));
				internamento.setNumLeito(rs.getInt("numLeito"));
			}
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Os dados não puderam ser encontrado!!!");
		}
	}
	
	public String AtualizarDados(String cpf, int numInternamento, String dataBaixa, String dataAlta, int numLeito) {
		Conexao hospital = new Conexao();
		String retorno = "erro";
		int res;
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();

			res = stmt.executeUpdate("UPDATE hospital.internamentos SET cpf = '"
					+ cpf + "', numInternamento = '" + numInternamento + "', dataBaixa = '"
					+ dataBaixa + "', dataAlta = '"+ dataAlta + "', numLeito = '"+ numLeito +
					"'WHERE cpf = "+ cpf + " and numInternamento = " + numInternamento+";");
			
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

}
