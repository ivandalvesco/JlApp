package br.com.jlapp.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jlapp.dao.ProdutoDAO;
import br.com.jlapp.models.Produto;

@ManagedBean(name = "produto")
@SessionScoped
public class ProdutoBean {

	ProdutoDAO dao;
	
	public ProdutoBean() {
		dao = new ProdutoDAO();
	}
	
	private List<Produto> listarProdutos() {
		return dao.findAll();

	}
}
