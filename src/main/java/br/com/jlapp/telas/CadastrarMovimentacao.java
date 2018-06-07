package br.com.jlapp.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.jlapp.enums.TipoMov;
import br.com.jlapp.models.Produto;

public class CadastrarMovimentacao extends JFrame {

	JPanel headerPanel;
	JPanel produtoPanel;
	JPanel bottomPanel;
	
	JTextField tProduto;
	JButton btnBuscarProduto;
	
	JTextField tQuantidade;
	
	JComboBox<TipoMov> cTipoMov;
	TipoMov e;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public CadastrarMovimentacao() {
		criarWindow();
	}
	
	
	private void criarWindow() {
		setTitle("Cadastro de Movimentações");
		headerPanel= new JPanel();
		headerPanel.add(new Label("Cadastro de Movimentação"));
		
		tProduto = new JTextField();
		btnBuscarProduto = new JButton("Buscar Produto");
		
		btnBuscarProduto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				buscarProduto();
				
				
			}
		});
		
		produtoPanel= new JPanel();
		produtoPanel.add(new Label("Produto"));
		tProduto.setPreferredSize(new Dimension(150, 25));
		tProduto.setEditable(false);
		produtoPanel.add(tProduto);
		produtoPanel.add(btnBuscarProduto);
		
		tQuantidade = new JTextField();
		
		bottomPanel = new JPanel();
		bottomPanel.add(new Label("Quantidade"));
		tQuantidade.setPreferredSize(new Dimension(50, 25));
		bottomPanel.add(tQuantidade);
		
		
		cTipoMov = new JComboBox<TipoMov>(e.values());
		
		bottomPanel.add(new Label("Tipo de Movimentação"));
		cTipoMov.setPreferredSize(new Dimension(100, 25));
		bottomPanel.add(cTipoMov);
		
		this.setPreferredSize(new Dimension(450, 150));
		getContentPane().add(headerPanel, BorderLayout.NORTH);
		getContentPane().add(produtoPanel, BorderLayout.CENTER);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		
		
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        pack();
        setVisible(true);
	}
	
	
	public Produto buscarProduto() {
		Produto p1;
		BuscarProduto p = new BuscarProduto();
		p.initComponents();
		// p1 = p.getP1();
		// p1 = p.selecionarProduto();
		// System.out.println(p1.getDescricao());
		
		return p1;
	}
}
