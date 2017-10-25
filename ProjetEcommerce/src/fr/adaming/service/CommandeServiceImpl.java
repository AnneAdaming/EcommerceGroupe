package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import fr.adaming.dao.ICommandeDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;

@Stateful
public class CommandeServiceImpl implements ICommandeService {
	@EJB
	private ICommandeDao commandeDao;

	@Override
	public Commande getCommandeById(long id) {
		return commandeDao.getCommandeById(id);
	}
	@Override
	public Commande addCommande(Commande co, Client cl) {
		return commandeDao.addCommande(co, cl);
	}
}
