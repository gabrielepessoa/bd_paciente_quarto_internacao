package sistema.leitoGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sistema.control.LeitoControl;
import base.Leito;

public class LeitoResultConsulta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeitoResultConsulta frame = new LeitoResultConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	LeitoControl leitoControl=new LeitoControl();
	Leito leito = new Leito();
	
	private JTextField textFieldNumLeito;
	private JTextField textFieldNumQuarto;
	private JTextField textFieldTipoLeito;
	/**
	 * Create the frame.
	 */
	public LeitoResultConsulta() {
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDePaciente = new JLabel("Cadastro de Leito");
		lblCadastroDePaciente.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		lblCadastroDePaciente.setBounds(10, 11, 163, 37);
		contentPane.add(lblCadastroDePaciente);
		
		textFieldNumLeito = new JTextField();
		textFieldNumLeito.setEditable(false);
		textFieldNumLeito.setBounds(10, 74, 128, 20);
		contentPane.add(textFieldNumLeito);
		textFieldNumLeito.setColumns(10);
		
		JLabel lblNumeroDeLeito = new JLabel("Numero de Leito:");
		lblNumeroDeLeito.setBounds(10, 59, 97, 14);
		contentPane.add(lblNumeroDeLeito);
		
		JLabel lblNumeroDo = new JLabel("Numero de Quarto:");
		lblNumeroDo.setBounds(183, 60, 115, 14);
		contentPane.add(lblNumeroDo);
		
		textFieldNumQuarto = new JTextField();
		textFieldNumQuarto.setEditable(false);
		textFieldNumQuarto.setBounds(183, 74, 128, 20);
		contentPane.add(textFieldNumQuarto);
		textFieldNumQuarto.setColumns(10);
		
		JLabel lblTipoDeLeito = new JLabel("Tipo de Leito:");
		lblTipoDeLeito.setBounds(10, 117, 115, 14);
		contentPane.add(lblTipoDeLeito);
		
		textFieldTipoLeito = new JTextField();
		textFieldTipoLeito.setEditable(false);
		textFieldTipoLeito.setBounds(10, 130, 128, 20);
		contentPane.add(textFieldTipoLeito);
		textFieldTipoLeito.setColumns(10);
		
		resultadoConsulta();
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNumLeito.setEditable(true);
				textFieldNumQuarto.setEditable(true);
				textFieldTipoLeito.setEditable(true);
				btnEditar.setVisible(false);
				
				JButton btnSubmeter = new JButton("Submeter");
				btnSubmeter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						leitoControl.AtualizarDados(Integer.parseInt(textFieldNumLeito.getText()),
								Integer.parseInt(textFieldNumQuarto.getText()), textFieldTipoLeito.getText());
						LeitoGUI lg=new LeitoGUI();
						lg.setVisible(true);
						dispose();
					}});
				btnSubmeter.setBounds(184, 216, 89, 23);
				contentPane.add(btnSubmeter);
				
			}
		});
		btnEditar.setBounds(184, 216, 89, 23);
		contentPane.add(btnEditar);
		
		JButton button_1 = new JButton("Voltar");
		button_1.setBounds(283, 216, 89, 23);
		contentPane.add(button_1);
	}
	private void resultadoConsulta() {
		int numLeito= Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do leito"));
		leitoControl.BuscarDados(numLeito, leito);
		textFieldNumLeito.setText(Integer.toString(leito.getNumLeito()));
		textFieldNumQuarto.setText(Integer.toString(leito.getNumQuarto()));
		textFieldTipoLeito.setText(leito.getTipoLeito());
	}
	
}