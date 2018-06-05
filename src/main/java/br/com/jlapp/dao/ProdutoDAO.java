package br.com.jlapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jlapp.models.Produto;

public class ProdutoDAO {

	private Produto dao;
	
	protected EntityManager em;
	
	public Produto getDao() {
		if(dao == null) {
			dao = new Produto();
		}
		return dao;
	}
	
	public ProdutoDAO() {
		em = getEm();
	}
	
	private EntityManager getEm() {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("appTestePU");

		if(em == null) {
			em = f.createEntityManager();
		}
		return em;
	}
	
	public Produto findById(int id) {
		return em.find(Produto.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {
		return em.createQuery("FROM "+ Produto.class.getName()).getResultList();
	}
	
	public void insert(Produto p) {
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void update(Produto p ) {
		try{
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void delete(Produto p) {
		try {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	
	public void deleteById(int id) {
		try {
			Produto p = findById(id);
			delete(p);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Produto findByDesc(String desc) {
		
		em.find
		
	}
	
}
