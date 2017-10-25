package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

@Stateful
public class CategorieServiceImpl implements ICategorieService {
	@EJB
	private ICategorieDao categorieDao;

	@Override
	public List<Categorie> getAllCategorie() {
		return categorieDao.getAllCategorie();
	}
	@Override
	public Categorie getCategorieById(long id) {
		return categorieDao.getCategorieById(id);
	}
	@Override
	public Categorie addCategorie(Categorie c) {
		return categorieDao.addCategorie(c);
	}
	@Override
	public int deleteCategorie(Categorie c) {
		return categorieDao.deleteCategorie(c);
	}
	@Override
	public int modifyCategorie(Categorie c) {
		return categorieDao.modifyCategorie(c);
	}
}
