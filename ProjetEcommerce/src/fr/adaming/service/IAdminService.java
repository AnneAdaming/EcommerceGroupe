package fr.adaming.service;

import java.util.List;
import javax.ejb.Local;
import fr.adaming.model.Admin;

@Local
public interface IAdminService {
	Admin getAdmin(String email, String mdp);
}
