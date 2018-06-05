package br.com.jlapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jlapp.models.MovimentoEstoque;

public class MovimentoEstoqueDAO {

	private MovimentoEstoque dao;
	
	protected EntityManager em;
	
	public MovimentoEstoque getDao() {
		if(dao == null) {
			dao = new MovimentoEstoque();
		}
		return dao;
	}
	
	public MovimentoEstoqueDAO() {
		em = getEm();
	}
	
	public EntityManager getEm() {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("appTestePU");
		
		if(em == null) {
			em = f.createEntityManager();
		}
		return em;
	}
	
	public MovimentoEstoque findById(int id) {
		return em.find(MovimentoEstoque.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<MovimentoEstoque> findAll() {
		return em.createQuery("FROM "+ MovimentoEstoque.class.getName()).getResultList();
	}
	
	public void insert(MovimentoEstoque m) {
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void update(MovimentoEstoque m) {
		try {
			em.getTransaction().begin();
			em.merge(m);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void delete(MovimentoEstoque m) {
		try {
			em.getTransaction().begin();
			em.remove(m);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void deleteById(int id) {
		MovimentoEstoque m = findById(id);
		delete(m);
	}
}
