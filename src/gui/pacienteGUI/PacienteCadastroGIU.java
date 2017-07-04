package gui.pacienteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import persistencia.PacienteControl;

@SuppressWarnings("serial")
public class PacienteCadastroGIU extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;

	PacienteControl pacienteControl = new PacienteControl();

	public PacienteCadastroGIU() {
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 59, 46, 14);
		contentPane.add(lblNome);

		JLabel lblCpfPaciente = new JLabel("CPF do Paciente:");
		lblCpfPaciente.setBounds(230, 124, 177, 14);
		contentPane.add(lblCpfPaciente);

		JLabel lblDataNascimento = new JLabel("Data de nascimento:");
		lblDataNascimento.setBounds(10, 124, 163, 14);
		contentPane.add(lblDataNascimento);

		final JFormattedTextField textFieldCpfPaciente = cpfMascara();
		final JFormattedTextField textFieldDataNasc = dataNascMascara();

		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 74, 423, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldCpfPaciente.getText();
				String dataNascimento = textFieldDataNasc.getText();
				String nome = textFieldNome.getText();
				pacienteControl.insereDados(cpf, nome, dataNascimento);

				PacienteGUI p = new PacienteGUI();
				p.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(328, 198, 105, 23);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteGUI pg = new PacienteGUI();
				pg.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 198, 105, 23);
		contentPane.add(btnVoltar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldCpfPaciente.setText("");
				textFieldDataNasc.setText("");
				textFieldNome.setText("");
			}
		});
		btnLimpar.setBounds(178, 198, 99, 23);
		contentPane.add(btnLimpar);
	}

	private JFormattedTextField cpfMascara() {
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Digite um CPF válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField textFieldCpfPaciente = new JFormattedTextField(
				mascaraCpf);
		textFieldCpfPaciente.setBounds(230, 139, 203, 20);
		contentPane.add(textFieldCpfPaciente);
		return textFieldCpfPaciente;
	}

	private JFormattedTextField dataNascMascara() {
		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("####-##-##");
			mascaraData.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Digite uma data válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField textFieldDataNascimento = new JFormattedTextField(
				mascaraData);
		textFieldDataNascimento.setBounds(10, 139, 163, 20);
		contentPane.add(textFieldDataNascimento);
		return textFieldDataNascimento;
	}
}
