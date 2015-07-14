package sistema.leitoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import base.Leito;
import base.Paciente;
import sistema.control.LeitoControl;
import sistema.control.PacienteControl; 

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeitoGUI extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeitoGUI frame = new LeitoGUI();
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
	
	LeitoControl lc = new LeitoControl();
	Leito l = new Leito();
	
	public LeitoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeitoCadastroGUI lcg = new LeitoCadastroGUI();
				lcg.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(159, 55, 115, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeitoResultConsulta lrc=new LeitoResultConsulta();
				lrc.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(159, 115, 115, 23);
		contentPane.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int numLeito= Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do leito: "));
				 lc.ExcluirLeito(numLeito);
			}
		});
		btnExcluir.setBounds(159, 176, 115, 23);
		contentPane.add(btnExcluir);
	}

}
