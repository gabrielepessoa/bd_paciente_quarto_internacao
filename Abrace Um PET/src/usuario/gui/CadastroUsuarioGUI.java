package usuario.gui;

import infraestrutura.service.ValidacaoService;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import adotante.service.PessoaService;
import usuario.dominio.Usuario;
import usuario.service.UsuarioService;

public class CadastroUsuarioGUI extends JFrame {

	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	private JTextField			textLogin;
	private JPasswordField		textSenha;
	private JPasswordField		textConfirmarSenha;
	private JTextField			textEmail;
	private String				confirmarSenha;

	/**
	 * Create the frame.
	 */
	public CadastroUsuarioGUI(){
		setTitle("Cadastro de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroUsuario = new JLabel("Cadastro de Usuario");
		lblCadastroUsuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroUsuario.setBounds(52, 57, 194, 19);
		contentPane.add(lblCadastroUsuario);

		JLabel lblLogin = new JLabel("Login: ");
		lblLogin.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblLogin.setBounds(68, 141, 46, 19);
		contentPane.add(lblLogin);

		textLogin = new JTextField();
		textLogin.setBounds(197, 141, 345, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblSenha.setBounds(68, 184, 46, 14);
		contentPane.add(lblSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblConfirmarSenha.setBounds(68, 221, 115, 14);
		contentPane.add(lblConfirmarSenha);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textLogin.setText("");
				textSenha.setText("");
				textEmail.setText("");
				textConfirmarSenha.setText("");
			}
		});
		btnLimparCampos.setBounds(197, 349, 345, 23);
		contentPane.add(btnLimparCampos);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Usuario usuario = new Usuario();
				ValidacaoService validar = new ValidacaoService();
				UsuarioService usuarioService = new UsuarioService();

				usuario.setLogin(textLogin.getText());
				usuario.setSenha(new String(textSenha.getPassword()));
				usuario.setEmail(textEmail.getText());
				setConfirmarSenha(new String(textConfirmarSenha.getPassword()));

				String login = usuario.getLogin();
				String senha = usuario.getSenha();
				String email = usuario.getEmail();
				String confirmacaoSenha = getConfirmarSenha();

				try {
					if (validacaoDadosUsuario(validar, login, senha, email, confirmacaoSenha)) {
						if (usuarioService.adicionarUsuarioService(usuario)) {
							JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
							LoginGUI login1 = new LoginGUI();
							login1.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "O cadastro não pode ser realizado, tente novamente!", "ERROR", 0);
							textLogin.setText("");
							textSenha.setText("");
							textEmail.setText("");
							textConfirmarSenha.setText("");
						}
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			/**
			 * @param validar
			 * @param login
			 * @param senha
			 * @param email
			 * @param confirmacaoSenha
			 * @throws Exception 
			 * @throws HeadlessException 
			 */
			public boolean validacaoDadosUsuario(ValidacaoService validar, String login, String senha, String email, String confirmacaoSenha) throws HeadlessException, Exception {
				UsuarioService us = new UsuarioService();
				PessoaService ps = new PessoaService();
				boolean valido;
				if (us.validarCadastroUsuario(login)) {
					if (us.validarLogin(login)) {
						if (us.validarSenha(senha)) {
							if (us.validarConfirmacaoSenha(senha, confirmacaoSenha)) {
								if (ps.validarEmail(email)) {
									return valido = true;
								} else {
									JOptionPane.showMessageDialog(null, "Por favor, digite um email Iválido, usar formato - exemplo@exemplo.com",
											"ERROR", 0);
									textEmail.requestFocus();
									return valido = false;
								}
							} else {
								JOptionPane.showMessageDialog(null, "Senhas não conferem", "ERROR", 0);
								textSenha.setText("");
								textConfirmarSenha.setText("");
								textSenha.requestFocus();
								return valido = false;
							}
						} else {
							JOptionPane.showMessageDialog(null, "A senha deve conter no minimo 6 digitos e pelo menos 1 caracter especial", "ERROR",
									0);
							textSenha.setText("");
							textConfirmarSenha.setText("");
							textSenha.requestFocus();
							return valido = false;
						}
					} else {
						JOptionPane.showMessageDialog(null, "O login deve conter pelo menos 6 caracteres", "ERROR", 0);
						textLogin.requestFocus();
						return valido = false;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Login já cadastrado! Tente outro.", "ERROR", 0);
					valido = false;
					textLogin.setText("");
					textLogin.requestFocus();
				}
				return valido;
			}

		});
		btnCadastrar.setBounds(197, 315, 117, 23);
		contentPane.add(btnCadastrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(324, 315, 106, 23);
		contentPane.add(btnCancelar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(440, 315, 102, 23);
		contentPane.add(btnSair);

		textSenha = new JPasswordField();
		textSenha.setBounds(197, 181, 345, 23);
		contentPane.add(textSenha);

		textConfirmarSenha = new JPasswordField();
		textConfirmarSenha.setBounds(197, 218, 345, 23);
		contentPane.add(textConfirmarSenha);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEmail.setBounds(68, 256, 46, 14);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(197, 254, 345, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

}
