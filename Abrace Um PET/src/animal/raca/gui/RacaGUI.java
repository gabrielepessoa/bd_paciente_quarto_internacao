package animal.raca.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import animal.raca.gui.cadastro.CadastrarRacaGUI;
import animal.raca.gui.consulta.ConsultaRacaGUI;
import animal.raca.gui.consulta.ConsultaRacaNomeGUI;
import usuario.gui.TelaInicialGUI;

public class RacaGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel	contentPane;

	
	/**
	 * Create the frame.
	 */
	public RacaGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRaca = new JLabel("Ra\u00E7as");
		lblRaca.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblRaca.setBounds(34, 32, 250, 22);
		contentPane.add(lblRaca);
		
		JButton btnVolta = new JButton("Voltar");
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialGUI telaInicial = new TelaInicialGUI();
				telaInicial.setVisible(true);
				dispose();
				
			}
		});
		btnVolta.setBounds(112, 382, 89, 23);
		contentPane.add(btnVolta);
		
		JButton button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarRacaGUI cadastroRaca = new CadastrarRacaGUI();
				cadastroRaca.setVisible(true);
				dispose();
			}
		});
		button.setBounds(34, 104, 167, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.setBounds(34, 230, 167, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Consultar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaRacaNomeGUI consultar = new ConsultaRacaNomeGUI();
				consultar.setVisible(true);
				dispose();
			}
		});
		button_2.setBounds(34, 169, 167, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Excluir");
		button_3.setBounds(34, 299, 167, 23);
		contentPane.add(button_3);
	}
}
