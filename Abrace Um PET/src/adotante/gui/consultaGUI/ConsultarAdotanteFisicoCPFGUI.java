package adotante.gui.consultaGUI;

import infraestrutura.gui.ImagensGUI;

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
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.service.EnderecoService;
import adotante.service.PessoaFisicaService;

public class ConsultarAdotanteFisicoCPFGUI extends JFrame {

	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	private JLabel				lblMostrarNome;
	private PessoaFisica		pessoaFisica;
	
	/**
	 * Create the frame.
	 */
	public ConsultarAdotanteFisicoCPFGUI(){
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNewLabel.setBounds(28, 202, 46, 14);
		contentPane.add(lblNewLabel);
		
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');
			
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um CPF válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
		jFormattedTextCpf.setBounds(84, 200, 188, 20);
		contentPane.add(jFormattedTextCpf);
		
		JButton btnConsultarCpf = new JButton("Consultar");
		btnConsultarCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaAdotanteFisico(jFormattedTextCpf);
			}

			/**
			 * EFETUA A CONSULTA DE UMA ADOTANTE FISICO ATRAVÉS DO CPF E SETA NA GUI 
			 * @param jFormattedTextCpf
			 */
			public void consultaAdotanteFisico(JFormattedTextField jFormattedTextCpf) {
				try{
					ConsultarAdotanteFisicoGUI consulta = new ConsultarAdotanteFisicoGUI();
					
					PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
					EnderecoService enderecoService = new EnderecoService();
					pessoaFisica = pessoaFisicaService.consultarRepresentante(jFormattedTextCpf.getText());
					Pessoa pessoa = pessoaFisica.getPessoa();
					Endereco endereco = new Endereco();
					int idEndereco = pessoaFisica.getPessoa().getEndereco().getId();
					endereco = enderecoService.consultarEndereco(idEndereco);
					
					consulta.textNomeFisico.setText(pessoa.getNome());
					consulta.textEmail.setText(pessoa.getEmail());
					consulta.formattedTextFieldTelefoneFixo.setText(pessoa.getTelefoneFixo());
					consulta.jFormattedTextTeljFormattedTextCelular.setText(pessoa.getTelefoneCelular());
	
					consulta.comboGenero.setToolTipText(pessoaFisica.getGenero());
					consulta.jFormattedTextCPF.setText(pessoaFisica.getCpf());
					consulta.textRG.setText(pessoaFisica.getRg());
					
					consulta.textRua.setText(endereco.getRua());
					consulta.textBairro.setText(endereco.getBairro());
					consulta.textCidade.setText(endereco.getCidade());
					consulta.textEstado.setText(endereco.getEstado());
					consulta.jFormattedTextCep.setText(endereco.getCep());
					consulta.textNumero.setText(endereco.getNumero());
					pessoa.setEndereco(endereco);
					consulta.pf = pessoaFisica;
					consulta.setVisible(true);
					dispose();
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
				}
				
			}
		});
		btnConsultarCpf.setBounds(282, 199, 89, 23);
		contentPane.add(btnConsultarCpf);
		
		lblMostrarNome = new JLabel("");
		lblMostrarNome.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblMostrarNome.setBounds(84, 238, 193, 23);
		contentPane.add(lblMostrarNome);
		
		JLabel lblAdooDePessoa = new JLabel("Consulta de Pessoa Fisica");
		lblAdooDePessoa.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAdooDePessoa.setBounds(28, 62, 193, 14);
		contentPane.add(lblAdooDePessoa);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPessoaGUI consultaPessoa = new ConsultarPessoaGUI();
				consultaPessoa.setVisible(true);
				dispose();;
			}
		});
		btnVoltar.setBounds(282, 382, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		ImagensGUI.imagemAdocaoFisico(label);
		label.setBounds(384, 62, 235, 343);
		contentPane.add(label);
		
	}
}
