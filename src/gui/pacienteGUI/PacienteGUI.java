package gui.pacienteGUI;

import gui.HospitalGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.PacienteControl;
import dominio.Paciente;

public class PacienteGUI extends JFrame {

	private JPanel contentPane;

	PacienteControl pc = new PacienteControl();
	Paciente paciente = new Paciente();
	PacienteListagemGUI plg = new PacienteListagemGUI();

	public PacienteGUI() {
		setTitle("Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteCadastroGIU pcg = new PacienteCadastroGIU();
				pcg.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(158, 73, 177, 23);
		contentPane.add(btnCadastrar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteResultConsultaGUI prc = new PacienteResultConsultaGUI();
				prc.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(158, 131, 177, 23);
		contentPane.add(btnConsultar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codPac = JOptionPane.showInputDialog(null,
						"Digite o CPF do paciente");
				pc.ExcluirCliente(codPac);
			}
		});
		btnExcluir.setBounds(158, 193, 177, 23);
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

		JButton btnNewButtonPacientesCadast = new JButton(
				"Pacientes Cadastrados");
		btnNewButtonPacientesCadast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plg.setVisible(true);
				dispose();
			}
		});
		btnNewButtonPacientesCadast.setBounds(158, 255, 177, 23);
		contentPane.add(btnNewButtonPacientesCadast);
	}

}
