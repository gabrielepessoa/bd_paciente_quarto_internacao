package animal.gui.consultar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import animal.dominio.Animal;
import animal.service.AnimalService;

public class ConsultarAnimalRGAFGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel	contentPane;
	protected JTextField textFieldRGA;

	/**
	 * Create the frame.
	 */
	public ConsultarAnimalRGAFGUI(){
		setTitle("Consulta de Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblConsultarAnimal = new JLabel("Consulta de Animal");
		lblConsultarAnimal.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblConsultarAnimal.setBounds(28, 62, 193, 14);
		contentPane.add(lblConsultarAnimal);
		
		
		JLabel lblRga = new JLabel("RGA: ");
		lblRga.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRga.setBounds(28, 202, 46, 14);
		contentPane.add(lblRga);
		
		textFieldRGA = new JTextField();
		textFieldRGA.setBounds(84, 200, 188, 20);
		contentPane.add(textFieldRGA);
		textFieldRGA.setColumns(10);
		
		JButton btnConsultarRGA = new JButton("Consultar");
		btnConsultarRGA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					consultarAnimalRGA(textFieldRGA);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			public void consultarAnimalRGA(JTextField textFieldRGA) throws SQLException{
				ConsultarAnimalGUI consulta = new ConsultarAnimalGUI();
				consulta.setVisible(true);
				dispose();
				
				AnimalService as = new AnimalService();
				Animal animal = new Animal();
			
				animal = as.consultarAnimal(textFieldRGA.getText());
				
				consulta.textFieldNome.setText(animal.getNome());
				consulta.textFieldRGA.setText(animal.getRga());
				consulta.texTemperamento.setText(animal.getTemperamento());
				consulta.textObservacao.setText(animal.getObservacao());
				consulta.formattedTextFieldDataNascimento.setText(animal.getDataNascimento());
				consulta.formattedTextFieldDataResgate.setText(animal.getDataResgate());
				consulta.formattedTextFieldPeso.setText(String.valueOf(animal.getPeso()));
				consulta.formattedTextFieldTamanho.setText(String.valueOf(animal.getTamanho()));
				consulta.comboBoxCastrado.setSelectedItem(animal.getCastrado());
				consulta.comboBoxDeficiencia.setSelectedItem(animal.getDeficiencia());
				consulta.comboBoxGenero.setSelectedItem(animal.getGenero());
				consulta.comboBoxTipo.setSelectedItem(animal.getTipo());
				consulta.comboBoxVacinado.setSelectedItem(animal.getVacinado());
				
			}
		});
		btnConsultarRGA.setBounds(183, 263, 89, 23);
		contentPane.add(btnConsultarRGA);
	}
}
