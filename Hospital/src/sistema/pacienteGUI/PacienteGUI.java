package sistema.pacienteGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import base.Paciente;
import sistema.control.PacienteControl; 
import sistema.gui.Hospital;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PacienteGUI extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacienteGUI frame = new PacienteGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	PacienteControl pc=new PacienteControl();
	Paciente paciente = new Paciente();
	
	public PacienteGUI() {
		setTitle("Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteCadastroGIU pcg = new PacienteCadastroGIU();
				pcg.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(158, 73, 166, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteResultConsultaGUI prc= new PacienteResultConsultaGUI();
				prc.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(159, 158, 165, 23);
		contentPane.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String codPac= JOptionPane.showInputDialog(null, "Digite o CPF do paciente");
				 pc.ExcluirCliente(codPac);
			}
		});
		btnExcluir.setBounds(158, 244, 165, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hospital h = new Hospital();
				h.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(364, 344, 89, 23);
		contentPane.add(btnVoltar);
	}

}
