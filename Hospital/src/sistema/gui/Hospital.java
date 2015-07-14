package sistema.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import sistema.internacaoGUI.InternamentoGUI;
import sistema.leitoGUI.LeitoGUI;
import sistema.pacienteGUI.PacienteGUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Hospital extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hospital frame = new Hospital();
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
	public Hospital() {
		setTitle("Hospital");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPaciente = new JButton("Paciente");
		btnPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteGUI pg = new PacienteGUI();
				pg.setVisible(true);
				dispose();
			}
		});
		btnPaciente.setBounds(56, 336, 153, 23);
		contentPane.add(btnPaciente);
		
		JButton btnLeito = new JButton("Leito");
		btnLeito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LeitoGUI lg = new LeitoGUI();
				lg.setVisible(true);
				dispose();
			}
		});
		btnLeito.setBounds(235, 336, 153, 23);
		contentPane.add(btnLeito);
		
		JButton btnInternamento = new JButton("");
		btnInternamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InternamentoGUI ig = new InternamentoGUI();
				ig.setVisible(true);
				dispose();
			}
		});
		ImagensGUI.imagemButton(btnInternamento);
		btnInternamento.setBounds(56, 22, 332, 285);
		contentPane.add(btnInternamento);
		
		JLabel lblInternamento = DefaultComponentFactory.getInstance().createTitle("*Para internamento clique na imagem");
		lblInternamento.setForeground(Color.RED);
		lblInternamento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblInternamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblInternamento.setBounds(-49, 364, 272, 14);
		contentPane.add(lblInternamento);
	}
}
