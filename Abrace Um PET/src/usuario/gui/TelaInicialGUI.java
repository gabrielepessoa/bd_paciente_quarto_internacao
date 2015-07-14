package usuario.gui;

import infraestrutura.gui.ImagensGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import adocao.gui.AdocaoPessoaGUI;
import adotante.gui.PessoaGUI;
import animal.gui.AnimalGUI;
import animal.raca.gui.RacaGUI;

public class TelaInicialGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaInicialGUI;

	/**
	 * Create the frame.
	 */
	public TelaInicialGUI() {
		setTitle("Abrace um PET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		telaInicialGUI = new JPanel();
		telaInicialGUI.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaInicialGUI);
		telaInicialGUI.setLayout(null);

		JButton btnLogin = new JButton("Adotante");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaGUI a = new PessoaGUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(193, 359, 89, 23);
		telaInicialGUI.add(btnLogin);

		JButton btnAnimal = new JButton("Animal");
		btnAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimalGUI AnimalGUI = new AnimalGUI();
				AnimalGUI.setVisible(true);
				dispose();
			}
		});
		btnAnimal.setBounds(37, 359, 89, 23);
		telaInicialGUI.add(btnAnimal);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI l = new LoginGUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(503, 359, 89, 23);
		telaInicialGUI.add(btnSair);

		JButton button = new JButton("");
		button.setVerticalAlignment(SwingConstants.BOTTOM);
		button.setToolTipText("CLIQUE AQUI PARA EFETUAR UMA ADOÇÃO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 AdocaoPessoaGUI adocaoPessoaGUI = new AdocaoPessoaGUI();
				 adocaoPessoaGUI.setVisible(true);
				 dispose();
			}
			
		});
		
		ImagensGUI.imagemCadastroUsuario(button);
		button.setBounds(37, 73, 555, 275);
		telaInicialGUI.add(button);
		
		JButton btnRaa = new JButton("Ra\u00E7a");
		btnRaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RacaGUI racaGUI = new RacaGUI();
				racaGUI.setVisible(true);
				dispose();
			}
		});
		btnRaa.setBounds(343, 359, 89, 23);
		telaInicialGUI.add(btnRaa);
		

	}
}
