package br.com.jlapp.telas;

import java.awt.BorderLayout;
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
		
		super.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
//		super.criarWindow();
//		super.criarTable();
	}

	public void initComponents() {
		btnSelecionar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				selecionarProduto();
				
			}
		});
	}
	
	public Produto selecionarProduto() {
		System.out.println((Integer)super.mProdutos.getValueAt(super.rowSelected, 0));
		p1 = dao.findById((Integer)super.mProdutos.getValueAt(super.rowSelected, 0));
		super.setVisible(false);
		
		return p1;
	}
	
	public Produto getP1() {
		return p1;
	}
	
}
