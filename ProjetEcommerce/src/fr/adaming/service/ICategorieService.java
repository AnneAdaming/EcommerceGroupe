package fr.adaming.service;

import java.util.List;
import javax.ejb.Local;
import fr.adaming.model.Categorie;

@Local
public interface ICategorieService {
	public List<Categorie> getAllCategorie();
	public Categorie getCategorieById(long id);
	public Categorie addCategorie(Categorie c);
	public int deleteCategorie(Categorie c);
	public int modifyCategorie(Categorie c);
}
