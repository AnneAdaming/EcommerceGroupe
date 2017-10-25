package fr.adaming.service;

import java.util.List;
import javax.ejb.Local;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Local
public interface IProduitService {
	public List<Produit> getAllProduit();
	public List<Produit> getProduitById(int id);
	public List<Produit> getAllProduitByCategorie(Categorie c);
	public List<Produit> getAllProduitByCategories(List<Categorie> cs);
	public int addProduit(Produit p);
	public int deleteProduit(Produit p);
	public int modifyProduit(Produit p);
}
