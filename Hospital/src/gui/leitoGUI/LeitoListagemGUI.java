package gui.leitoGUI;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import persistencia.LeitoControl;

public class LeitoListagemGUI extends JFrame {

	String[] coluna = { "Numero do Leito", "Numero do Quarto", "Tipo do Leito" };
	String[][] linhas = {};

	LeitoControl lc = new LeitoControl();

	private DefaultTableModel tabela = new DefaultTableModel(linhas, coluna);
	private JScrollPane scroll = null;
	private JTable Tabela = null;

	private JPanel contentPane;
	private JButton btnVoltar;

	public JTable getTabela() {
		if (Tabela == null) {
			Tabela = new JTable(tabela);
			Tabela.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					// int i = Tabela.getSelectedRow();
					// Object x = Tabela.getValueAt(i, 1);
					// String codigo="";
				}
			});
		}
		return Tabela;
	}

	private JScrollPane getScrool() {
		if (scroll == null) {
			scroll = new JScrollPane();
			scroll.setBounds(0, 49, 557, 295);
			scroll.setBackground(SystemColor.text);
			scroll.setViewportView(getTabela());
			defineRenderers();
		}
		return scroll;
	}

	private void defineRenderers() {
		Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = Tabela.getTableHeader();
		header.setPreferredSize(new Dimension(200, 25));
		TableColumnModel modeloDaColuna = Tabela.getColumnModel();

		modeloDaColuna.getColumn(0).setPreferredWidth(120);// numquarto
		modeloDaColuna.getColumn(1).setPreferredWidth(250); // numleito
		modeloDaColuna.getColumn(2).setPreferredWidth(190);// tipo

	}

	/**
	 * Create the frame.
	 */
	public LeitoListagemGUI() {
		setTitle("Listar Pacientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrool());

		JButton btnAtualizarTabela = new JButton("Atualizar Tabela");
		btnAtualizarTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lc.preencher_tabela(Tabela);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnAtualizarTabela.setBounds(424, 11, 133, 23);
		contentPane.add(btnAtualizarTabela);
		contentPane.add(getBtnVoltar());
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LeitoGUI lg = new LeitoGUI();
					lg.setVisible(true);
					dispose();
				}
			});
			btnVoltar.setBounds(460, 355, 97, 23);
		}
		return btnVoltar;
	}
}
