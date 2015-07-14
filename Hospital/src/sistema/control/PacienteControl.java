package sistema.control;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import sistema.conexao.Conexao;
import base.Paciente;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class PacienteControl {
	public void insereDados(int codPac, String nome, String dataNascimento) {
		Conexao hospital = new Conexao();
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "INSERT INTO hospital.paciente VALUES ('" + codPac+ "','" + nome + "','" + dataNascimento + "');";
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

	public void ExcluirCliente(int codPac) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "DELETE FROM hospital.paciente WHERE codpac = "+ codPac + ";";
			boolean rs = stmt.execute(sSQL);
			JOptionPane.showMessageDialog(null,(!rs) ? "Dados do paciente excluidos com sucesso.": "Dados do paciente não foram excluidos com sucesso.");

			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados não foram encontrado!!!");
		}
	}

	public String AtualizarDados(int codPac, String nome, String dataNascimento) {
		Conexao hospital = new Conexao();
		String retorno = "erro";
		int res;
		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();

			res = stmt.executeUpdate("UPDATE hospital.paciente SET codpac = '"
					+ codPac + "', nomepac = '" + nome + "',datanascpac = '"
					+ dataNascimento + "'WHERE codpac = " + codPac);
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

	public void BuscarDados(int codPac, Paciente paciente) {
		Conexao hospital = new Conexao();

		try {

			Connection ExConn = (Connection) hospital.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "SELECT * FROM hospital.paciente WHERE codpac = "
					+ codPac;
			ResultSet rs = stmt.executeQuery(sSQL);

			while (rs.next()) {
				paciente.setCodPac(rs.getInt("codpac"));
				paciente.setNomePac(rs.getString("nomepac"));
				paciente.setDataNascimento((rs.getDate("datanascpac")));
			}
			
			stmt.close();
			hospital.fecharBDConn();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados não puderam ser encontrado!!!");
		}
	}

}
