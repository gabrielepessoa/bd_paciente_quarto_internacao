package gui.leitoGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import persistencia.LeitoControl;

public class LeitoCadastroGUI extends JFrame {

	private JPanel contentPane;

	LeitoControl leitoControl = new LeitoControl();
	private JTextField textFieldNumLeito;
	private JTextField textFieldNumQuarto;
	private JTextField textFieldTipoLeito;

	/**
	 * Create the frame.
	 */
	public LeitoCadastroGUI() {
		setTitle("Cadastro de Leito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numeroLeito = Integer.parseInt(textFieldNumLeito.getText());
				int numeroQuarto = Integer.parseInt(textFieldNumQuarto
						.getText());
				String tipoLeito = textFieldTipoLeito.getText();
				leitoControl.insereDados(numeroLeito, numeroQuarto, tipoLeito);
				LeitoGUI lg = new LeitoGUI();
				lg.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(356, 219, 97, 23);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeitoGUI l = new LeitoGUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(24, 219, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldTipoLeito.setText("");
				textFieldNumLeito.setText("");
				textFieldNumQuarto.setText("");
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
		lblTipoDeLeito.setBounds(24, 157, 115, 14);
		contentPane.add(lblTipoDeLeito);

		textFieldTipoLeito = new JTextField();
		textFieldTipoLeito.setBounds(24, 172, 128, 20);
		contentPane.add(textFieldTipoLeito);
		textFieldTipoLeito.setColumns(10);
	}

}
