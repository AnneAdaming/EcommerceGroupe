package fr.adaming.dao;

import javax.ejb.Local;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;

@Local
public interface ICommandeDao {
	Commande getCommandeById(long id);
	Commande addCommande(Commande co, Client cl);
}
