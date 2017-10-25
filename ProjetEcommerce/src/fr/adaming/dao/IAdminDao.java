package fr.adaming.dao;

import javax.ejb.Local;
import fr.adaming.model.Admin;

@Local
public interface IAdminDao {
	Admin getAdmin(String email, String mdp);
}
