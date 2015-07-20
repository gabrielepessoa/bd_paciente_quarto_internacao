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

	public void insereDados(String codPac, int numeroIntern, String dataAlta, String dataBaixa, int numeroLeito) {
		Conexao hospital = new Conexao();
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "INSERT INTO hospital.internamento VALUES ('" + codPac + "','" + numeroIntern + "','"
					+ dataAlta + "','" + dataBaixa + "','" + numeroLeito + "');";
			System.out.println(sSQL);
			boolean res = stmt.execute(sSQL);

			JOptionPane.showMessageDialog(null,
					(!res) ? "Dados inseridos com sucesso!!!" : "" + "Os dados n�o puderam ser inseridos!!!");
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Os dados n�oo puderam ser inseridos");
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
			ResultSet st = statement.executeQuery("Select * from hospital.internadossistema");
			while (st.next()) {

				modelo.addRow(
						new Object[] {st.getString("CPF"), st.getInt("NumeroInternamento"),
								st.getString("DataBaixa"), st.getString("DataAlta"), st.getString("NumeroLeito") });
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar na tabela" + erro, "Erro no sistema",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void ExcluirInternamento(String codPac, int numeroIntern) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "DELETE FROM hospital.internamento WHERE codpac = "+ codPac + " and numerointern = " + numeroIntern+";";
			boolean rs = stmt.execute(sSQL);
			JOptionPane.showMessageDialog(null,(!rs) ? "Dados do internamento excluidos com sucesso.": 
				"Dados do internamento n�o foram excluidos com sucesso.");

			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados n�o foram encontrado!!!");
		}
	}
	
	public void BuscarDadosResultInternamento(String codPac, int numeroIntern, Internamento internamento) {
		Conexao hospital = new Conexao();
		try {
			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "SELECT codpac, numerointern, databaixa, dataalta, numleito FROM hospital.internamento WHERE codpac = "+ codPac + " and numerointern = " + numeroIntern+";";
			ResultSet rs = stmt.executeQuery(sSQL);
			while (rs.next()) {
				internamento.setCodPaciente(rs.getString("codpac"));
				internamento.setNumeroInternamento(rs.getInt("numerointern"));
				internamento.setDataBaixa(rs.getDate("databaixa"));
				internamento.setDataAlta(rs.getDate("dataalta"));
				internamento.setNumLeito(rs.getInt("numleito"));
			}
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Os dados n�o puderam ser encontrado!!!");
		}
	}
	
	public String AtualizarDados(String codPac, int numeroIntern, String dataBaixa, String dataAlta, int numLeito) {
		Conexao hospital = new Conexao();
		String retorno = "erro";
		int res;
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();

			res = stmt.executeUpdate("UPDATE hospital.internamento SET codpac = '"
					+ codPac + "', numerointern = '" + numeroIntern + "',databaixa = '"
					+ dataBaixa + "', dataalta = '"+ dataAlta + "', numleito = '"+ numLeito +
					"'WHERE codpac = "+ codPac + " and numerointern = " + numeroIntern+";");
			
			if (res == 1)
				JOptionPane.showMessageDialog(null,
						"Os dados  foram atualizados com sucesso!!!");
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados n�o puderam ser atualizados!!!");
		}
		return retorno;
	}

}
