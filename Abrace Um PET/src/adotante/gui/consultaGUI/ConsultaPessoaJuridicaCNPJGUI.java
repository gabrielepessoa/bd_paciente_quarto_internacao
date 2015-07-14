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
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;
import adotante.service.EnderecoService;
import adotante.service.PessoaFisicaService;
import adotante.service.PessoaJuridicaService;

public class ConsultaPessoaJuridicaCNPJGUI extends JFrame {

	private static final long	serialVersionUID	= 1L;
	private JPanel	contentPane;
	private JFormattedTextField jFormattedTextCnpj;
	private JLabel lblMostrarNome;
	private JLabel lblMostrarAnimal;
	PessoaJuridica pessoaJuridica = new PessoaJuridica();
	
	/**
	 * Create the frame.
	 */
	public ConsultaPessoaJuridicaCNPJGUI(){
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645,455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdooPessoa = new JLabel("Consulta de Pessoa Juridica");
		lblAdooPessoa.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAdooPessoa.setBounds(10, 52, 264, 27);
		contentPane.add(lblAdooPessoa);
		
		JLabel lblCpf = new JLabel("CNPJ:");
		lblCpf.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCpf.setBounds(42, 202, 46, 14);
		contentPane.add(lblCpf);
		
		JButton btnConsultarCnpj = new JButton("Consultar");
		btnConsultarCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarAdotanteJuridicoGUI consulta = new ConsultarAdotanteJuridicoGUI();
				
				if( consultaAdotanteJuridico(consulta) ){
					consulta.setVisible(true);
					dispose();
				}
			}

			/**
			 * SETA OS RESULTADOS DA PESSOA JURIDICA OBTIDOS DO BANCO DE DADOS
			 * @param consulta
			 */
			public boolean consultaAdotanteJuridico(ConsultarAdotanteJuridicoGUI consulta) {
				boolean cond = false;
				try{
					PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
					PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
					EnderecoService enderecoService = new EnderecoService();
					PessoaFisica pessoaFisica = new PessoaFisica();
					pessoaJuridica = pessoaJuridicaService.consultarPessoaJuridica(jFormattedTextCnpj.getText());
					Pessoa pessoa = pessoaJuridica.getPessoa();
					
					int idEndereco = pessoa.getEndereco().getId();
					int idRepresentante = pessoaJuridica.getResponsavel().getId();
					Endereco endereco = enderecoService.consultarEndereco(idEndereco);
					pessoaFisica = pessoaFisicaService.consultarPessoaFisica(idRepresentante);
					
					consulta.textNomeJuridico.setText(pessoa.getNome());
					consulta.textEmail.setText(pessoa.getEmail());
					consulta.formattedTextFieldTelefoneFixo.setText(pessoa.getTelefoneFixo());
					consulta.jFormattedTextTeljFormattedTextCelular.setText(pessoa.getTelefoneCelular());
					consulta.formattedTextFieldCnpj.setText(pessoaJuridica.getCnpj());
					
					consulta.jFormattedTextCpf.setText(pessoaJuridica.getResponsavel().getCpf());
					consulta.lblMostrarRepresentante.setText(pessoaFisica.getPessoa().getNome());
					
					consulta.textRua.setText(endereco.getRua());
					consulta.textBairro.setText(endereco.getBairro());
					consulta.textCidade.setText(endereco.getCidade());
					consulta.textEstado.setText(endereco.getEstado());
					consulta.jFormattedTextCep.setText(endereco.getCep());
					consulta.textNumero.setText(endereco.getNumero());
					consulta.textComplemento.setText(endereco.getComplemento());
					consulta.jFormattedTextCpf.setText(pessoaFisica.getCpf());
				
					pessoaJuridica.setResponsavel(pessoaFisica);
					pessoa.setEndereco(endereco);
					consulta.pj = pessoaJuridica;
					cond = true;
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
				}
				return cond;
			}
		});
		btnConsultarCnpj.setBounds(297, 199, 89, 23);
		contentPane.add(btnConsultarCnpj);
		
		JButton btnVotar = new JButton("Votar");
		btnVotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPessoaGUI consultaPessoa = new ConsultarPessoaGUI();
				consultaPessoa.setVisible(true);
				dispose();
			}
		});
		btnVotar.setBounds(297, 382, 89, 23);
		contentPane.add(btnVotar);
		
		MaskFormatter mascaraCnpj = mascaraCNPJ();
		jFormattedTextCnpj = new JFormattedTextField(mascaraCnpj);
		jFormattedTextCnpj.setBounds(122, 200, 152, 20);
		contentPane.add(jFormattedTextCnpj);
		
		lblMostrarNome = new JLabel("");
		lblMostrarNome.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblMostrarNome.setBounds(117, 162, 152, 27);
		contentPane.add(lblMostrarNome);
		
		lblMostrarAnimal = new JLabel("");
		lblMostrarAnimal.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblMostrarAnimal.setBounds(117, 281, 152, 27);
		contentPane.add(lblMostrarAnimal);
	}

	/**
	 * MASCARA PARA CNPJ
	 * @return
	 */
	public MaskFormatter mascaraCNPJ() {
		MaskFormatter mascaraCnpj = null;
		try {
			mascaraCnpj = new MaskFormatter("##.###.###/####-##");
			mascaraCnpj.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return mascaraCnpj;
	}
}
