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
import sistema.gui.Hospital;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeitoGUI extends JFrame {

	private JPanel contentPane;

	
	LeitoControl lc = new LeitoControl();
	Leito l = new Leito();
	
	public LeitoGUI() {
		setTitle("Leito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
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
		btnCadastrar.setBounds(158, 73, 177, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeitoResultConsulta lrc=new LeitoResultConsulta();
				lrc.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(158, 138, 177, 23);
		contentPane.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int numLeito= Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do leito: "));
				 lc.ExcluirLeito(numLeito);
			}
		});
		btnExcluir.setBounds(158, 202, 176, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hospital h = new Hospital();
				h.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(364, 344, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnNewButtonLeitosCadastrados = new JButton("Leitos Cadastrados");
		btnNewButtonLeitosCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LeitoListagemGUI ll=new LeitoListagemGUI();
				ll.setVisible(true);
				dispose();
			}
		});
		btnNewButtonLeitosCadastrados.setBounds(157, 266, 178, 23);
		contentPane.add(btnNewButtonLeitosCadastrados);
	}
}
