package fr.adaming.service;

import javax.ejb.Local;
import fr.adaming.model.Admin;

@Local
public interface IAdminService {
	Admin getAdmin(String email, String mdp);
	Admin addAdmin(Admin ad);
}
