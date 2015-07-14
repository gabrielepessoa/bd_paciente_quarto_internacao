package animal.gui.consultar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import animal.dominio.Animal;
import animal.gui.AnimalGUI;

public class ConsultarAnimalGUI extends JFrame {
	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;
	protected JPanel				contentPane;
	protected JTextField			textFieldNome;
	protected JTextField			textFieldRGA;
	protected JTextField			texTemperamento;
	protected JTextField			textObservacao;
	protected Animal				animal;
	protected JComboBox < String>	comboBoxCastrado;
	protected JComboBox < String>	comboBoxTipo;
	protected JComboBox < String>	comboBoxGenero;
	protected JComboBox < String>	comboBoxDeficiencia;
	protected JFormattedTextField	formattedTextFieldDataResgate;
	protected JComboBox < String>	comboBoxVacinado;
	protected JFormattedTextField	formattedTextFieldTamanho;
	protected JFormattedTextField	formattedTextFieldPeso;
	protected JFormattedTextField	formattedTextFieldDataNascimento;
	
	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public ConsultarAnimalGUI() throws SQLException{
		setTitle("Cadastro de Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeAnimais = new JLabel("Cadastro de Animal\r\n");
		lblCadastroDeAnimais.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroDeAnimais.setBounds(10, 30, 179, 14);
		contentPane.add(lblCadastroDeAnimais);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNome.setBounds(10, 79, 46, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(76, 77, 289, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblRga = new JLabel("RGA: ");
		lblRga.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRga.setBounds(375, 79, 38, 14);
		contentPane.add(lblRga);
		
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 122, 46, 14);
		lblTipo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		contentPane.add(lblTipo);
		
		textFieldRGA = new JTextField();
		textFieldRGA.setEditable(false);
		textFieldRGA.setBounds(419, 77, 200, 20);
		contentPane.add(textFieldRGA);
		textFieldRGA.setColumns(10);
		
		comboBoxTipo = new JComboBox < String>();
		comboBoxTipo.setEnabled(false);
		comboBoxTipo.setModel(new DefaultComboBoxModel < String>(new String[] { "", "Gato",
				"Cachorro" }));
		comboBoxTipo.setToolTipText("");
		comboBoxTipo.setBounds(76, 119, 110, 20);
		contentPane.add(comboBoxTipo);
		
		JLabel lblNewLabel = new JLabel("Data de Nascimento: ");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNewLabel.setBounds(212, 207, 126, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGnero = new JLabel("G\u00EAnero: ");
		lblGnero.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblGnero.setBounds(463, 121, 55, 14);
		contentPane.add(lblGnero);
		
		comboBoxGenero = new JComboBox < String>();
		comboBoxGenero.setEnabled(false);
		comboBoxGenero.setModel(new DefaultComboBoxModel < String>(new String[] { "", "Macho",
				"F\u00EAmea" }));
		comboBoxGenero.setBounds(541, 119, 78, 20);
		contentPane.add(comboBoxGenero);
		
		JLabel lblDeficiencia = new JLabel("Deficiencia: ");
		lblDeficiencia.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblDeficiencia.setBounds(212, 162, 69, 14);
		contentPane.add(lblDeficiencia);
		
		comboBoxDeficiencia = new JComboBox < String>();
		comboBoxDeficiencia.setEnabled(false);
		comboBoxDeficiencia.setModel(new DefaultComboBoxModel < String>(new String[] { "",
				"Nenhuma", "Auditiva", "Fisica", "Mental", "Visual" }));
		comboBoxDeficiencia.setBounds(281, 160, 149, 20);
		contentPane.add(comboBoxDeficiencia);
		
		JLabel lblVacinadoa = new JLabel("Vacinado(a):");
		lblVacinadoa.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblVacinadoa.setBounds(463, 162, 78, 14);
		contentPane.add(lblVacinadoa);
		
		comboBoxVacinado = new JComboBox < String>();
		comboBoxVacinado.setEnabled(false);
		comboBoxVacinado.setModel(new DefaultComboBoxModel < String>(new String[] { "", "Sim",
				"N\u00E3o" }));
		comboBoxVacinado.setBounds(541, 160, 78, 20);
		contentPane.add(comboBoxVacinado);
		
		JLabel lblCastrado = new JLabel("Castrado: ");
		lblCastrado.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCastrado.setBounds(10, 162, 69, 14);
		contentPane.add(lblCastrado);
		
		comboBoxCastrado = new JComboBox < String>();
		comboBoxCastrado.setEnabled(false);
		comboBoxCastrado.setModel(new DefaultComboBoxModel < String>(new String[] { "", "Sim",
				"N\u00E3o" }));
		comboBoxCastrado.setBounds(76, 160, 110, 20);
		contentPane.add(comboBoxCastrado);
		
		JLabel lblTamanho = new JLabel("Tamanho: ");
		lblTamanho.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTamanho.setBounds(10, 207, 69, 14);
		contentPane.add(lblTamanho);
		
		MaskFormatter mascaraDataNascimento = null;
		try {
			mascaraDataNascimento = new MaskFormatter("##/####");
			mascaraDataNascimento.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		formattedTextFieldDataNascimento = new JFormattedTextField(
				mascaraDataNascimento);
		formattedTextFieldDataNascimento.setEditable(false);
		formattedTextFieldDataNascimento.setBounds(350, 205, 63, 20);
		contentPane.add(formattedTextFieldDataNascimento);
		
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblPeso.setBounds(469, 207, 38, 14);
		contentPane.add(lblPeso);
		
		MaskFormatter mascaraPeso = null;
		try {
			mascaraPeso = new MaskFormatter("##.##");
			mascaraDataNascimento.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		formattedTextFieldPeso = new JFormattedTextField(mascaraPeso);
		formattedTextFieldPeso.setEditable(false);
		formattedTextFieldPeso.setBounds(508, 205, 63, 20);
		contentPane.add(formattedTextFieldPeso);
		
		JLabel lblKg = new JLabel("Quilos");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblKg.setBounds(581, 208, 38, 14);
		contentPane.add(lblKg);
		
		JLabel lblM = new JLabel("Metros");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblM.setBounds(147, 208, 42, 14);
		contentPane.add(lblM);
		
		JLabel lblTemperamento = new JLabel("Temperamento: ");
		lblTemperamento.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTemperamento.setBounds(298, 244, 115, 14);
		contentPane.add(lblTemperamento);
		
		MaskFormatter mascaraTamanho = null;
		try {
			mascaraTamanho = new MaskFormatter("#.##");
			mascaraTamanho.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		formattedTextFieldTamanho = new JFormattedTextField(mascaraTamanho);
		formattedTextFieldTamanho.setEditable(false);
		formattedTextFieldTamanho.setBounds(76, 205, 69, 20);
		contentPane.add(formattedTextFieldTamanho);
		
		JLabel lblResgate = new JLabel("Data de Resgate: ");
		lblResgate.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblResgate.setBounds(10, 240, 110, 20);
		contentPane.add(lblResgate);
		
		MaskFormatter mascaraDataResgate = null;
		try {
			mascaraDataResgate = new MaskFormatter("##/##/####");
			mascaraDataResgate.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		formattedTextFieldDataResgate = new JFormattedTextField(mascaraDataResgate);
		formattedTextFieldDataResgate.setEditable(false);
		formattedTextFieldDataResgate.setBounds(116, 242, 86, 20);
		contentPane.add(formattedTextFieldDataResgate);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es: ");
		lblObservaes.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblObservaes.setBounds(10, 292, 102, 14);
		contentPane.add(lblObservaes);
		
		JLabel lblMesano = new JLabel("Mes/Ano");
		lblMesano.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMesano.setBounds(419, 208, 46, 14);
		contentPane.add(lblMesano);
		
		JLabel lblDiamesano = new JLabel("Dia/Mes/Ano");
		lblDiamesano.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDiamesano.setBounds(212, 245, 69, 14);
		contentPane.add(lblDiamesano);
		
		texTemperamento = new JTextField();
		texTemperamento.setEditable(false);
		texTemperamento.setBounds(421, 242, 198, 20);
		contentPane.add(texTemperamento);
		texTemperamento.setColumns(10);
		
		textObservacao = new JTextField();
		textObservacao.setEditable(false);
		textObservacao.setBounds(116, 290, 503, 20);
		contentPane.add(textObservacao);
		textObservacao.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimalGUI animalGUI = new AnimalGUI();
				animalGUI.setVisible(true);
				dispose();
			}

		});
		btnCancelar.setBounds(530, 382, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(429, 382, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(324, 382, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnMdia = new JButton("M\u00EDdia");
		btnMdia.setBounds(225, 382, 89, 23);
		contentPane.add(btnMdia);

	}
}
