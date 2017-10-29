package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name="categorieMB")
@SessionScoped
public class CategorieMB implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ICategorieService categorieService;
	public String[] selectedCategories = {"1","2","3"};
	private Categorie categorie;

	public CategorieMB() {
		categorie=new Categorie();
	}

	public String[] getSelectedCategories() {
		return selectedCategories;
	}
	public void setSelectedCategories(String[] selectedCategories) {
		this.selectedCategories = selectedCategories;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public void ajouterCategorie() {
		categorie=categorieService.addCategorie(categorie);
		if(categorie==null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problème lors de l'ajout de catégorie"));
		}
	}
	
	public void modifierCategorie() {
		categorie=categorieService.modifyCategorie(categorie);
		if(categorie==null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problème lors de la modification de catégorie"));
		}
	}
	
	public void supprimerCategorie() {
		categorieService.deleteCategorie(categorie);
	}
}
