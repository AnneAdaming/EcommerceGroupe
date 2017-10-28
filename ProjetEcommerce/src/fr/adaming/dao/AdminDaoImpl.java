package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.adaming.model.Admin;

@Stateless
public class AdminDaoImpl implements IAdminDao {
	@PersistenceContext(unitName = "PU_ECOMMERCE")
	EntityManager em;
	
	@Override
	public Admin getAdmin(String email, String mdp) {
		String request = "SELECT a FROM Admin a WHERE a.email=:pEmail AND a.mdp=:pMdp";
		Query query = em.createQuery(request);
		query.setParameter("pEmail", email);
		query.setParameter("pMdp", mdp);
		Admin admin = null;
		try {
			admin = (Admin) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return admin;
	}
	@Override
	public Admin addAdmin(Admin ad) {
		em.persist(ad);
		return ad;
	}
}
