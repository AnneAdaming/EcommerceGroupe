package fr.adaming.service;

import java.util.List;
import javax.ejb.Local;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Local
public interface IProduitService {
	public List<Produit> getAllProduit();
	public List<Produit> getAllProduitByCategorie(Categorie c);
	public List<Produit> getAllProduitByCategories(List<Categorie> cs);
	public Produit getProduitById(long id);
	public Produit addProduit(Produit p, Categorie c);
	public void deleteProduit(Produit p);
	public Produit modifyProduit(Produit p);
}
