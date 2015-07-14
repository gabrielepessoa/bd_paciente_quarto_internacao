package sistema.pacienteGUI;

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

import sistema.control.PacienteControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class PacienteCadastroGIU extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodPaciente;
	private JTextField textFieldNome;
	private JTextField textFieldDataNasc;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacienteCadastroGIU frame = new PacienteCadastroGIU();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	PacienteControl pacienteControl=new PacienteControl();
	/**
	 * Create the frame.
	 */
	public PacienteCadastroGIU() {
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDePaciente = new JLabel("Cadastro de Paciente");
		lblCadastroDePaciente.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		lblCadastroDePaciente.setBounds(10, 11, 163, 37);
		contentPane.add(lblCadastroDePaciente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 59, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCodigoPaciente = new JLabel("Codigo Paciente (CPF):");
		lblCodigoPaciente.setBounds(230, 124, 124, 14);
		contentPane.add(lblCodigoPaciente);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 124, 105, 14);
		contentPane.add(lblDataDeNascimento);
		
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###########");
			mascaraCpf.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um CPF válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField textFieldCodPaciente = new JFormattedTextField(mascaraCpf);
		textFieldCodPaciente.setBounds(230, 139, 203, 20);
		contentPane.add(textFieldCodPaciente);
		
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 74, 423, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("####-##-##");
			mascaraData.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite uma data válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField textFieldDataNasc = new JFormattedTextField(mascaraData);
		textFieldDataNasc.setBounds(10, 139, 163, 20);
		contentPane.add(textFieldDataNasc);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codPac= textFieldCodPaciente.getText();
				String dataNasc=textFieldDataNasc.getText();
				String nome=textFieldNome.getText();
				pacienteControl.insereDados(codPac, nome, dataNasc);
				dispose();
			}
		});
		btnCadastrar.setBounds(328, 198, 105, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(10, 198, 105, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldCodPaciente.setText("");
				textFieldDataNasc.setText("");
				textFieldNome.setText("");
			}
		});
		btnLimpar.setBounds(178, 198, 99, 23);
		contentPane.add(btnLimpar);
	}
}
