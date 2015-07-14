package sistema.control;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistema.conexao.Conexao;
import base.Internamento;
import base.Paciente;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class InternamentoControl {
	Internamento internamento = new Internamento();
	
	public void insereDados(String codPac, int numeroIntern, String dataAlta, String dataBaixa, int numeroLeito, Internamento internamento) {
		Conexao hospital = new Conexao();
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "INSERT INTO hospital.internacao VALUES ('" + codPac+ "','" + numeroIntern + "','" + dataAlta
																	+ "','" + dataBaixa + "','" + numeroLeito + "');";
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
	
	public void preencher_tabela(JTable Tabela) throws SQLException{
		Conexao bd = new Conexao();
		Connection conn = (Connection) bd.abrirBDConn();
		try{
			
			DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
			modelo.setNumRows(0);
			
			Statement statement = (Statement) conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet st = statement.executeQuery("Select * from hospital.internadossistema");
			while(st.next()){
				
				modelo.addRow(new Object[]{
						Tabela.getRowCount() + 1,
						st.getString("CPF"),
						st.getInt("NumeroInternamento"),
						st.getString("DataBaixa"),
						st.getString("DataAlta"),
						st.getString("NumeroLeito")
				});
			}
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro ao adicionar na tabela" + erro, "Erro no sistema", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void BuscarDados(String codPac, int numInternamento, String dataBaixa, String dataAlta, int numLeito) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "SELECT * FROM hospital.internamento WHERE codpac = "+ codPac+ "numerointern = "+ numInternamento +"numleito="+numLeito;
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
			JOptionPane.showMessageDialog(null,
					"Os dados n�o puderam ser encontrado!!!");
		}
	}
	public void ExcluirInternamento(String codPac, int numeroIntern) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "DELETE FROM hospital.internamento WHERE codpac = "+ codPac + ", numerointern = " + numeroIntern+";";
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
	
}
