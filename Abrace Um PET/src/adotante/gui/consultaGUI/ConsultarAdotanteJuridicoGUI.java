package adotante.gui.consultaGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
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
import adotante.dominio.PessoaJuridica;
import adotante.gui.cadastroGUI.CadastroPessoaGUI;
import adotante.service.PessoaFisicaService;
import adotante.service.PessoaJuridicaService;

public class ConsultarAdotanteJuridicoGUI extends JFrame {
	
	/**
	 * 
	 */
	protected static final long	serialVersionUID	= 1L;
	protected JPanel				contentPane;
	protected JTextField			textNomeJuridico;
	protected JTextField			textRua;
	protected JTextField			textBairro;
	protected JTextField			textNumero;
	protected JTextField			textCidade;
	protected JTextField			textEstado;
	protected JTextField			textComplemento;
	protected JTextField			textEmail;
	protected JFormattedTextField	jFormattedTextCpf;
	protected PessoaFisica		pessoaFisica;
	protected JLabel lblMostrarRepresentante;
	protected JFormattedTextField formattedTextFieldTelefoneFixo ;
	protected JFormattedTextField jFormattedTextTeljFormattedTextCelular;
	protected JFormattedTextField formattedTextFieldCnpj;
	protected JFormattedTextField jFormattedTextCep;
	protected PessoaJuridica pj;
	
