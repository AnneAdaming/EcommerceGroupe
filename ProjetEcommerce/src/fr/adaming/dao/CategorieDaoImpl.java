package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.Categorie;

@Stateless
public class CategorieDaoImpl implements ICategorieDao {

	@PersistenceContext(unitName="PU_ECOMMERCE")
	EntityManager em;
	
	@Override
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getCategorieById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie addCategorie(Categorie c) {
		em.persist(c);
		return c;
	}

	@Override
	public int deleteCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
