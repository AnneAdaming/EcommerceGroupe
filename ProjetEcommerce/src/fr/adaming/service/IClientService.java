package fr.adaming.service;

import javax.ejb.Local;
import fr.adaming.model.Client;

@Local
public interface IClientService {
	Client getClientById(long id);
}
