package sistema.internacaoGUI;

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

import sistema.control.InternamentoControl;

public class InternamentoCadastroGUI extends JFrame {

	private JPanel contentPane;

	InternamentoControl ic = new InternamentoControl();
	private JTextField textFieldCodIntern;
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

		JFormattedTextField textFieldCodPac = cpfMascara();
		JFormattedTextField textFieldDataBaixa = dataBaixaMascara();
		JFormattedTextField textFieldDataAlta = dataAltaMascara();

		textFieldNumLeito = new JTextField();
		textFieldNumLeito.setBounds(335, 104, 118, 20);
		contentPane.add(textFieldNumLeito);
		textFieldNumLeito.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codPac = textFieldCodPac.getText();
				int numeroIntern = Integer.parseInt(textFieldCodIntern
						.getText());
				int numLeito = Integer.parseInt(textFieldNumLeito.getText());
				String dataBaixa = textFieldDataBaixa.getText();
				String dataAlta = textFieldDataAlta.getText();
				ic.insereDados(codPac, numeroIntern, dataAlta, dataBaixa,
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
				textFieldCodIntern.setText("");
				textFieldCodPac.setText("");
				textFieldDataAlta.setText("");
				textFieldDataBaixa.setText("");
				textFieldNumLeito.setText("");
			}
		});
		btnLimpar.setBounds(194, 248, 89, 23);
		contentPane.add(btnLimpar);

		JLabel lblCodigoDoPaciente = new JLabel("CPF do Paciente:");
		lblCodigoDoPaciente.setBounds(10, 83, 123, 14);
		contentPane.add(lblCodigoDoPaciente);

		JLabel lblNumeroDoInternamento = new JLabel("Numero do Internamento:");
		lblNumeroDoInternamento.setBounds(169, 83, 156, 14);
		contentPane.add(lblNumeroDoInternamento);

		textFieldCodIntern = new JTextField();
		textFieldCodIntern.setBounds(169, 104, 135, 20);
		contentPane.add(textFieldCodIntern);
		textFieldCodIntern.setColumns(10);

		JLabel lblNumeroDoLeito = new JLabel("Numero do Leito:");
		lblNumeroDoLeito.setBounds(335, 83, 118, 14);
		contentPane.add(lblNumeroDoLeito);

		JLabel lblDataBaixa = new JLabel("Data Baixa:");
		lblDataBaixa.setBounds(10, 155, 82, 14);
		contentPane.add(lblDataBaixa);

		JLabel lblDaataAlta = new JLabel("Data Alta:");
		lblDaataAlta.setBounds(169, 155, 82, 14);
		contentPane.add(lblDaataAlta);
	}

	private JFormattedTextField dataBaixaMascara() {
		MaskFormatter mascaraDataBaixa = null;
		try {
			mascaraDataBaixa = new MaskFormatter("####-##-##");
			mascaraDataBaixa.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Digite uma data válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField textFieldDataBaixa = new JFormattedTextField(
				mascaraDataBaixa);
		textFieldDataBaixa.setBounds(10, 169, 123, 20);
		contentPane.add(textFieldDataBaixa);
		return textFieldDataBaixa;
	}

	private JFormattedTextField dataAltaMascara() {
		MaskFormatter mascaraDataAlta = null;
		try {
			mascaraDataAlta = new MaskFormatter("####-##-##");
			mascaraDataAlta.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Digite uma data válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField textFieldDataAlta = new JFormattedTextField(
				mascaraDataAlta);
		textFieldDataAlta.setBounds(169, 169, 118, 20);
		contentPane.add(textFieldDataAlta);
		return textFieldDataAlta;
	}

	// CPF FORMATADO
	private JFormattedTextField cpfMascara() {
		MaskFormatter mascaraCpf1 = null;
		try {
			mascaraCpf1 = new MaskFormatter("###########");
			mascaraCpf1.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Digite um CPF válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField textFieldCodPac = new JFormattedTextField(
				mascaraCpf1);
		textFieldCodPac.setBounds(10, 104, 100, 20);
		contentPane.add(textFieldCodPac);
		return textFieldCodPac;
	}
}
