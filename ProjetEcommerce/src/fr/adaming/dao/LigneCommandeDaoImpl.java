package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Stateless
public class LigneCommandeDaoImpl implements ILigneCommandeDao {
	@PersistenceContext(unitName="PU_ECOMMERCE")
	EntityManager em;
	
	@Override
	public LigneCommande addLigneCommande(LigneCommande lc, Commande co, Produit pr) {
		lc.setCommande(co);
		lc.setProduit(pr);
		em.persist(lc);
		return lc;
	}
}
