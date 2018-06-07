package br.com.jlapp.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.jlapp.dao.ProdutoDAO;
import br.com.jlapp.models.Produto;

public class ListarProdutos extends JFrame{
	JPanel headerPanel;
	JPanel topPanel;
	JPanel tablePanel;
	JPanel bottomPanel;
	JPanel p;
	JTextField tcodigo;
	JTextField tdesc;
	
	JButton btnBuscar;
	JButton btnSalvar;
	
	DefaultTableModel mProdutos = new DefaultTableModel();
	JTable tProdutos;
	JScrollPane sProdutos ;
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	List<Produto> lp = new ArrayList<Produto>();
	ProdutoDAO dao = new ProdutoDAO();
	
	
	int rowSelected;
	int colSelected;
	int idProdutoEdit;
	public ListarProdutos() {
		tProdutos = new JTable(mProdutos);
		sProdutos = new JScrollPane(tProdutos);
		criarWindow();
		criarTable();
	}
	
	public void buscar() {
		mProdutos.setNumRows(0);
		if(tcodigo.getText() != null && !tcodigo.getText().equals("")) {
			try {
				lp.add(dao.findById(Integer.parseInt(tcodigo.getText())));
				for (Produto pd : lp) {
		            mProdutos.addRow(new Object[]{pd.getId(), pd.getDescricao(), pd.getValor(), pd.getQuantidade_minima(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pd.getData_cadastro())});
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Campo Código deve ser número", "Erro!",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
		
		if(tdesc.getText() != null && !tdesc.getText().equals("")) {
			lp = dao.findByDesc(tdesc.getText());
			mProdutos.setNumRows(0);
			
			 for (Produto pd : lp) {
		            mProdutos.addRow(new Object[]{pd.getId(), pd.getDescricao(), pd.getValor(), pd.getQuantidade_minima(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pd.getData_cadastro())});
		     }
		}else {
			if(tcodigo.getText() == null || tcodigo.getText().equals("")) {
				lp = dao.findAll();
				for (Produto pd : lp) {
		            mProdutos.addRow(new Object[]{pd.getId(), pd.getDescricao(), pd.getValor(), pd.getQuantidade_minima(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pd.getData_cadastro())});
				}
			}
		}
        tablePanel.repaint();
	}
	
	
	
	public void criarTable() {
		tProdutos = new JTable(mProdutos);
        mProdutos.addColumn("Id");
        mProdutos.addColumn("Descrição");
        mProdutos.addColumn("Valor");
        mProdutos.addColumn("Qtde. Min");
        mProdutos.addColumn("Data Cadastro");
        tProdutos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tProdutos.getColumnModel().getColumn(1).setPreferredWidth(120);
        tProdutos.getColumnModel().getColumn(2).setPreferredWidth(80);
        tProdutos.getColumnModel().getColumn(3).setPreferredWidth(60);
        tProdutos.getColumnModel().getColumn(3).setPreferredWidth(80);
		fillTable();
	}
	
	public void criarWindow() {
		headerPanel = new JPanel();
		topPanel = new JPanel(new GridLayout(0, 1));
		tablePanel = new JPanel();
		btnBuscar = new JButton("Buscar");
		bottomPanel = new JPanel();
		btnSalvar = new JButton("Salvar Alterações");
		
		tablePanel.add(sProdutos, BorderLayout.NORTH);
		bottomPanel.add(btnSalvar, BorderLayout.SOUTH);
		
		tcodigo = new JTextField();
		tcodigo.setPreferredSize(new Dimension(45,25));
		tdesc = new JTextField();
		tdesc.setPreferredSize(new Dimension(150, 25));
		
		headerPanel.add(new Label("Filtrar Produtos"));
		
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		
		tProdutos.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(java.awt.event.MouseEvent e)

			{

			rowSelected=tProdutos.rowAtPoint(e.getPoint());

			colSelected= tProdutos.columnAtPoint(e.getPoint());
			
			idProdutoEdit = (Integer) tProdutos.getValueAt(rowSelected, 0);
			}
			
		});
		
		
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(rowSelected < 0 ) {
					return;
				}
				
				int lastIdEdit=idProdutoEdit;
				Produto p1 ;
				for(int x=0;x< tProdutos.getRowCount(); x++) {
					if(idProdutoEdit == (Integer) tProdutos.getValueAt(x, 0)) {
						p1 = new Produto();
						System.out.println(mProdutos.getValueAt(x, 0).toString());
						System.out.println(mProdutos.getValueAt(x, 1).toString());
						System.out.println(mProdutos.getValueAt(x, 2).toString());
						System.out.println(mProdutos.getValueAt(x, 3).toString());
						System.out.println(mProdutos.getValueAt(x, 4).toString());
						
						p1.setId((Integer)tProdutos.getValueAt(x, 0));
						p1.setDescricao((String) tProdutos.getValueAt(x, 1));
						p1.setValor((Double)tProdutos.getValueAt(x, 2));
						p1.setQuantidade_minima((Integer)tProdutos.getValueAt(x, 3));
						try {
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
							java.util.Date parsedDate;
							parsedDate = (java.util.Date) dateFormat.parse(tProdutos.getValueAt(x, 4).toString());
							SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Timestamp t = (Timestamp.valueOf(df2.format(parsedDate).toString()));
							System.out.println(t.toString());
							p1.setData_cadastro(t);
							
							if(!dao.findById(p1.getId()).equals(p1)) {
								dao.update(p1);
							}
							
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						
					}
				}
					
			}
		});
				
		topPanel.add(new Label("Cod."));
		topPanel.add(tcodigo);
		topPanel.add(new Label("Desc."));
		topPanel.add(tdesc);
		topPanel.add(btnBuscar);
		
		
		setTitle("Produtos Cadastrados");
		
		getContentPane().add(headerPanel, BorderLayout.NORTH);
		getContentPane().add(topPanel, BorderLayout.NORTH);
		getContentPane().add(tablePanel, BorderLayout.CENTER);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        pack();
        setVisible(true);
	}
	
	
	public void fillTable() {
		mProdutos.setNumRows(0);
		lp = dao.findAll();
		for (Produto pd : lp) {
            mProdutos.addRow(new Object[]{pd.getId(), pd.getDescricao(), pd.getValor(), pd.getQuantidade_minima(), new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(pd.getData_cadastro())});
		}
	}
	
	public void updateRow(int i, Produto prod) {
		lp.set(i, prod);
		mProdutos.fireTableRowsUpdated(i, i);
		
		dao.update(lp.get(i));
		fillTable();
	}
	
	
	public boolean isCellEditable(int row, int col)  
    { return true; }  
	public void setValueAt(Object value, int row, int col) {  
    
		
}  
	
	
}
