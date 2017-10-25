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
	public List<Produit> getProduitById(int id) {
		return produitDao.getProduitById(id);
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
	public int addProduit(Produit p) {
		return produitDao.addProduit(p);
	}
	@Override
	public int deleteProduit(Produit p) {
		return produitDao.deleteProduit(p);
	}
	@Override
	public int modifyProduit(Produit p) {
		return produitDao.modifyProduit(p);
	}
}
