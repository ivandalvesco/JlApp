package br.com.jlapp.telas;

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
	
	
	JPanel p = new JPanel();
	
   	public TelaPrincipal() {
   		f.setSize(250, 250);
   		
   		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
   		f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
   		
   		btnCadastrarProduto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CadastrarProdutos cp = new CadastrarProdutos();
				
			}
		});
   		
   		p.add(btnCadastrarProduto);
   		p.add(btnConsultarProduto);
   		
   		
    	f.add(p);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.pack();
    	f.setVisible(true);
	}
   	
}
