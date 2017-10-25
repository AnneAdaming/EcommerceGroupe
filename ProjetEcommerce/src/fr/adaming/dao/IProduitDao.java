package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitDao {
	public List<Produit> getAllProduit();
	public List<Produit> getProduitById(int id);
	public List<Produit> getAllProduitByCategorie(Categorie c);
	public int addProduit(Produit p);
	public int deleteProduit(Produit p);
	public int modifyProduit(Produit p);
	 
}
