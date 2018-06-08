package br.com.jlapp.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.jlapp.dao.MovimentoEstoqueDAO;
import br.com.jlapp.models.MovimentoEstoque;
import br.com.jlapp.models.Produto;

public class ControleEstoque extends JFrame {

	JPanel headerPanel;
	JPanel topPanel;
	JPanel tablePanel;
	
	DefaultTableModel mMovEstoque = new DefaultTableModel();
	JTable tMovEstoque;
	JScrollPane sMovEstoque ;
	
	JButton btnInserirMov;
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	List<MovimentoEstoque> me;
	
	MovimentoEstoqueDAO dao = new MovimentoEstoqueDAO();
	
	 public ControleEstoque () {
		 setTitle("Controle de Estoque");
		tMovEstoque = new JTable(mMovEstoque);
		sMovEstoque = new JScrollPane(tMovEstoque);
		criarWindow();
		criarTable();
	}
	
	
	public void criarWindow() {
		headerPanel = new JPanel();
		headerPanel.add(new Label("Controle de Movimentações"));
		topPanel = new JPanel();
		btnInserirMov = new JButton("Inserir Movimentação");
		topPanel.setPreferredSize(new Dimension(200, 35));
		topPanel.add(btnInserirMov);
		tablePanel = new JPanel();
		tablePanel.add(sMovEstoque, BorderLayout.NORTH);
		
		
		btnInserirMov.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CadastrarMovimentacao m = new CadastrarMovimentacao();
				
			}
		});
		
		this.addWindowFocusListener(new WindowFocusListener() {
			
			public void windowLostFocus(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowGainedFocus(WindowEvent arg0) {
				fillTable();
				
			}
		});
		
		this.setPreferredSize(new Dimension(600, 550));
		
		getContentPane().add(headerPanel, BorderLayout.NORTH);
		getContentPane().add(topPanel, BorderLayout.CENTER);
		getContentPane().add(tablePanel, BorderLayout.SOUTH);
		
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        pack();
        setVisible(true);
	}
	
	
	public void criarTable() {
		tMovEstoque= new JTable(mMovEstoque);
		mMovEstoque.addColumn("Id");
		mMovEstoque.addColumn("Produto");
		mMovEstoque.addColumn("Data Movimentação");
		mMovEstoque.addColumn("Quantidade");
		mMovEstoque.addColumn("Tipo de Movimentação");
		tMovEstoque.getColumnModel().getColumn(0).setPreferredWidth(10);
		tMovEstoque.getColumnModel().getColumn(1).setPreferredWidth(120);
		tMovEstoque.getColumnModel().getColumn(2).setPreferredWidth(80);
		tMovEstoque.getColumnModel().getColumn(3).setPreferredWidth(60);
		tMovEstoque.getColumnModel().getColumn(4).setPreferredWidth(80);
		fillTable();
	}
	
	
	private void fillTable() {
		mMovEstoque.setNumRows(0);
		me = dao.findAll();
		Produto p = new Produto();
		for(MovimentoEstoque e : me) {
			p = e.getProduto();
			mMovEstoque.addRow(new Object[]{e.getId(), p.getDescricao(), e.getData_movimento(), e.getQuantidade(), e.getTipo_movimentacao()});
		}
	}
	
}
