package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;

@Stateless
public class CommandeDaoImpl implements ICommandeDao {
	@PersistenceContext(unitName="PU_ECOMMERCE")
	EntityManager em;
	
	@Override
	public Commande getCommandeById(long id) {
		return em.find(Commande.class, id);
	}
	@Override
	public Commande addCommande(Commande co, Client cl) {
		co.setClient(cl);
		em.persist(co);
		return co;
	}
}
