package usuario.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class SobreGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SobreGUI() {
		setTitle("Abrace um PET - Sobre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(489, 360, 89, 23);
		contentPane.add(btnVoltar);

		JTextPane txtpnEsseSoftware = new JTextPane();
		txtpnEsseSoftware.setBackground(SystemColor.menu);
		txtpnEsseSoftware.setEditable(false);
		txtpnEsseSoftware.setForeground(Color.BLACK);
		txtpnEsseSoftware.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		txtpnEsseSoftware
				.setText("Esse software \u00E9 um projeto para a disciplina de Modelagem e Programa\u00E7\u00E3o Orientada \u00E0 Objetos dirigida pelo professor Gabriel Alves.\r\n\r\nA ideia desse software surgiu quando constatamos que muitos projeto de ado\u00E7\u00E3o de animais ainda est\u00E3o fazendo todo o procedimento para garantir a ado\u00E7\u00E3o de forma manual deixando dados t\u00E3o importantes vulner\u00E1veis. Ent\u00E3o, por que n\u00E3o automatizar esse processo o tornando mais \u00E1gil e seguro?\r\n\r\nSomo alunos da Universidade Federal Rural de Pernambuco, nossa equipe \u00E9 formada por:\r\n\r\n - Gabriele Pessoa\r\n - Lisandra Cruz\r\n - Paulo Roberto\r\n - Rodolfo Bispo    ");
		txtpnEsseSoftware.setBounds(70, 73, 508, 260);
		contentPane.add(txtpnEsseSoftware);

		JLabel lblSobre = new JLabel("Sobre:");
		lblSobre.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblSobre.setBounds(70, 42, 70, 14);
		contentPane.add(lblSobre);
	}
}
