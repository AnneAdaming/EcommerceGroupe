package fr.adaming.dao;

import javax.ejb.Local;
import fr.adaming.model.Client;

@Local
public interface IClientDao {
	Client getClientById(long id);
	Client addClient(Client cl);
}
