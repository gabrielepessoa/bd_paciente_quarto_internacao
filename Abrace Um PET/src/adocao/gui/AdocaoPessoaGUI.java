package adocao.gui;

import infraestrutura.gui.ImagensGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuario.gui.TelaInicialGUI;

public class AdocaoPessoaGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel	contentPane;

	/**
	 * Create the frame.
	 */
	public AdocaoPessoaGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdoo = new JLabel("Ado\u00E7\u00E3o ");
		lblAdoo.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAdoo.setBounds(33, 40, 88, 23);
		contentPane.add(lblAdoo);
		
		JButton btnNewButtonPessoaFisica = new JButton("Pessoa Fisica");
		btnNewButtonPessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdocaoPessoaFisicaGUI adocaoPessoaFisicaGUI = new AdocaoPessoaFisicaGUI();
				adocaoPessoaFisicaGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButtonPessoaFisica.setBounds(57, 143, 279, 39);
		contentPane.add(btnNewButtonPessoaFisica);
		
		JButton btnNewButtonPessoaJuridica = new JButton("Pessoa Juridica");
		btnNewButtonPessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdocaoPessoaJuridicaGUI adocaoPessoaJuridica = new AdocaoPessoaJuridicaGUI();
				adocaoPessoaJuridica.setVisible(true);
				dispose();
			}
		});
		btnNewButtonPessoaJuridica.setBounds(57, 237, 279, 39);
		contentPane.add(btnNewButtonPessoaJuridica);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialGUI telaInicialGUI = new TelaInicialGUI();
				telaInicialGUI.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(247, 382, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		ImagensGUI.imagemAdocao(lblNewLabel);
		lblNewLabel.setBounds(373, 105, 224, 311);
		contentPane.add(lblNewLabel);

	}
	
}
