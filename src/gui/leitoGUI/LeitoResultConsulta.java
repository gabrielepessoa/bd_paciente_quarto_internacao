package gui.leitoGUI;

import java.awt.Color;
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

import persistencia.LeitoControl;
import dominio.Leito;

public class LeitoResultConsulta extends JFrame {

	private JPanel contentPane;

	LeitoControl leitoControl = new LeitoControl();
	Leito leito = new Leito();

	private JTextField textFieldNumLeito;
	private JTextField textFieldNumQuarto;
	private JTextField textFieldTipoLeito;

	/**
	 * Create the frame.
	 */
	public LeitoResultConsulta() {
		setTitle("Consulta de Leito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNumLeito = new JTextField();
		textFieldNumLeito.setEditable(false);
		textFieldNumLeito.setBounds(45, 74, 128, 20);
		contentPane.add(textFieldNumLeito);
		textFieldNumLeito.setColumns(10);

		JLabel lblNumLeito = new JLabel("Numero de Leito:");
		lblNumLeito.setBounds(45, 59, 97, 14);
		contentPane.add(lblNumLeito);

		JLabel lblNumQuarto = new JLabel("Numero de Quarto:");
		lblNumQuarto.setBounds(259, 60, 115, 14);
		contentPane.add(lblNumQuarto);

		textFieldNumQuarto = new JTextField();
		textFieldNumQuarto.setEditable(false);
		textFieldNumQuarto.setBounds(259, 74, 128, 20);
		contentPane.add(textFieldNumQuarto);
		textFieldNumQuarto.setColumns(10);

		JLabel lblTipoLeito = new JLabel("Tipo de Leito:");
		lblTipoLeito.setBounds(45, 115, 115, 14);
		contentPane.add(lblTipoLeito);

		textFieldTipoLeito = new JTextField();
		textFieldTipoLeito.setEditable(false);
		textFieldTipoLeito.setBounds(45, 128, 128, 20);
		contentPane.add(textFieldTipoLeito);
		textFieldTipoLeito.setColumns(10);

		resultadoConsulta();

		final JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNumQuarto.setEditable(true);
				textFieldTipoLeito.setEditable(true);
				btnEditar.setVisible(false);

				JLabel lblCamposNoEditaveis = new JLabel(
						"Campos n\u00E3o edit\u00E1veis.");
				lblCamposNoEditaveis.setForeground(Color.RED);
				lblCamposNoEditaveis.setBounds(45, 159, 408, 14);
				contentPane.add(lblCamposNoEditaveis);

				JButton btnSubmeter = new JButton("Submeter");
				btnSubmeter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						leitoControl.AtualizarDados(
								Integer.parseInt(textFieldNumLeito.getText()),
								Integer.parseInt(textFieldNumQuarto.getText()),
								textFieldTipoLeito.getText());
						LeitoGUI lg = new LeitoGUI();
						lg.setVisible(true);
						dispose();
					}
				});
				btnSubmeter.setBounds(184, 216, 100, 23);
				contentPane.add(btnSubmeter);

			}
		});
		btnEditar.setBounds(184, 216, 100, 23);
		contentPane.add(btnEditar);

		JButton btn_voltar = new JButton("Voltar");
		btn_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LeitoGUI lg = new LeitoGUI();
				lg.setVisible(true);
				dispose();
			}
		});
		btn_voltar.setBounds(298, 216, 89, 23);
		contentPane.add(btn_voltar);
		
	}

	private void resultadoConsulta() {
		int numLeito = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Digite o número do leito"));
		leitoControl.BuscarDados(numLeito, leito);
		textFieldNumLeito.setText(Integer.toString(leito.getNumLeito()));
		textFieldNumQuarto.setText(Integer.toString(leito.getNumQuarto()));
		textFieldTipoLeito.setText(leito.getTipoLeito());
	}

}
