package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Categorie;

@Local
public interface ICategorieDao {
	public List<Categorie> getAllCategorie();
	public Categorie getCategorieById(int id);
	public int addCategorie();
	public int deleteCategorie();
	public int modifyCategorie();
}
