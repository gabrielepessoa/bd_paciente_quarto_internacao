package gui.internamentoGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import persistencia.InternamentoControl;
import persistencia.PacienteControl;
import dominio.Internamento;

public class InternamentoResultConsultaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDataBaixa;
	private JTextField textFieldCpf;
	private JTextField textFieldNumLeito;

	
	PacienteControl pacienteControl = new PacienteControl();
	InternamentoControl ic = new InternamentoControl();
	Internamento internamento = new Internamento();
	
	
	private JTextField textFieldDataAlta;
	private JTextField textFieldNumInternamento;

	private void resultadoInternamento() {
		String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do paciente com apenas n�meros:");
		int numInternamento = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Digite o n�mero do internamento com apenas n�meros:"));
		
		ic.BuscarDadosResultInternamento(cpf, numInternamento, internamento);
		textFieldCpf.setText(internamento.getCpf());
		textFieldNumInternamento.setText(Integer.toString(internamento.getNumInternamento()));
		textFieldDataBaixa.setText(internamento.getDataBaixa().toString());
		textFieldDataAlta.setText(internamento.getDataAlta().toString());
		textFieldNumLeito.setText(Integer.toString(internamento.getNumLeito()));
	}

	public InternamentoResultConsultaGUI() {
		setTitle("Resultado da Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 59, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblDataBaixa = new JLabel("Data de baixa:");
		lblDataBaixa.setBounds(222, 196, 176, 14);
		contentPane.add(lblDataBaixa);

		JLabel lblNumLeito = new JLabel("N\u00FAmero do leito:");
		lblNumLeito.setBounds(10, 123, 160, 14);
		contentPane.add(lblNumLeito);

		textFieldDataBaixa = new JTextField();
		textFieldDataBaixa.setEditable(false);
		textFieldDataBaixa.setBounds(222, 211, 203, 20);
		contentPane.add(textFieldDataBaixa);
		textFieldDataBaixa.setColumns(10);

		textFieldDataAlta = new JTextField();
		textFieldDataAlta.setText("data");
		textFieldDataAlta.setEditable(false);
		textFieldDataAlta.setColumns(10);
		textFieldDataAlta.setBounds(10, 211, 202, 20);
		contentPane.add(textFieldDataAlta);

		JLabel labelNumInternamento = new JLabel("N\u00FAmero do Internamento:");
		labelNumInternamento.setBounds(222, 123, 160, 14);
		contentPane.add(labelNumInternamento);

		textFieldNumInternamento = new JTextField();
		textFieldNumInternamento.setText("0");
		textFieldNumInternamento.setEditable(false);
		textFieldNumInternamento.setColumns(10);
		textFieldNumInternamento.setBounds(223, 139, 202, 20);
		contentPane.add(textFieldNumInternamento);

		textFieldCpf = new JTextField();
		textFieldCpf.setEditable(false);
		textFieldCpf.setBounds(10, 74, 415, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);

		textFieldNumLeito = new JTextField();
		textFieldNumLeito.setEditable(false);
		textFieldNumLeito.setBounds(10, 139, 202, 20);
		contentPane.add(textFieldNumLeito);
		textFieldNumLeito.setColumns(10);

		resultadoInternamento();

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InternamentoGUI ig = new InternamentoGUI();
				ig.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(283, 282, 115, 23);
		contentPane.add(btnVoltar);

		final JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDataAlta.setEditable(true);
				textFieldDataBaixa.setEditable(true);
				btnEditar.setVisible(false);

				JLabel lblCamposNoEditaveis = new JLabel("Campos n\u00E3o edit\u00E1veis.");
				lblCamposNoEditaveis.setForeground(Color.RED);
				lblCamposNoEditaveis.setBounds(10, 242, 388, 14);
				contentPane.add(lblCamposNoEditaveis);
				
				JButton btnSubmeter = new JButton("Submeter");
				btnSubmeter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ic.AtualizarDados(textFieldCpf.getText(), Integer.parseInt(textFieldNumInternamento.getText()), 
								textFieldDataBaixa.getText(), textFieldDataAlta.getText(), 
								Integer.parseInt(textFieldNumLeito.getText()));
						InternamentoGUI ig = new InternamentoGUI();
						ig.setVisible(true);
						dispose();
						
					}
				});
				btnSubmeter.setBounds(164, 282, 113, 23);
				contentPane.add(btnSubmeter);

			}
		});
		btnEditar.setBounds(164, 282, 113, 23);
		contentPane.add(btnEditar);
		
		JLabel lblDataAlta = new JLabel("Data de alta:");
		lblDataAlta.setBounds(10, 196, 176, 14);
		contentPane.add(lblDataAlta);
		
		

	}
}
