package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Local
public interface ILigneCommandeDao {
	List<LigneCommande> getAllLigneCommande();
	LigneCommande addLigneCommande(LigneCommande lc, Commande co, Produit pr);
}
