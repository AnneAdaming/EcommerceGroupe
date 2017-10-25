package fr.adaming.dao;

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
		List<Produit> liste=query.getResultList();
		return liste;
	}

	@Override
	public List<Produit> getProduitById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> getAllProduitByCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addProduit(Produit p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduit(Produit p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyProduit(Produit p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
