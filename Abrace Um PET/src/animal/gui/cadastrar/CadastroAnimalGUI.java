package animal.gui.cadastrar;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import usuario.gui.LoginGUI;
import usuario.gui.TelaInicialGUI;
import animal.dominio.Animal;
import animal.gui.AnimalGUI;
import animal.service.AnimalService;

public class CadastroAnimalGUI extends JFrame {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	private JTextField			textFieldNome;
	private JLabel				lblTipo;
	private JTextField			textFieldRGA;
	private JTextField texTemperamento;
	private JTextField textObservacao;
	private JTextField textImagePath;
	private JLabel lblImagem;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CadastroAnimalGUI() throws SQLException{
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
		textFieldNome.setBounds(76, 77, 289, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		lblTipo = new JLabel("Tipo: ");
		lblTipo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTipo.setBounds(10, 121, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblRga = new JLabel("RGA: ");
		lblRga.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRga.setBounds(375, 79, 38, 14);
		contentPane.add(lblRga);
		
		textFieldRGA = new JTextField();
		textFieldRGA.setBounds(419, 77, 200, 20);
		contentPane.add(textFieldRGA);
		textFieldRGA.setColumns(10);

		
		JComboBox<String> comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Gato", "Cachorro" }));
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
		
		JComboBox<String> comboBoxGenero = new JComboBox<String>();
		comboBoxGenero.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Macho", "F\u00EAmea" }));
		comboBoxGenero.setBounds(541, 119, 78, 20);
		contentPane.add(comboBoxGenero);
		
		JLabel lblDeficiencia = new JLabel("Deficiencia: ");
		lblDeficiencia.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblDeficiencia.setBounds(212, 162, 69, 14);
		contentPane.add(lblDeficiencia);
		
		JComboBox<String> comboBoxDeficiencia = new JComboBox<String>();
		comboBoxDeficiencia.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Nenhuma", "Auditiva", "Fisica", "Mental", "Visual" }));
		comboBoxDeficiencia.setBounds(281, 160, 149, 20);
		contentPane.add(comboBoxDeficiencia);
		
		JLabel lblVacinadoa = new JLabel("Vacinado(a):");
		lblVacinadoa.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblVacinadoa.setBounds(463, 162, 78, 14);
		contentPane.add(lblVacinadoa);
		
		JComboBox<String> comboBoxVacinado = new JComboBox<String>();
		comboBoxVacinado.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Sim", "N\u00E3o" }));
		comboBoxVacinado.setBounds(541, 160, 78, 20);
		contentPane.add(comboBoxVacinado);
		
		JLabel lblCastrado = new JLabel("Castrado: ");
		lblCastrado.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCastrado.setBounds(10, 162, 69, 14);
		contentPane.add(lblCastrado);
		
		JComboBox<String> comboBoxCastrado = new JComboBox<String>();
		comboBoxCastrado.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Sim", "N\u00E3o" }));
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
		JFormattedTextField formattedTextFieldDataNascimento = new JFormattedTextField(mascaraDataNascimento);
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
		JFormattedTextField formattedTextFieldPeso = new JFormattedTextField(mascaraPeso);
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
		JFormattedTextField formattedTextFieldTamanho = new JFormattedTextField(mascaraTamanho);
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
		JFormattedTextField formattedTextFieldDataResgate = new JFormattedTextField(mascaraDataResgate);
		formattedTextFieldDataResgate.setBounds(116, 242, 86, 20);
		contentPane.add(formattedTextFieldDataResgate);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es: ");
		lblObservaes.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblObservaes.setBounds(10, 292, 102, 14);
		contentPane.add(lblObservaes);
		
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(509, 387, 110, 23);
		contentPane.add(btnSair);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimalGUI animalGUI = new AnimalGUI();
				animalGUI.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(389, 387, 110, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AnimalService animalService = new AnimalService();
				Animal animal = new Animal();
	
				animal.setNome(textFieldNome.getText());
				animal.setTipo(comboBoxTipo.getSelectedItem().toString());

				animal.setRga(textFieldRGA.getText());
				animal.setDataNascimento(formattedTextFieldDataNascimento.getText());
				animal.setGenero(comboBoxGenero.getSelectedItem().toString());
				
				animal.setDeficiencia(comboBoxDeficiencia.getSelectedItem().toString());
				animal.setVacinado(comboBoxVacinado.getSelectedItem().toString());
				animal.setCastrado(comboBoxCastrado.getSelectedItem().toString());
		
				animal.setTamanho(Double.parseDouble(formattedTextFieldTamanho.getText()));
				animal.setPeso(Double.parseDouble(formattedTextFieldPeso.getText()));
				animal.setTemperamento(texTemperamento.getText());
				animal.setObservacao(textObservacao.getText());
				animal.setDataResgate(formattedTextFieldDataResgate.getText());
				animal.setImagem(textImagePath.getText());	
					try {
						if (animalService.validarCadastroAnimal(textFieldRGA.getText())) {
							try {
									animalService.adicionarAnimal(animal);
									JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso");
									TelaInicialGUI telaInicialGui = new TelaInicialGUI();
									telaInicialGui.setVisible(true);
									dispose();
								} catch (Exception ex)  {
									JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
									
							}
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
					}
			}
		});
		btnCadastrar.setBounds(262, 387, 110, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnLimparCampos.setBounds(106, 387, 134, 23);
		contentPane.add(btnLimparCampos);
		
		JLabel lblMesano = new JLabel("Mes/Ano");
		lblMesano.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMesano.setBounds(419, 208, 46, 14);
		contentPane.add(lblMesano);
		
		JLabel lblDiamesano = new JLabel("Dia/Mes/Ano");
		lblDiamesano.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDiamesano.setBounds(212, 245, 69, 14);
		contentPane.add(lblDiamesano);
		
		texTemperamento = new JTextField();
		texTemperamento.setBounds(421, 242, 198, 20);
		contentPane.add(texTemperamento);
		texTemperamento.setColumns(10);
		
		textObservacao = new JTextField();
		textObservacao.setBounds(116, 290, 503, 20);
		contentPane.add(textObservacao);
		textObservacao.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Imagem");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 317, 55, 50);
		contentPane.add(lblNewLabel_1);
		
		textImagePath = new JTextField();
		textImagePath.setBounds(76, 333, 164, 20);
		contentPane.add(textImagePath);
		textImagePath.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f =chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				textImagePath.setText(filename);
				ImageIcon img = new ImageIcon(filename);
				lblImagem.setIcon(new ImageIcon(img.getImage().getScaledInstance(lblImagem.getWidth(), 
						lblImagem.getHeight(), Image.SCALE_DEFAULT)));	
				lblImagem.repaint();  
			}
		});
		btnProcurar.setBounds(250, 332, 89, 23);
		contentPane.add(btnProcurar);
		
		
		
		lblImagem = new JLabel("");
		lblImagem.setBounds(350, 321, 86, 50);
		contentPane.add(lblImagem);
	}

}
