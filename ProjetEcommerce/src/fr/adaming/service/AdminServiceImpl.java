package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Admin;

@Stateful
public class AdminServiceImpl implements IAdminService {
	@EJB
	private IAdminDao adminDao;

	@Override
	public Admin getAdmin(String email, String mdp) {
		return adminDao.getAdmin(email, mdp);
	}
}
