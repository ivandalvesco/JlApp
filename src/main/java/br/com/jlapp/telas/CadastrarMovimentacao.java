package br.com.jlapp.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.jlapp.dao.MovimentoEstoqueDAO;
import br.com.jlapp.enums.TipoMov;
import br.com.jlapp.models.MovimentoEstoque;
import br.com.jlapp.models.Produto;

public class CadastrarMovimentacao extends JFrame {

	JPanel headerPanel;
	JPanel produtoPanel;
	JPanel bottomPanel;
	JPanel salvarPanel;
	JTextField tProduto;
	JButton btnBuscarProduto;
	
	JTextField tQuantidade;
	
	JComboBox<TipoMov> cTipoMov;
	
	JButton btnSalvar;
	
	TipoMov e;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	BuscarProduto p;
	
	Produto p1;
	
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
	
				//obterProduto();
			}
		});
		
		produtoPanel= new JPanel();
		produtoPanel.add(new Label("Produto"));
		tProduto.setPreferredSize(new Dimension(150, 25));
		tProduto.setEditable(false);
		produtoPanel.add(tProduto);
		produtoPanel.add(btnBuscarProduto);
		
		tQuantidade = new JTextField();
		btnSalvar = new JButton("Salvar");
		
		bottomPanel = new JPanel();
		bottomPanel.add(new Label("Quantidade"));
		tQuantidade.setPreferredSize(new Dimension(50, 25));
		bottomPanel.add(tQuantidade);	
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MovimentoEstoque me = new MovimentoEstoque();
				MovimentoEstoqueDAO mdao = new MovimentoEstoqueDAO();
				
				if(p1.equals(null)) {
					JOptionPane.showMessageDialog(new JFrame(), "É necessário selecionar o Produto", "Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(tQuantidade.getText().equals(null)) {
					JOptionPane.showMessageDialog(new JFrame(), "É necessário informar a quantidade ", "Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				me.setProduto(p1);
				me.setQuantidade(Integer.parseInt(tQuantidade.getText()));
				me.setTipo_movimentacao(cTipoMov.getSelectedItem().toString());
				me.setData_movimento(new Timestamp (System.currentTimeMillis()));
				
				mdao.insert(me);
				setVisible(false);
			}
		});
		
		cTipoMov = new JComboBox<TipoMov>(e.values());
		
		bottomPanel.add(new Label("Tipo de Movimentação"));
		cTipoMov.setPreferredSize(new Dimension(100, 25));
		bottomPanel.add(cTipoMov);
		bottomPanel.add(btnSalvar);
		this.setPreferredSize(new Dimension(550, 150));
		getContentPane().add(headerPanel, BorderLayout.NORTH);
		getContentPane().add(produtoPanel, BorderLayout.CENTER);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);

		
		
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        pack();
        setVisible(true);
	}
	
	
	public void buscarProduto() {
		 p = new BuscarProduto();
		 p.setVisible(true);
		 
		 p.getBtnSelecionar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				p1 = p.dao.findById((Integer)p.mProdutos.getValueAt(p.rowSelected, 0));
				tProduto.setText(p1.getDescricao());
			}
		});
	}
	
	public void obterProduto() {
		tProduto.setText(p.getP1().getDescricao());

	}
}
