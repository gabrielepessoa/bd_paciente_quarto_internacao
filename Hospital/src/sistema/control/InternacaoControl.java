package sistema.control;

import javax.swing.JOptionPane;

import sistema.conexao.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class InternacaoControl {

	public void insereDados(String codPac, int numeroIntern, String dataAlta, String dataBaixa, int numeroLeito) {
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
							+ "Os dados não puderam ser inseridos!!!");
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados nãoo puderam ser inseridos");
		}
	}

}
