package sistema.control;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistema.conexao.Conexao;
import base.Leito;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LeitoControl {
	public void insereDados(int numeroLeito, int numeroQuarto, String tipoLeito) {
		Conexao hospital = new Conexao();
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "INSERT INTO hospital.leito VALUES ('" + numeroLeito
					+ "','" + numeroQuarto + "','" + tipoLeito + "');";
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

	public void ExcluirLeito(int numeroLeito) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "DELETE FROM hospital.leito WHERE numleito = "
					+ numeroLeito + ";";
			boolean rs = stmt.execute(sSQL);
			JOptionPane
					.showMessageDialog(
							null,
							(!rs) ? "Dados do leito excluidos com sucesso."
									: "Dados do paciente não foram excluidos com sucesso.");

			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados não foram encontrado!!!");
		}
	}

	public String AtualizarDados(int numLeito, int numQuarto, String tipoLeito) {
		Conexao hospital = new Conexao();
		String retorno = "erro";
		int res;
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();

			res = stmt.executeUpdate("UPDATE hospital.leito SET numleito = '"
					+ numLeito + "', numquarto = '" + numQuarto
					+ "',tipoleito = '" + tipoLeito + "'WHERE numleito = "
					+ numLeito);
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

	public void BuscarDados(int numLeito, Leito leito) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "SELECT * FROM hospital.leito WHERE numleito = "
					+ numLeito;
			ResultSet rs = stmt.executeQuery(sSQL);

			while (rs.next()) {
				leito.setNumLeito(rs.getInt("numleito"));
				leito.setNumQuarto(rs.getInt("numquarto"));
				leito.setTipoLeito(rs.getString("tipoleito"));
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
			ResultSet st = statement.executeQuery("Select * from hospital.leitossistema");
			while(st.next()){
				
				modelo.addRow(new Object[]{
						st.getInt("NumeroLeito"),
						st.getInt("NumeroQuarto"),
						st.getString("TipoLeito"),
				});
			}
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro ao adicionar na tabela" + erro, "Erro no sistema", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
