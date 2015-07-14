package sistema.internacaoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import sistema.control.InternacaoControl;
import sistema.control.PacienteControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InternacaoCadastroGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternacaoCadastroGUI frame = new InternacaoCadastroGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				int codPac = Integer.parseInt(textFieldCodPac.getText());
				int numeroIntern = Integer.parseInt(textFieldCodIntern.getText());
				int numLeito = Integer.parseInt(textFieldNumLeito.getText());
				String dataBaixa = textFieldDataBaixa.getText();
				String dataAlta = textFieldDataAlta.getText();
				ic.insereDados(codPac, numeroIntern, dataBaixa, dataAlta, numLeito);
				dispose();
			}
		});
		btnCadastrar.setBounds(283, 198, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(10, 198, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				textFieldCodPaciente.setText("");
//				textFieldDataNasc.setText("");
//				textFieldNome.setText("");
			}
		});
		btnLimpar.setBounds(148, 198, 89, 23);
		contentPane.add(btnLimpar);
		
		textFieldCodPac = new JTextField();
		textFieldCodPac.setBounds(10, 69, 100, 20);
		contentPane.add(textFieldCodPac);
		textFieldCodPac.setColumns(10);
		
		JLabel lblCodigoDoPaciente = new JLabel("Codigo do Paciente");
		lblCodigoDoPaciente.setBounds(10, 48, 106, 14);
		contentPane.add(lblCodigoDoPaciente);
		
		JLabel lblNumeroDoInternamento = new JLabel("Numero do Internamento");
		lblNumeroDoInternamento.setBounds(126, 48, 123, 14);
		contentPane.add(lblNumeroDoInternamento);
		
		textFieldCodIntern = new JTextField();
		textFieldCodIntern.setBounds(131, 69, 118, 20);
		contentPane.add(textFieldCodIntern);
		textFieldCodIntern.setColumns(10);
		
		textFieldDataBaixa = new JTextField();
		textFieldDataBaixa.setBounds(81, 117, 103, 20);
		contentPane.add(textFieldDataBaixa);
		textFieldDataBaixa.setColumns(10);
		
		textFieldDataAlta = new JTextField();
		textFieldDataAlta.setBounds(238, 117, 118, 20);
		contentPane.add(textFieldDataAlta);
		textFieldDataAlta.setColumns(10);
		
		textFieldNumLeito = new JTextField();
		textFieldNumLeito.setBounds(283, 69, 100, 20);
		contentPane.add(textFieldNumLeito);
		textFieldNumLeito.setColumns(10);
		
		JLabel lblNumeroDoLeito = new JLabel("Numero do Leito");
		lblNumeroDoLeito.setBounds(283, 48, 89, 14);
		contentPane.add(lblNumeroDoLeito);
		
		JLabel lblDataBaixa = new JLabel("Data Baixa");
		lblDataBaixa.setBounds(81, 100, 82, 14);
		contentPane.add(lblDataBaixa);
		
		JLabel lblDaataAlta = new JLabel("Data Alta");
		lblDaataAlta.setBounds(238, 100, 82, 14);
		contentPane.add(lblDaataAlta);
	}
}
