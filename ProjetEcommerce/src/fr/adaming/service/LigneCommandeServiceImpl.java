package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Stateful
public class LigneCommandeServiceImpl implements ILigneCommandeService {
	@EJB
	private ILigneCommandeDao ligneCommandeDao;

	@Override
	public LigneCommande addLigneCommande(LigneCommande lc, Commande co, Produit pr) {
		return ligneCommandeDao.addLigneCommande(lc, co, pr);
	}
}