	/**
	 * Create the frame.
	 */
	public ConsultarAdotanteJuridicoGUI(){
		setTitle("Consulta de Pessoa Juridica - Abrace um PET");
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MaskFormatter mascaraTelFixo = null;
		try {
			mascaraTelFixo = new MaskFormatter("(##)####-####");
			mascaraTelFixo.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um telefone fixo válido!" + e1.getMessage(), "ERROR", 0);
		}
		
		formattedTextFieldTelefoneFixo = new JFormattedTextField(mascaraTelFixo);
		formattedTextFieldTelefoneFixo.setEditable(false);
		contentPane.add(formattedTextFieldTelefoneFixo);
		formattedTextFieldTelefoneFixo.setBounds(173, 116, 118, 20);
		
		MaskFormatter mascaraCelular = null;
		try {
			mascaraCelular = new MaskFormatter("(##)####-####");
			mascaraCelular.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		jFormattedTextTeljFormattedTextCelular = new JFormattedTextField(mascaraCelular);
		jFormattedTextTeljFormattedTextCelular.setEditable(false);
		contentPane.add(jFormattedTextTeljFormattedTextCelular);
		jFormattedTextTeljFormattedTextCelular.setBounds(364, 116, 104, 20);
		
		MaskFormatter mascaraCnpj = null;
		try {
			mascaraCnpj = new MaskFormatter("##.###.###/####-##");
			mascaraCnpj.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		formattedTextFieldCnpj = new JFormattedTextField(mascaraCnpj);
		formattedTextFieldCnpj.setEditable(false);
		formattedTextFieldCnpj.setBounds(173, 147, 118, 20);
		contentPane.add(formattedTextFieldCnpj);
		
		MaskFormatter mascaraCep = null;
		try {
			mascaraCep = new MaskFormatter("##.###-###");
			mascaraCep.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um cpf válido!" + e1.getMessage(), "ERROR", 0);
		}


		jFormattedTextCep = new JFormattedTextField(mascaraCep);
		jFormattedTextCep.setEditable(false);
		jFormattedTextCep.setBounds(173, 280, 189, 20);
		contentPane.add(jFormattedTextCep);
		
		JLabel lblCadastroDeUsurioJuridico = new JLabel("Consulta");
		lblCadastroDeUsurioJuridico.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroDeUsurioJuridico.setBounds(9, 16, 225, 14);
		contentPane.add(lblCadastroDeUsurioJuridico);
		
		JLabel lblNomeJuridico = new JLabel("Nome Juridico: ");
		lblNomeJuridico.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblNomeJuridico.setBounds(51, 82, 118, 14);
		contentPane.add(lblNomeJuridico);
		
		textNomeJuridico = new JTextField();
		textNomeJuridico.setEditable(false);
		textNomeJuridico.setBounds(173, 80, 409, 20);
		contentPane.add(textNomeJuridico);
		textNomeJuridico.setColumns(10);
		
		JLabel lblEnderecoEmpresarial = new JLabel("Endere\u00E7o Juridico: ");
		lblEnderecoEmpresarial.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEnderecoEmpresarial.setBounds(33, 223, 114, 14);
		contentPane.add(lblEnderecoEmpresarial);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRua.setBounds(53, 251, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblDadosEmpresariais = new JLabel("Dados Juridicos: ");
		lblDadosEmpresariais.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblDadosEmpresariais.setBounds(25, 54, 132, 14);
		contentPane.add(lblDadosEmpresariais);
		
		JLabel lblCpf = new JLabel("CNPJ: ");
		lblCpf.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCpf.setBounds(51, 149, 46, 14);
		contentPane.add(lblCpf);
		
		textRua = new JTextField();
		textRua.setEditable(false);
		textRua.setBounds(173, 249, 277, 20);
		contentPane.add(textRua);
		textRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblBairro.setBounds(384, 280, 46, 14);
		contentPane.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setEditable(false);
		textBairro.setBounds(440, 283, 142, 20);
		contentPane.add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNumero.setBounds(457, 251, 65, 14);
		contentPane.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setEditable(false);
		textNumero.setBounds(518, 249, 65, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCidade.setBounds(53, 312, 46, 14);
		contentPane.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setEditable(false);
		textCidade.setBounds(173, 310, 189, 20);
		contentPane.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEstado.setBounds(384, 314, 46, 14);
		contentPane.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setBounds(440, 310, 143, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCep.setBounds(53, 285, 46, 14);
		contentPane.add(lblCep);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblComplemento.setBounds(53, 341, 89, 14);
		contentPane.add(lblComplemento);
		
		textComplemento = new JTextField();
		textComplemento.setEditable(false);
		textComplemento.setBounds(173, 341, 409, 20);
		contentPane.add(textComplemento);
		textComplemento.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 209, 563, 14);
		contentPane.add(separator);
		
		JLabel lblResponsavel = new JLabel("Responsavel(CPF):");
		lblResponsavel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblResponsavel.setBounds(51, 184, 118, 14);
		contentPane.add(lblResponsavel);
		
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			System.err.println("Erro na formatação: " + e1.getMessage());
			System.exit(-1);
		}
		jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
		jFormattedTextCpf.setEditable(false);
		jFormattedTextCpf.setBounds(173, 182, 118, 20);
		contentPane.add(jFormattedTextCpf);
		
		JLabel lblTelefoneJuridico2 = new JLabel("Celular:");
		lblTelefoneJuridico2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTelefoneJuridico2.setBounds(301, 118, 65, 14);
		contentPane.add(lblTelefoneJuridico2);
		
		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo:");
		lblTelefoneFixo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTelefoneFixo.setBounds(51, 118, 122, 14);
		contentPane.add(lblTelefoneFixo);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEmail.setBounds(301, 149, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setBounds(364, 147, 217, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPessoaGUI c = new CadastroPessoaGUI();
				c.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(493, 382, 89, 23);
		contentPane.add(btnCancelar);
		
		lblMostrarRepresentante = new JLabel("");
		lblMostrarRepresentante.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblMostrarRepresentante.setBounds(364, 184, 218, 14);
		contentPane.add(lblMostrarRepresentante);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(394, 382, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.setBounds(173, 382, 89, 23);
		contentPane.add(btnAdotar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
				try{
					pessoaJuridicaService.excluirPessoaJuridica(pj);
					JOptionPane.showMessageDialog(null, "Pessoa excluida com sucesso");
					ConsultaPessoaJuridicaCNPJGUI consultar = new ConsultaPessoaJuridicaCNPJGUI();
					consultar.setVisible(true);
					dispose();
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
				}
			}
		});
		btnExcluir.setBounds(283, 382, 89, 23);
		contentPane.add(btnExcluir);
		
	}
}
