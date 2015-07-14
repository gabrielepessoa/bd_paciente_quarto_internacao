package adotante.gui.consultaGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import adotante.dominio.PessoaFisica;
import adotante.service.PessoaFisicaService;

public class ConsultarAdotanteFisicoGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;
	private JPanel					contentPane;
	protected JTextField			textNomeFisico;
	protected JTextField			textRua;
	protected JTextField			textBairro;
	protected JTextField			textNumero;
	protected JTextField			textCidade;
	protected JTextField			textEstado;
	protected JTextField			textComplemento;
	protected JTextField			textEmail;
	protected JTextField			textRG;
	protected JComboBox < String>	comboGenero;
	protected JFormattedTextField	jFormattedTextCPF;
	protected JFormattedTextField	jFormattedTextCep;
	protected JFormattedTextField	formattedTextFieldTelefoneFixo;
	protected JFormattedTextField	jFormattedTextTeljFormattedTextCelular;
	protected PessoaFisica pf;
	/**
	 * Create the frame.
	 * 
	 * @return
	 */
	public ConsultarAdotanteFisicoGUI(){
		
		setTitle("Cadastro de Pessoa Fisica - Abrace um PET");
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeUsurioJuridico = new JLabel("Pessoa Fisica");
		lblCadastroDeUsurioJuridico.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroDeUsurioJuridico.setBounds(9, 16, 225, 14);
		contentPane.add(lblCadastroDeUsurioJuridico);
		
		JLabel lblNomeFisico = new JLabel("Nome Completo:");
		lblNomeFisico.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblNomeFisico.setBounds(51, 82, 118, 14);
		contentPane.add(lblNomeFisico);
		
		textNomeFisico = new JTextField();
		textNomeFisico.setEditable(false);
		textNomeFisico.setBounds(173, 80, 289, 20);
		contentPane.add(textNomeFisico);
		textNomeFisico.setColumns(10);
		
		JLabel lblEnderecoEmpresarial = new JLabel("Endere\u00E7o:");
		lblEnderecoEmpresarial.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEnderecoEmpresarial.setBounds(25, 236, 114, 14);
		contentPane.add(lblEnderecoEmpresarial);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRua.setBounds(45, 261, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblDadosFisicos = new JLabel("Dados: ");
		lblDadosFisicos.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblDadosFisicos.setBounds(25, 54, 132, 14);
		contentPane.add(lblDadosFisicos);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCpf.setBounds(51, 149, 46, 14);
		contentPane.add(lblCpf);
		
		/**
		 * MASCARA CPF
		 */
		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraCPF.setPlaceholderCharacter('_');
			
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um CPF válido!" + e1.getMessage(), "ERROR",
					0);
		}
		jFormattedTextCPF = new JFormattedTextField(mascaraCPF);
		jFormattedTextCPF.setEditable(false);
		jFormattedTextCPF.setBounds(173, 147, 171, 20);
		contentPane.add(jFormattedTextCPF);
		
		textRua = new JTextField();
		textRua.setEditable(false);
		textRua.setBounds(167, 259, 275, 20);
		contentPane.add(textRua);
		textRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblBairro.setBounds(376, 290, 46, 14);
		contentPane.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setEditable(false);
		textBairro.setBounds(432, 293, 142, 20);
		contentPane.add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNumero.setBounds(449, 261, 65, 14);
		contentPane.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setEditable(false);
		textNumero.setBounds(509, 259, 65, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCidade.setBounds(45, 322, 46, 14);
		contentPane.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setEditable(false);
		textCidade.setBounds(167, 320, 187, 20);
		contentPane.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEstado.setBounds(376, 324, 46, 14);
		contentPane.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setBounds(432, 320, 142, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCep.setBounds(45, 295, 46, 14);
		contentPane.add(lblCep);
		
		/**
		 * MASCARA CEP
		 */
		MaskFormatter mascaraCep = null;
		try {
			mascaraCep = new MaskFormatter("##.###-###");
			mascaraCep.setPlaceholderCharacter('_');
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Digite um cpf válido!", "ERROR", 0);
			e1.printStackTrace();
		}
		jFormattedTextCep = new JFormattedTextField(mascaraCep);
		jFormattedTextCep.setEditable(false);
		jFormattedTextCep.setBounds(167, 288, 187, 20);
		contentPane.add(jFormattedTextCep);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCelular.setBounds(364, 118, 65, 14);
		contentPane.add(lblCelular);
		/**
		 * MASCARA PARA TELEFONE CELULAR
		 */
		MaskFormatter mascaraCelular = null;
		try {
			mascaraCelular = new MaskFormatter("(##)####-####");
			mascaraCelular.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Telefone celular inválido!", "ERROR", 0);
			e1.printStackTrace();
		}
		jFormattedTextTeljFormattedTextCelular = new JFormattedTextField(mascaraCelular);
		jFormattedTextTeljFormattedTextCelular.setEditable(false);
		jFormattedTextTeljFormattedTextCelular.setBounds(420, 116, 151, 20);
		contentPane.add(jFormattedTextTeljFormattedTextCelular);
		
		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo:");
		lblTelefoneFixo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTelefoneFixo.setBounds(51, 118, 122, 14);
		contentPane.add(lblTelefoneFixo);
		
		/**
		 * MASCARA TELEFONE FIXO
		 */
		MaskFormatter mascaraTelFixo = null;
		try {
			mascaraTelFixo = new MaskFormatter("(##)####-####");
			mascaraTelFixo.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Digite um telefone fixo válido!" + e1.getMessage(), "ERROR", 0);
		}
		
		formattedTextFieldTelefoneFixo = new JFormattedTextField(mascaraTelFixo);
		formattedTextFieldTelefoneFixo.setEditable(false);
		contentPane.add(formattedTextFieldTelefoneFixo);
		formattedTextFieldTelefoneFixo.setBounds(173, 111, 171, 20);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEmail.setBounds(51, 180, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setBounds(173, 178, 249, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblComplemento.setBounds(45, 351, 89, 14);
		contentPane.add(lblComplemento);
		
		textComplemento = new JTextField();
		textComplemento.setEditable(false);
		textComplemento.setBounds(167, 351, 407, 20);
		contentPane.add(textComplemento);
		textComplemento.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(11, 217, 563, 14);
		contentPane.add(separator);
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPessoaGUI c = new ConsultarPessoaGUI();
				c.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(479, 382, 95, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblRg = new JLabel("RG: ");
		lblRg.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRg.setBounds(364, 149, 46, 14);
		contentPane.add(lblRg);
		
		textRG = new JTextField();
		textRG.setEditable(false);
		textRG.setBounds(420, 147, 154, 20);
		contentPane.add(textRG);
		textRG.setColumns(10);
		
		JLabel lblGenero = new JLabel("Sexo:");
		lblGenero.setBounds(479, 83, 46, 14);
		contentPane.add(lblGenero);
		
		comboGenero = new JComboBox < String>();
		comboGenero.setEnabled(false);
		comboGenero.setModel(new DefaultComboBoxModel <String>(new String[] { " ", "M", "F" }));
		comboGenero.setBounds(518, 80, 53, 20);
		contentPane.add(comboGenero);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(376, 382, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.setBounds(151, 382, 89, 23);
		contentPane.add(btnAdotar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
				try{
					pessoaFisicaService.excluirPessoaFisica(pf);
					JOptionPane.showMessageDialog(null, "Pessoa excluida com sucesso");
					ConsultarAdotanteFisicoCPFGUI consultar = new ConsultarAdotanteFisicoCPFGUI();
					consultar.setVisible(true);
					dispose();
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
				}

				
			}
		});
		btnExcluir.setBounds(261, 382, 89, 23);
		contentPane.add(btnExcluir);
		
	}
}
