package sistema.internacaoGUI;

import java.awt.Dimension;
import java.awt.EventQueue;
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

import base.Internamento;
import sistema.control.InternamentoControl;

public class InternamentoListagemGUI extends JFrame {

	
	String[] coluna = {"CPF do Paciente", "Número do Internamento", 
			"Data de Baixa", "Data de Alta", "Número do Leito"};	
	String [][] linhas ={};
	
	InternamentoControl ic = new InternamentoControl();
	
	private DefaultTableModel tabela = new DefaultTableModel(linhas, coluna);
	private JScrollPane scroll=null;
	private JTable Tabela=null; 
	
	private JPanel contentPane;
	private JButton btnVoltar;

	
	public JTable getTabela() {
		if(Tabela==null){
			Tabela = new JTable(tabela);
			Tabela.addMouseListener(new MouseAdapter() {
				@Override 
				public void mouseReleased(MouseEvent e){
					int i = Tabela.getSelectedRow();
					Object x = Tabela.getValueAt(i, 1);
					String codigo=x+"";
					
				}
				
			});
		}
		return Tabela;
	}
	
	private JScrollPane getScrool(){
		if(scroll==null){
			scroll = new JScrollPane();
			scroll.setBounds(0, 49, 557, 295);
			scroll.setBackground(SystemColor.text);
			scroll.setViewportView(getTabela());
			defineRenderers();
		}
		return scroll;
	}
	
	private void defineRenderers(){
		Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = Tabela.getTableHeader();
		header.setPreferredSize(new Dimension(200, 25));
		TableColumnModel modeloDaColuna = Tabela.getColumnModel();
		
		modeloDaColuna.getColumn(0).setPreferredWidth(120);//cpf
		modeloDaColuna.getColumn(1).setPreferredWidth(150); //num internamento
		modeloDaColuna.getColumn(2).setPreferredWidth(90);//data
		modeloDaColuna.getColumn(3).setPreferredWidth(90);//data
		modeloDaColuna.getColumn(4).setPreferredWidth(106);//leito
		
	}
	
	/**
	 * Create the frame.
	 */
	public InternamentoListagemGUI() {
		setTitle("Listar Internac\u00E3o");
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
					ic.preencher_tabela(Tabela);
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
					InternamentoGUI ig = new InternamentoGUI();
					ig.setVisible(true);
					dispose();
				}
			});
			btnVoltar.setBounds(460, 355, 97, 23);
		}
		return btnVoltar;
	}
}
