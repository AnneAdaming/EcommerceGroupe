package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Stateful
public class ClientServiceImpl implements IClientService {
	@EJB
	private IClientDao clientDao;
	
	@Override
	public Client getClientById(long id) {
		return clientDao.getClientById(id);
	}

	@Override
	public Client addClient(Client cl) {
		return clientDao.addClient(cl);
	}
}
