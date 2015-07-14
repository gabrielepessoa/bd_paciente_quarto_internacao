package infraestrutura.gui;

import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ImagensGUI {
	public static void imagemLogin(JLabel label) {
		try {
			label.setIcon(new ImageIcon(new File("imagens/login.png").getCanonicalPath()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void imagemCadastroUsuario(JButton button) {
		try {
			button.setIcon(new ImageIcon(new File("imagens/cadastro.png").getCanonicalPath()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void imagemCadastroAdotante(JLabel label) {
		try {
			label.setIcon(new ImageIcon(new File("imagens/cadastroAdotante.png").getCanonicalPath()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static void imagemAdocaoFisico(JLabel label) {
		try {
			label.setIcon(new ImageIcon(new File("imagens/gatoeducado.png").getCanonicalPath()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static void imagemAdocao(JLabel label) {
		try {
			label.setIcon(new ImageIcon(new File("imagens/cachorroEstiloso.png").getCanonicalPath()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static void imagemPessoa(JLabel label) {
		try {
			label.setIcon(new ImageIcon(new File("imagens/bolas.png").getCanonicalPath()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
