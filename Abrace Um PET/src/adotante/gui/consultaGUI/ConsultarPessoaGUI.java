package adotante.gui.consultaGUI;

import infraestrutura.gui.ImagensGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adotante.gui.PessoaGUI;

public class ConsultarPessoaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarPessoaGUI frame = new ConsultarPessoaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultarPessoaGUI() {
		setTitle("Abrace um PET - Consulta de Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnPessoaFsica = new JButton("Pessoa F\u00EDsica");
		btnPessoaFsica.setBounds(61, 154, 279, 39);
		btnPessoaFsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarAdotanteFisicoCPFGUI consulta = new ConsultarAdotanteFisicoCPFGUI();
				consulta.setVisible(true);
				dispose();
			}
		});

		JButton btnPessoaJurdica = new JButton("Pessoa Jur\u00EDdica");
		btnPessoaJurdica.setBounds(61, 222, 279, 39);
		btnPessoaJurdica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaPessoaJuridicaCNPJGUI consultaCNPJGUI = new ConsultaPessoaJuridicaCNPJGUI();
				consultaCNPJGUI.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnPessoaJurdica);
		contentPane.add(btnPessoaFsica);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaGUI adotante = new PessoaGUI();
				adotante.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(251, 382, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblConsultsDeUsurio = new JLabel("Consulta de Adotante");
		lblConsultsDeUsurio.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblConsultsDeUsurio.setBounds(44, 37, 214, 39);
		contentPane.add(lblConsultsDeUsurio);

		JLabel label = new JLabel("");
		ImagensGUI.imagemCadastroAdotante(label);
		
		label.setBounds(385, 180, 244, 236);
		contentPane.add(label);
	}

}
