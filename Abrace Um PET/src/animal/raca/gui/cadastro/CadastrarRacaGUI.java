package animal.raca.gui.cadastro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import usuario.gui.TelaInicialGUI;
import animal.raca.dominio.Raca;
import animal.raca.gui.RacaGUI;
import animal.raca.service.RacaService;
import animal.service.Validacoes;

public class CadastrarRacaGUI extends JFrame {
	
	private static final long	serialVersionUID	= 1L;
	Validacoes					validacoes			= new Validacoes();
	RacaService					racaService			= new RacaService();
	Raca						raca				= new Raca();
	private JPanel				contentPane;
	private JTextField			textFieldNome;
	private JTextField			textFieldOrigem;
	
	/**
	 * Create the frame.
	 */
	public CadastrarRacaGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroRacaCachorro = new JLabel("Cadastro de Ra\u00E7a ");
		lblCadastroRacaCachorro.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroRacaCachorro.setBounds(10, 28, 327, 14);
		contentPane.add(lblCadastroRacaCachorro);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNome.setBounds(10, 108, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblOrigem.setBounds(10, 149, 62, 17);
		contentPane.add(lblOrigem);
		
		JLabel lblTamanhoMaximo = new JLabel("Tamanho Maximo: ");
		lblTamanhoMaximo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTamanhoMaximo.setBounds(358, 106, 119, 14);
		contentPane.add(lblTamanhoMaximo);
		
		JLabel lblTamanhoMinimo = new JLabel("Tamanho Minimo: ");
		lblTamanhoMinimo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTamanhoMinimo.setBounds(358, 150, 109, 14);
		contentPane.add(lblTamanhoMinimo);
		
		JLabel lblExpectativaDeVida = new JLabel("Expectativa de vida: ");
		lblExpectativaDeVida.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblExpectativaDeVida.setBounds(358, 196, 130, 14);
		contentPane.add(lblExpectativaDeVida);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(76, 106, 239, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldOrigem = new JTextField();
		textFieldOrigem.setBounds(76, 148, 239, 20);
		contentPane.add(textFieldOrigem);
		textFieldOrigem.setColumns(10);
		
		MaskFormatter mascaraTamanho = null;
		try {
			mascaraTamanho = new MaskFormatter("#.##");
			mascaraTamanho.setPlaceholderCharacter('_');
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tamanho inválido!", "ERROR", 0);
			e.printStackTrace();
		}
		
		JFormattedTextField formattedTextFieldTamanhoMaximo = new JFormattedTextField(mascaraTamanho);
		formattedTextFieldTamanhoMaximo.setBounds(489, 104, 62, 20);
		contentPane.add(formattedTextFieldTamanhoMaximo);
		
		JFormattedTextField formattedTextFieldTamanhoMinimo = new JFormattedTextField(mascaraTamanho);
		formattedTextFieldTamanhoMinimo.setBounds(489, 148, 62, 20);
		contentPane.add(formattedTextFieldTamanhoMinimo);
		
		MaskFormatter mascaraExpectativaVida = null;
		try {
			mascaraExpectativaVida = new MaskFormatter("##");
			mascaraExpectativaVida.setPlaceholderCharacter('_');
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tamanho inválido!", "ERROR", 0);
			e.printStackTrace();
		}
		
		JFormattedTextField formattedTextFieldExpectativaDeVida = new JFormattedTextField(mascaraExpectativaVida);
		formattedTextFieldExpectativaDeVida.setBounds(489, 194, 62, 20);
		contentPane.add(formattedTextFieldExpectativaDeVida);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "", "Gato", "Cachorro" }));
		comboBoxTipo.setBounds(76, 194, 101, 20);
		contentPane.add(comboBoxTipo);
		
		JLabel lblTemoeramento = new JLabel("Temperamento: ");
		lblTemoeramento.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTemoeramento.setBounds(10, 261, 101, 20);
		contentPane.add(lblTemoeramento);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(76, 292, 475, 75);
		contentPane.add(editorPane);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				raca.setNome(textFieldNome.getText());
				raca.setOrigem(textFieldOrigem.getText());
				raca.setTamanhoMax(Double.parseDouble(formattedTextFieldTamanhoMaximo.getText()));
				raca.setTamanhoMin(Double.parseDouble(formattedTextFieldTamanhoMinimo.getText()));
				raca.setExpectativaVida(Integer.parseInt(formattedTextFieldExpectativaDeVida.getText()));
				raca.setTipo(comboBoxTipo.getSelectedItem().toString());
				raca.setTemperamento(editorPane.getText().toString());
				
				String nome = raca.getNome().toString();
				String origem = raca.getOrigem().toString();
				String tipo = raca.getTipo().toString();
				
				if (validacaoDadosRaca(nome, origem, tipo)) {
					if (racaService.adicionarRaca(raca)) {
						JOptionPane.showMessageDialog(null, "Raça adicionada com sucesso!");
						TelaInicialGUI telaInicialGUI = new TelaInicialGUI();
						telaInicialGUI.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Raça não cadastrada! Tente Novamente");
						raca.setNome("");
						raca.setOrigem("");
						raca.setTamanhoMax(0);
						raca.setTamanhoMin(0);
						raca.setExpectativaVida(0);
						raca.setTemperamento("");
						textFieldNome.requestFocus();
					}
				}
				
			}
			
			/**
			 * @param nome
			 * @param origem
			 * @param tipo
			 * @param temperamento
			 * @return
			 */
			public boolean validacaoDadosRaca(String nome, String origem, String tipo) {
				boolean valido = true;
				try {
					racaService.validarRaca(nome);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
					valido = false;
				}
				try {
					validacoes.verificarVazio(nome, "Por favor, digite o nome da raça");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					valido = false;
				}
				try {
					validacoes.verificarVazio(origem, "Por favor, digite a origem da raça");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					valido = false;
				}
				try {
					validacoes.verificarVazio(tipo, "Por favor, escolha o tipo da raça");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					valido = false;
				}
				return valido;
				
			}
		});
		btnCadastrar.setBounds(445, 382, 101, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RacaGUI racaGUI = new RacaGUI();
				racaGUI.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(335, 382, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTipo.setBounds(10, 195, 46, 17);
		contentPane.add(lblTipo);
		
	}
}
