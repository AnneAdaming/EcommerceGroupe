package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Stateful
public class ProduitServiceImpl implements IProduitService {
	@EJB
	private IProduitDao produitDao;
	
	@Override
	public List<Produit> getAllProduit() {
		return produitDao.getAllProduit();
	}
	@Override
	public List<Produit> getAllProduitByCategorie(Categorie c) {
		return produitDao.getAllProduitByCategorie(c);
	}
	@Override
	public List<Produit> getAllProduitByCategories(List<Categorie> cs) {
		List<Produit> produits = new ArrayList<Produit>();
		for (Categorie c : cs) {
			List<Produit> subList = produitDao.getAllProduitByCategorie(c);
			if (subList != null) {
				produits.addAll(subList);
			}
		}
		return produits;
	}
	@Override
	public Produit getProduitById(long id) {
		return produitDao.getProduitById(id);
	}
	@Override
	public Produit addProduit(Produit p, Categorie c) {
		return produitDao.addProduit(p, c);
	}
	@Override
	public void deleteProduit(Produit p) {
		produitDao.deleteProduit(p);
	}
	@Override
	public Produit modifyProduit(Produit p) {
		return produitDao.modifyProduit(p);
	}
}
