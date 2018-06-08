package br.com.jlapp.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.jlapp.dao.ProdutoDAO;
import br.com.jlapp.models.Produto;

public class BuscarProduto extends ListarProdutos {

	ProdutoDAO dao = new ProdutoDAO();
	Produto p1;
	JButton btnSelecionar;
	public BuscarProduto() {
		super.setTitle("Consulta de Produtos");
		
		super.remove(bottomPanel);
		
		bottomPanel = new JPanel();
		btnSelecionar = new JButton("Selecionar Produto");
		bottomPanel.add(btnSelecionar);
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
//		criarWindow();
//		criarTable();
		initComponents();
			
	}

	public void initComponents() {
		btnSelecionar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				selecionarProduto();
				
			}
		});
		fillTable();	
	}
	
	public Produto selecionarProduto() {
		p1 = dao.findById((Integer)super.mProdutos.getValueAt(super.rowSelected, 0));
		super.setVisible(false);
		return p1;
	}
	
	public Produto getP1() {
		return p1;
	}
	
	public JButton getBtnSelecionar() {
		return btnSelecionar;
	}
	
	
}
