package gui;

import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ImagensGUI {
	public static void imagemHome(JLabel label) {
		try {
			label.setIcon(new ImageIcon(new File("imagens/hoospital.png").getCanonicalPath()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
}
	
	public static void imagemButton(JButton buton) {
		try {
			buton.setIcon(new ImageIcon(new File("imagens/hospital.png").getCanonicalPath()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
}
}
