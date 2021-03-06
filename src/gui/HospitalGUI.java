package gui;

import gui.internamentoGUI.InternamentoGUI;
import gui.leitoGUI.LeitoGUI;
import gui.pacienteGUI.PacienteGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HospitalGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public HospitalGUI() {
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

		JLabel lblInternamento = new JLabel(
				"*Para internamento clique na imagem");
		lblInternamento.setForeground(Color.RED);
		lblInternamento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblInternamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblInternamento.setBounds(-49, 364, 272, 14);
		contentPane.add(lblInternamento);
	}
}
