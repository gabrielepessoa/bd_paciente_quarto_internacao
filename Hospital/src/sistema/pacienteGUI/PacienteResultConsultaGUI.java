package sistema.pacienteGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import base.Paciente;
import sistema.control.PacienteControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PacienteResultConsultaGUI extends JFrame {

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
					PacienteResultConsultaGUI frame = new PacienteResultConsultaGUI();
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
	
	PacienteControl pc=new PacienteControl();
	Paciente paciente = new Paciente();
	PacienteGUI pg = new PacienteGUI();
	
	public PacienteResultConsultaGUI() {
		setTitle("Resultado da Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 59, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCodigoPaciente = new JLabel("Codigo Paciente (CPF):");
		lblCodigoPaciente.setBounds(222, 124, 124, 14);
		contentPane.add(lblCodigoPaciente);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 124, 105, 14);
		contentPane.add(lblDataDeNascimento);
		
		textFieldCodPaciente = new JTextField();
		textFieldCodPaciente.setEditable(false);
		textFieldCodPaciente.setBounds(222, 139, 203, 20);
		contentPane.add(textFieldCodPaciente);
		textFieldCodPaciente.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(10, 74, 415, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldDataNasc = new JTextField();
		textFieldDataNasc.setEditable(false);
		textFieldDataNasc.setBounds(10, 139, 144, 20);
		contentPane.add(textFieldDataNasc);
		textFieldDataNasc.setColumns(10);
		
		resultadoConsulta();
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteGUI pg = new PacienteGUI();
				pg.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(283, 216, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCodPaciente.setEditable(true);
				textFieldDataNasc.setEditable(true);
				textFieldNome.setEditable(true);
				btnEditar.setVisible(false);
				
				JButton btnSubmeter = new JButton("Submeter");
				btnSubmeter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pc.AtualizarDados(textFieldCodPaciente.getText(),
								textFieldNome.getText(), textFieldDataNasc.getText());
						dispose();
					}});
				btnSubmeter.setBounds(184, 216, 89, 23);
				contentPane.add(btnSubmeter);
				
			}
		});
		btnEditar.setBounds(184, 216, 89, 23);
		contentPane.add(btnEditar);
	}

	private void resultadoConsulta() {
		String codPac=JOptionPane.showInputDialog(null, "Digite o CPF do paciente");
		pc.BuscarDados(codPac, paciente);
		textFieldCodPaciente.setText(paciente.getCodPac());
		textFieldDataNasc.setText(paciente.getDataNascimento().toString());
		textFieldNome.setText(paciente.getNomePac());
	}
}
