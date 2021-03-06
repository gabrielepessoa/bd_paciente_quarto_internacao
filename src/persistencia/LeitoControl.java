package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.conexao.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dominio.Leito;

public class LeitoControl {
	public void insereDados(int numLeito, int numQuarto, String tipoLeito) {
		Conexao hospital = new Conexao();
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "INSERT INTO hospital.leitos VALUES ('" + numLeito
					+ "','" + numQuarto + "','" + tipoLeito + "');";
			System.out.println(sSQL);
			boolean res = stmt.execute(sSQL);

			JOptionPane.showMessageDialog(null,
					(!res) ? "Dados inseridos com sucesso!!!" : ""
							+ "Os dados n�o puderam ser inseridos!!!");
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados n�oo puderam ser inseridos");
		}
	}

	public void ExcluirLeito(int numLeito) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "DELETE FROM hospital.leitos WHERE numLeitos = "
					+ numLeito + ";";
			boolean rs = stmt.execute(sSQL);
			JOptionPane
					.showMessageDialog(
							null,
							(!rs) ? "Dados do leito excluidos com sucesso."
									: "Dados do paciente n�o foram excluidos com sucesso.");

			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados n�o foram encontrado!!!");
		}
	}

	public String AtualizarDados(int numLeito, int numQuarto, String tipoLeito) {
		Conexao hospital = new Conexao();
		String retorno = "erro";
		int res;
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();

			res = stmt.executeUpdate("UPDATE hospital.leitos SET numLeito = '"
					+ numLeito + "', numQuarto = '" + numQuarto
					+ "',tipoLeito = '" + tipoLeito + "'WHERE numLeito = "
					+ numLeito);
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

	public void BuscarDados(int numLeito, Leito leito) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "SELECT * FROM hospital.leitos WHERE numLeito = "
					+ numLeito;
			ResultSet rs = stmt.executeQuery(sSQL);

			while (rs.next()) {
				leito.setNumLeito(rs.getInt("numLeito"));
				leito.setNumQuarto(rs.getInt("numQuarto"));
				leito.setTipoLeito(rs.getString("tipoLeito"));
			}

			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados n�o puderam ser encontrado!!!");
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
			ResultSet st = statement.executeQuery("Select * from hospital.leitos");
			while(st.next()){
				
				modelo.addRow(new Object[]{
						st.getInt("numLeito"),
						st.getInt("numQuarto"),
						st.getString("tipoLeito"),
				});
			}
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro ao adicionar na tabela" + erro, "Erro no sistema", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
