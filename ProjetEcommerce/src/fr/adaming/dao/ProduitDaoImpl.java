package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao {
	
	@PersistenceContext(unitName="PU_ECOMMERCE")
	EntityManager em;

	@Override
	public List<Produit> getAllProduit() {
		String req="SELECT p FROM Produit p";
		Query query=em.createQuery(req);
		@SuppressWarnings("unchecked")
		List<Produit> resultat = query.getResultList();
		return resultat;
	}

	@Override
	public List<Produit> getAllProduitByCategorie(Categorie c) {
		List<Produit> resultat = new ArrayList<>();
		for (Produit produit : getAllProduit()) {
			if (produit.getCategorie().getId() == c.getId()) {
				resultat.add(produit);
			}
		}
		return resultat;
	}

	@Override
	public Produit getProduitById(long id) {
		return em.find(Produit.class, id);
	}

	@Override
	public Produit addProduit(Produit p, Categorie c) {
		p.setCategorie(c);
		em.persist(p);
		return p;
	}

	@Override
	public void deleteProduit(Produit p) {
		p = em.merge(p);
		em.remove(p);
	}

	@Override
	public Produit modifyProduit(Produit p) {
		em.merge(p);
		return p;
	}
}
