package gui.internamentoGUI;

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

import persistencia.InternamentoControl;

public class InternamentoCadastroGUI extends JFrame {

	private JPanel contentPane;

	InternamentoControl ic = new InternamentoControl();
	private JTextField textFieldNumInternamento;
	private JTextField textFieldNumLeito;

	/**
	 * Create the frame.
	 */
	public InternamentoCadastroGUI() {
		setTitle("Cadastro de Internamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JFormattedTextField textFieldCpf = cpfMascara();
		final JFormattedTextField textFieldDataBaixa = dataBaixaMascara();
		final JFormattedTextField textFieldDataAlta = dataAltaMascara();

		textFieldNumLeito = new JTextField();
		textFieldNumLeito.setBounds(308, 104, 145, 20);
		contentPane.add(textFieldNumLeito);
		textFieldNumLeito.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpf = textFieldCpf.getText();
				int numInternamento = Integer.parseInt(textFieldNumInternamento
						.getText());
				int numLeito = Integer.parseInt(textFieldNumLeito.getText());
				String dataBaixa = textFieldDataBaixa.getText();
				String dataAlta = textFieldDataAlta.getText();
				ic.insereDados(cpf, numInternamento, dataAlta, dataBaixa,
						numLeito);
				dispose();
			}
		});
		btnCadastrar.setBounds(354, 248, 99, 23);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InternamentoGUI ig = new InternamentoGUI();
				ig.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 248, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldNumInternamento.setText("");
				textFieldCpf.setText("");
				textFieldDataAlta.setText("");
				textFieldDataBaixa.setText("");
				textFieldNumLeito.setText("");
			}
		});
		btnLimpar.setBounds(194, 248, 89, 23);
		contentPane.add(btnLimpar);

		JLabel lblCpf = new JLabel("CPF do Paciente:");
		lblCpf.setBounds(10, 83, 127, 14);
		contentPane.add(lblCpf);

		JLabel lblNumInternamento = new JLabel("Numero do Internamento:");
		lblNumInternamento.setBounds(147, 83, 151, 14);
		contentPane.add(lblNumInternamento);

		textFieldNumInternamento = new JTextField();
		textFieldNumInternamento.setBounds(147, 104, 151, 20);
		contentPane.add(textFieldNumInternamento);
		textFieldNumInternamento.setColumns(10);

		JLabel lblNumLeito = new JLabel("Numero do Leito:");
		lblNumLeito.setBounds(308, 83, 133, 14);
		contentPane.add(lblNumLeito);

		JLabel lblDataBaixa = new JLabel("Data Baixa:");
		lblDataBaixa.setBounds(89, 154, 82, 14);
		contentPane.add(lblDataBaixa);

		JLabel lblDaataAlta = new JLabel("Data Alta:");
		lblDaataAlta.setBounds(248, 154, 82, 14);
		contentPane.add(lblDaataAlta);
	}

	private JFormattedTextField dataBaixaMascara() {
		MaskFormatter mascaraDataBaixa = null;
		try {
			mascaraDataBaixa = new MaskFormatter("##-##-####");
			mascaraDataBaixa.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Digite uma data válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField textFieldDataBaixa = new JFormattedTextField(
				mascaraDataBaixa);
		textFieldDataBaixa.setBounds(89, 168, 123, 20);
		contentPane.add(textFieldDataBaixa);
		return textFieldDataBaixa;
	}

	private JFormattedTextField dataAltaMascara() {
		MaskFormatter mascaraDataAlta = null;
		try {
			mascaraDataAlta = new MaskFormatter("##-##-####");
			mascaraDataAlta.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Digite uma data válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField textFieldDataAlta = new JFormattedTextField(
				mascaraDataAlta);
		textFieldDataAlta.setBounds(248, 168, 118, 20);
		contentPane.add(textFieldDataAlta);
		return textFieldDataAlta;
	}

	// CPF FORMATADO
	private JFormattedTextField cpfMascara() {
		MaskFormatter mascaraCpf1 = null;
		try {
			mascaraCpf1 = new MaskFormatter("###.###.###-##");
			mascaraCpf1.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Digite um CPF válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField textFieldCpf = new JFormattedTextField(
				mascaraCpf1);
		textFieldCpf.setBounds(10, 104, 127, 20);
		contentPane.add(textFieldCpf);
		return textFieldCpf;
	}
}
