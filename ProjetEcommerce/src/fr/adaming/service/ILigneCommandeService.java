package fr.adaming.service;

import javax.ejb.Local;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Local
public interface ILigneCommandeService {
	LigneCommande addLigneCommande(LigneCommande lc, Commande co, Produit pr);
}
