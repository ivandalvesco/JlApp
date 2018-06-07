package br.com.jlapp.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPrincipal {
   	private JFrame f = new JFrame("Bem-Vindo");
	
	JButton btnCadastrarProduto = new JButton("Cadastrar novos produtos");
	JButton btnConsultarProduto = new JButton("Consultar produtos cadastrados");
	JButton btnControleEsque = new JButton("Controle de Estoque");
	
	JPanel pCadastroProdutos = new JPanel();
	JPanel pConsultaProdutos = new JPanel();
	JPanel pMovEstoque = new JPanel();
	
	
   	public TelaPrincipal() {
   		f.setSize(250, 250);
   		
   		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
   		f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
   		
   		btnCadastrarProduto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CadastrarProdutos cp = new CadastrarProdutos();
				
			}
		});
   		
   		btnConsultarProduto.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ListarProdutos lp = new ListarProdutos();
			}
		});
   		
   		btnControleEsque.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ControleEstoque ce = new ControleEstoque();
				
			}
		});
   		
   		pCadastroProdutos.add(btnCadastrarProduto);
   		pConsultaProdutos.add(btnConsultarProduto);
   		
   		pMovEstoque.add(btnControleEsque);
   		
   		f.getContentPane().add(pCadastroProdutos, BorderLayout.NORTH);
    	f.getContentPane().add(pConsultaProdutos, BorderLayout.CENTER);
    	f.getContentPane().add(pMovEstoque, BorderLayout.SOUTH);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.pack();
    	f.setVisible(true);
	}
   	
}
