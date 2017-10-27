package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.adaming.model.Client;

@Stateless
public class ClientDaoImpl implements IClientDao {
	@PersistenceContext(unitName="PU_ECOMMERCE")
	EntityManager em;

	@Override
	public Client getClientById(long id) {
		return em.find(Client.class, id);
	}

	@Override
	public Client addClient(Client cl) {
		em.persist(cl);
		return cl;
	}

	
}
