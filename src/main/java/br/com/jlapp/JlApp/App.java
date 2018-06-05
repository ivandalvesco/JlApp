package br.com.jlapp.JlApp;

import java.awt.Label;
import java.sql.Timestamp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.jlapp.dao.MovimentoEstoqueDAO;
import br.com.jlapp.dao.ProdutoDAO;
import br.com.jlapp.enums.TipoMov;
import br.com.jlapp.models.MovimentoEstoque;
import br.com.jlapp.models.Produto;
import br.com.jlapp.telas.TelaPrincipal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        EntityManagerFactory f = Persistence.createEntityManagerFactory("appTestePU");
        
        
        
        Produto p = new Produto();
        
        p.setDescricao("teste1");
        p.setData_cadastro(new Timestamp(System.currentTimeMillis()));
        p.setQuantidade_minima(1);
        p.setValor(50);
        

        ProdutoDAO d = new ProdutoDAO();
        
        /*       d.insert(p);
        System.out.println("Produto cadastrado");
        
        MovimentoEstoque m = new MovimentoEstoque();
        
        m.setData_movimento(new Timestamp(System.currentTimeMillis()));
        m.setProduto(p);
        m.setQuantidade(1);
        m.setTipo_movimentacao(TipoMov.ENTRADA);
        
        MovimentoEstoqueDAO md = new MovimentoEstoqueDAO(); 
        md.insert(m);
        System.out.println("Movimento registrado");*/
        
        //System.out.println(d.findById(p.getId()).getDescricao());
 
    	// TelaPrincipal principal = new TelaPrincipal();
    	
    	
    }
}
