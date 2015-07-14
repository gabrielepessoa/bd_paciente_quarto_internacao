package sistema.internacaoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import sistema.control.InternacaoControl;
import sistema.control.PacienteControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class InternacaoCadastroGUI extends JFrame {

	private JPanel contentPane;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InternacaoCadastroGUI frame = new InternacaoCadastroGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	InternacaoControl ic = new InternacaoControl();
	private JTextField textFieldCodPac;
	private JTextField textFieldCodIntern;
	private JTextField textFieldDataBaixa;
	private JTextField textFieldDataAlta;
	private JTextField textFieldNumLeito;
	/**
	 * Create the frame.
	 */
	public InternacaoCadastroGUI() {
		setTitle("Cadastro de Interna\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				String codPac = textFieldCodPac.getText();
				int numeroIntern = Integer.parseInt(textFieldCodIntern.getText());
				int numLeito = Integer.parseInt(textFieldNumLeito.getText());
				String dataBaixa = textFieldDataBaixa.getText();
				String dataAlta = textFieldDataAlta.getText();
				ic.insereDados(codPac, numeroIntern, dataBaixa, dataAlta, numLeito);
				dispose();
			}
		});
		btnCadastrar.setBounds(354, 248, 99, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(10, 248, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				textFieldCodPaciente.setText("");
//				textFieldDataNasc.setText("");
//				textFieldNome.setText("");
			}
		});
		btnLimpar.setBounds(194, 248, 89, 23);
		contentPane.add(btnLimpar);
		
//		MaskFormatter mascaraCpf = null;
//		try {
//			mascaraCpf = new MaskFormatter("###########");
//			mascaraCpf.setPlaceholderCharacter('_');
//
//		} catch (ParseException e1) {
//			JOptionPane.showMessageDialog(null, "Digite um CPF válido!" + e1.getMessage(), "ERROR", 0);
//		}
//		JFormattedTextField textFieldCodPac = new JFormattedTextField(mascaraCpf);
//		textFieldCodPac.setBounds(10, 104, 123, 20);
//		contentPane.add(textFieldCodPac);
//		
		
		textFieldCodPac = new JTextField();
		textFieldCodPac.setBounds(10, 104, 100, 20);
		contentPane.add(textFieldCodPac);
		textFieldCodPac.setColumns(10);
		
		JLabel lblCodigoDoPaciente = new JLabel("Codigo do Paciente");
		lblCodigoDoPaciente.setBounds(10, 83, 123, 14);
		contentPane.add(lblCodigoDoPaciente);
		
		JLabel lblNumeroDoInternamento = new JLabel("Numero do Internamento");
		lblNumeroDoInternamento.setBounds(169, 83, 135, 14);
		contentPane.add(lblNumeroDoInternamento);
		
		
		
		textFieldCodIntern = new JTextField();
		textFieldCodIntern.setBounds(169, 104, 135, 20);
		contentPane.add(textFieldCodIntern);
		textFieldCodIntern.setColumns(10);
		
//		
//		MaskFormatter mascaraData = null;
//		try {
//			mascaraData = new MaskFormatter("####-##-##");
//			mascaraData.setPlaceholderCharacter('_');
//
//		} catch (ParseException e1) {
//			JOptionPane.showMessageDialog(null, "Digite uma data válido!" + e1.getMessage(), "ERROR", 0);
//		}
//		JFormattedTextField textFieldDataBaixa = new JFormattedTextField(mascaraData);
//		textFieldDataBaixa.setBounds(10, 169, 123, 20);
//		contentPane.add(textFieldDataBaixa);
		
		textFieldDataBaixa = new JTextField();
		textFieldDataBaixa.setBounds(10, 169, 103, 20);
		contentPane.add(textFieldDataBaixa);
		textFieldDataBaixa.setColumns(10);
		
//		MaskFormatter mascaraData1 = null;
//		try {
//			mascaraData1 = new MaskFormatter("####-##-##");
//			mascaraData1.setPlaceholderCharacter('_');
//
//		} catch (ParseException e1) {
//			JOptionPane.showMessageDialog(null, "Digite uma data válido!" + e1.getMessage(), "ERROR", 0);
//		}
//		JFormattedTextField textFieldDataAlta = new JFormattedTextField(mascaraData1);
//		textFieldDataAlta.setBounds(169, 169, 118, 20);
//		contentPane.add(textFieldDataAlta);
		
		textFieldDataAlta = new JTextField();
		textFieldDataAlta.setBounds(169, 169, 118, 20);
		contentPane.add(textFieldDataAlta);
		textFieldDataAlta.setColumns(10);

		textFieldNumLeito = new JTextField();
		textFieldNumLeito.setBounds(335, 104, 118, 20);
		contentPane.add(textFieldNumLeito);
		textFieldNumLeito.setColumns(10);
		
		JLabel lblNumeroDoLeito = new JLabel("Numero do Leito");
		lblNumeroDoLeito.setBounds(335, 83, 89, 14);
		contentPane.add(lblNumeroDoLeito);
		
		JLabel lblDataBaixa = new JLabel("Data Baixa");
		lblDataBaixa.setBounds(10, 155, 82, 14);
		contentPane.add(lblDataBaixa);
		
		JLabel lblDaataAlta = new JLabel("Data Alta");
		lblDaataAlta.setBounds(169, 155, 82, 14);
		contentPane.add(lblDaataAlta);
	}
}
