package animal.raca.gui.consulta;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import animal.dominio.Animal;
import animal.gui.consultar.ConsultarAnimalGUI;
import animal.raca.dominio.Raca;
import animal.raca.service.RacaService;
import animal.service.AnimalService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ConsultaRacaNomeGUI extends JFrame {
	private static final long	serialVersionUID	= 1L;
	private JPanel	contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ConsultaRacaNomeGUI(){
		setTitle("Consulta de Ra\u00E7a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultarRaca = new JLabel("Consulta de Raça");
		lblConsultarRaca.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblConsultarRaca.setBounds(28, 62, 193, 14);
		contentPane.add(lblConsultarRaca);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNome.setBounds(28, 202, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(84, 200, 188, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					consultarRacaNome(lblNome);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			public void consultarRacaNome(JLabel lblNome) throws Exception{
				ConsultaRacaGUI consulta = new ConsultaRacaGUI();
				consulta.setVisible(true);
				dispose();
				
				RacaService rs = new RacaService();
				Raca raca = new Raca();
				
				raca = rs.consultarRaca(lblNome.getText());
				
				consulta.textFieldNome.setText(raca.getNome());
				consulta.textFieldOrigem.setText(raca.getOrigem());
				consulta.formattedTextFieldExpectativaDeVida.setText(String.valueOf(raca.getExpectativaVida()));
				consulta.formattedTextFieldTamanhoMaximo.setText(String.valueOf(raca.getTamanhoMax()));
				consulta.formattedTextFieldTamanhoMinimo.setText(String.valueOf(raca.getTamanhoMin()));
				consulta.comboBoxTipo.setSelectedItem(raca.getTipo());
				consulta.editorPane.setText(raca.getTemperamento());
			}
			
		});
		btnConsultar.setBounds(183, 262, 89, 23);
		contentPane.add(btnConsultar);
	}
}
