package animal.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import animal.gui.cadastrar.CadastroAnimalGUI;
import animal.gui.consultar.ConsultarAnimalRGAFGUI;
import usuario.gui.LoginGUI;
import usuario.gui.TelaInicialGUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AnimalGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel	contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalGUI frame = new AnimalGUI();
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
	public AnimalGUI(){
		setTitle("Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAnimal.setBounds(49, 57, 129, 14);
		contentPane.add(lblAnimal);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAnimalGUI cadastroAnimalGUI;
				try {
					cadastroAnimalGUI = new CadastroAnimalGUI();
					cadastroAnimalGUI.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCadastrar.setBounds(49, 123,167, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(49, 259, 167, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(49, 323,167, 23);
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarAnimalRGAFGUI consultar = new ConsultarAnimalRGAFGUI();
				consultar.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(49, 191, 167, 23);
		contentPane.add(btnConsultar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialGUI telaInicialGUI = new TelaInicialGUI();
				telaInicialGUI.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(127, 382, 89, 23);
		contentPane.add(btnVoltar);
	}
}
