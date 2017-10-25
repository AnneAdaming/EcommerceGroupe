package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Categorie;

@Stateless
public class CategorieDaoImpl implements ICategorieDao {

	@PersistenceContext(unitName="PU_ECOMMERCE")
	EntityManager em;
	
	@Override
	public List<Categorie> getAllCategorie() {
		String req="SELECT ca FROM Categorie ca";
		Query query=em.createQuery(req);
		@SuppressWarnings("unchecked")
		List<Categorie> liste=query.getResultList();
		return liste;
	}

	@Override
	public Categorie getCategorieById(long id) {
		Categorie ca=em.find(Categorie.class,id);
		return ca;
	}

	@Override
	public Categorie addCategorie(Categorie c) {
		em.persist(c);
		return c;
	}

	@Override
	public void deleteCategorie(Categorie c) {
		c=em.merge(c);
		em.remove(c);

	}

	@Override
	public Categorie modifyCategorie(Categorie c) {
		em.merge(c);
		return c;
	}

	
	
}
