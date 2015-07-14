package adocao.gui;

import infraestrutura.gui.ImagensGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import usuario.gui.TelaInicialGUI;
import usuario.service.SessaoUsuario;
import adocao.dominio.Adocao;
import adocao.service.AdocaoService;
import adotante.dominio.Adotante;
import adotante.dominio.PessoaFisica;
import adotante.service.PessoaFisicaService;
import animal.dominio.Animal;
import animal.service.AnimalService;

public class AdocaoPessoaFisicaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel contentPane;
	private JLabel lblMostrarNome;
	private JLabel lblMostrarAnimal;
	private JTextField textRga;
	private Animal animal;
	private PessoaFisica pessoaFisica;

	/**
	 * Create the frame.
	 */
	public AdocaoPessoaFisicaGUI() {
		setTitle("Ado\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNewLabel.setBounds(28, 134, 46, 14);
		contentPane.add(lblNewLabel);
		
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um CPF válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
		jFormattedTextCpf.setBounds(84, 132, 188, 20);
		contentPane.add(jFormattedTextCpf);
		
		JLabel lblNewLabel_1 = new JLabel("RGA:");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(28, 264, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textRga = new JTextField();
		textRga.setBounds(84, 262, 191, 20);
		contentPane.add(textRga);
		textRga.setColumns(10);
		
		JButton btnConsultarCpf = new JButton("Consultar");
		btnConsultarCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoaFisica = new PessoaFisica();
				PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
				try{
					pessoaFisica = pessoaFisicaService.consultarRepresentante(jFormattedTextCpf.getText());
					lblMostrarNome.setText(pessoaFisica.getPessoa().getNome());
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
				}
			}
		});
		btnConsultarCpf.setBounds(282, 131, 89, 23);
		contentPane.add(btnConsultarCpf);
		
		JButton btnConsultarRga = new JButton("Consultar");
		btnConsultarRga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				animal = new Animal();
				AnimalService animalService = new AnimalService();
				animal = animalService.consultarAnimal(textRga.getText());
				lblMostrarAnimal.setText(animal.getNome());
			}
		});
		btnConsultarRga.setBounds(282, 261, 89, 23);
		contentPane.add(btnConsultarRga);
		
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Calendar calobj = Calendar.getInstance();
				String dataAdocao = df.format(calobj.getTime());
				
				Adocao adocao;
				AdocaoService adocaoService = new AdocaoService();
				adocao = adocaoService.consultarAdocao(jFormattedTextCpf.getText(), textRga.getText());
				
				if (adocao.getId() == 0){
					adocao = new Adocao();
					Adotante adotante = new Adotante();
					adotante = adocaoService.consultarAdotante(pessoaFisica.getPessoa());
					adocao.setAnimal(animal);
					adocao.setAdotante(adotante);
					adocao.setDataAdocao(dataAdocao);
					try{
						adocaoService.adicionarAdocaoService(adocao);
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
					}
					SessaoUsuario sessao = SessaoUsuario.getInstancia();
					sessao.setAdocao(adocao);
					JOptionPane.showMessageDialog(null, "Adoção realizada com sucesso!!");
				}
				else if (adocao.getDataDevolucao() == null)
				{
					adocao.setDataDevolucao(dataAdocao);
					adocaoService.editarAdocao(adocao);
					JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso!!");
				}
				else if (adocao.getDataDevolucao() != null) {
					JOptionPane.showMessageDialog(null, "O animal não pode mais ser adotado por esta pessoa!!");
				}

				TelaInicialGUI ti = new TelaInicialGUI();
				ti.setVisible(true);
				dispose();
			}
		});
		btnAdotar.setBounds(183, 382, 89, 23);
		contentPane.add(btnAdotar);
		
		lblMostrarNome = new JLabel("");
		lblMostrarNome.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblMostrarNome.setBounds(84, 163, 193, 23);
		contentPane.add(lblMostrarNome);
		
		lblMostrarAnimal = new JLabel("");
		lblMostrarAnimal.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblMostrarAnimal.setBounds(84, 293, 193, 29);
		contentPane.add(lblMostrarAnimal);
		
		JLabel lblAdooDePessoa = new JLabel("Ado\u00E7\u00E3o de Pessoa Fisica");
		lblAdooDePessoa.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAdooDePessoa.setBounds(28, 62, 193, 14);
		contentPane.add(lblAdooDePessoa);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialGUI tig = new TelaInicialGUI();
				tig.setVisible(true);
				dispose();
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
