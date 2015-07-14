package adotante.gui;

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

import usuario.gui.TelaInicialGUI;
import adotante.gui.cadastroGUI.CadastroPessoaGUI;
import adotante.gui.consultaGUI.ConsultarPessoaGUI;
import javax.swing.ImageIcon;

public class PessoaGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PessoaGUI frame = new PessoaGUI();
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
	public PessoaGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPessoaGUI ca = new CadastroPessoaGUI();
				ca.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(79, 120, 167, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPessoaGUI consultarPessoa = new ConsultarPessoaGUI();
				consultarPessoa.setVisible(true);
				dispose();
				
			}
		});
		btnConsultar.setBounds(79, 180, 167, 23);
		contentPane.add(btnConsultar);
		btnEditar.setBounds(79, 246, 167, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(79, 305, 167, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialGUI ti = new TelaInicialGUI();
				ti.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(157, 382, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblAdotante = new JLabel("Adotante");
		lblAdotante.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAdotante.setBounds(51, 45, 95, 14);
		contentPane.add(lblAdotante);
		
		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon(
//				"C:\\Users\\Lisandra Cruz\\Desktop\\Nova pasta\\imagens\\nononon.png"));
		ImagensGUI.imagemPessoa(label);
		
		label.setBounds(256, 11, 363, 394);
		contentPane.add(label);
		
	}
}
