package gui.internamentoGUI;

import gui.HospitalGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.InternamentoControl;
import dominio.Internamento;

public class InternamentoGUI extends JFrame {

	private JPanel contentPane;

	Internamento internamento = new Internamento();
	InternamentoControl internamentoControl = new InternamentoControl();
	InternamentoListagemGUI internamentoListagem = new InternamentoListagemGUI();

	public InternamentoGUI() {
		setTitle("Internamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InternamentoCadastroGUI icg = new InternamentoCadastroGUI();
				icg.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(157, 69, 166, 23);
		contentPane.add(btnCadastrar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InternamentoResultConsultaGUI ircg = new InternamentoResultConsultaGUI();
				ircg.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(158, 136, 165, 23);
		contentPane.add(btnConsultar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String codPac = JOptionPane.showInputDialog(null,
						"Digite o CPF do paciente").toString();
				int numInternamento = Integer.parseInt(JOptionPane
						.showInputDialog(null,
								"Digite o numero do internamento"));

				internamentoControl
						.ExcluirInternamento(codPac, numInternamento);
			}
		});
		btnExcluir.setBounds(157, 205, 166, 23);
		contentPane.add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HospitalGUI h = new HospitalGUI();
				h.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(364, 344, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnPacientesInternados = new JButton("Pacientes Internados");
		btnPacientesInternados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internamentoListagem.setVisible(true);
				dispose();
			}
		});
		btnPacientesInternados.setBounds(157, 269, 166, 23);
		contentPane.add(btnPacientesInternados);
	}

}
