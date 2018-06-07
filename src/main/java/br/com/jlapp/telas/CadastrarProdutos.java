package br.com.jlapp.telas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.jlapp.dao.ProdutoDAO;
import br.com.jlapp.models.Produto;

public class CadastrarProdutos extends javax.swing.JFrame{

 	JPanel p;
 	
	
	JTextField descricao;
	JTextField quantidadeMinima;
	JTextField valor;
	
	JButton btnCadastrar;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
	public CadastrarProdutos() {
		this.setPreferredSize(new Dimension(200, 200));
		this.setTitle("Cadastro de Produtos");
		p = new JPanel(new GridLayout(0, 1));
	
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setPreferredSize(new Dimension(50,50));
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cadastrarProduto();
				
			}
		});
		
		p.setPreferredSize(new Dimension(200,200));

		descricao = new JTextField();
		quantidadeMinima= new JTextField();
		valor= new JTextField();
		descricao.setPreferredSize( new Dimension(150,15));
		quantidadeMinima.setPreferredSize( new Dimension(75,15));
		valor.setPreferredSize( new Dimension(100,15));
		
		p.add(new Label("Descrição"));
		p.add(descricao);
		p.add(new Label("Quantidade Mínima"));
		p.add(quantidadeMinima);
		p.add(new Label("Valor"));
		p.add(valor);
		p.add(btnCadastrar);
		
		getContentPane().add(p);
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        pack();
        setVisible(true);
        
	}
	
	private void cadastrarProduto() {
		Produto p = new Produto();
		
		ProdutoDAO dao;
		
		if(descricao.getText() != null && !descricao.getText().equals("")) {
			p.setDescricao(descricao.getText());
		}else {
			JOptionPane.showMessageDialog(new JFrame(), "Campo Descrição Obrigatório", "Erro!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(quantidadeMinima.getText() != null && !quantidadeMinima.getText().equals("")) {
			try {
				p.setQuantidade_minima(Integer.parseInt(quantidadeMinima.getText()));
			}catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Campo Quantidade Mínima deve ser de apenas números", "Erro!",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}else {
			JOptionPane.showMessageDialog(new JFrame(), "Campo de Quantidade mínima Obrigatório", "Erro!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(valor.getText() != null && !valor.getText().equals("")) {
			try {
				p.setValor(Double.parseDouble(valor.getText()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Campo Valor deve ser apenas números", "Erro!",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}else {
			JOptionPane.showMessageDialog(new JFrame(), "Campo Valor Obrigatório", "Erro!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		

		p.setData_cadastro(new Timestamp(System.currentTimeMillis()));
		
		try {
		dao = new ProdutoDAO();
		dao.insert(p);
		JOptionPane.showMessageDialog(null, "Cadastro realizado");
		setVisible(false);
		dispose();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
