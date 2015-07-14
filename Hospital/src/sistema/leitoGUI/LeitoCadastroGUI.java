package sistema.leitoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ComboBoxEditor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import sistema.control.LeitoControl;
import sistema.control.PacienteControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LeitoCadastroGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LeitoCadastroGUI frame = new LeitoCadastroGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	LeitoControl leitoControl=new LeitoControl();
	private JTextField textFieldNumLeito;
	private JTextField textFieldNumQuarto;
	private JTextField textFieldTipoLeito;
	/**
	 * Create the frame.
	 */
	public LeitoCadastroGUI() {
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDePaciente = new JLabel("Cadastro de Leito");
		lblCadastroDePaciente.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		lblCadastroDePaciente.setBounds(10, 11, 163, 37);
		contentPane.add(lblCadastroDePaciente);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numeroLeito=Integer.parseInt(textFieldNumLeito.getText());
				int numeroQuarto=Integer.parseInt(textFieldNumQuarto.getText());
				String tipoLeito= textFieldTipoLeito.getText();
				leitoControl.insereDados(numeroLeito, numeroQuarto, tipoLeito);
				dispose();
			}
		});
		btnCadastrar.setBounds(356, 219, 97, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(24, 219, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldTipoLeito.setText("");
				textFieldNumLeito.setText("");
				textFieldTipoLeito.setText("");
			}
		});
		btnLimpar.setBounds(198, 219, 89, 23);
		contentPane.add(btnLimpar);
		
		textFieldNumLeito = new JTextField();
		textFieldNumLeito.setBounds(24, 116, 128, 20);
		contentPane.add(textFieldNumLeito);
		textFieldNumLeito.setColumns(10);
		
		JLabel lblNumeroDeLeito = new JLabel("Numero de Leito:");
		lblNumeroDeLeito.setBounds(24, 101, 97, 14);
		contentPane.add(lblNumeroDeLeito);
		
		JLabel lblNumeroDo = new JLabel("Numero de Quarto:");
		lblNumeroDo.setBounds(197, 102, 115, 14);
		contentPane.add(lblNumeroDo);
		
		textFieldNumQuarto = new JTextField();
		textFieldNumQuarto.setBounds(197, 116, 128, 20);
		contentPane.add(textFieldNumQuarto);
		textFieldNumQuarto.setColumns(10);
		
		JLabel lblTipoDeLeito = new JLabel("Tipo de Leito:");
		lblTipoDeLeito.setBounds(24, 159, 115, 14);
		contentPane.add(lblTipoDeLeito);
		
		textFieldTipoLeito = new JTextField();
		textFieldTipoLeito.setBounds(24, 172, 128, 20);
		contentPane.add(textFieldTipoLeito);
		textFieldTipoLeito.setColumns(10);
	}
		
}
