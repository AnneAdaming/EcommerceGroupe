package fr.adaming.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
	private List<Categorie> listeCategories = new ArrayList<Categorie>();
	private Categorie categorie;

	public CategorieMB() {
		categorie=new Categorie();
	}
	@PostConstruct
	public void init() {
		this.listeCategories = categorieService.getAllCategorie();
	}

	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<Categorie> getListeCategories() {
		return listeCategories;
	}
	public void setListeCategories(List<Categorie> listeCategories) {
		this.listeCategories = listeCategories;
	}
	
	public void ajouterCategorie() {
		categorie=categorieService.addCategorie(categorie);
		if(categorie==null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problème lors de l'ajout de catégorie"));
			return;
		}
		this.listeCategories = categorieService.getAllCategorie();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierCategorie() {
		categorie=categorieService.modifyCategorie(categorie);
		if(categorie==null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problème lors de la modification de catégorie"));
			return;
		}
		this.listeCategories = categorieService.getAllCategorie();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void supprimerCategorie() {
		categorieService.deleteCategorie(categorie);
		this.listeCategories = categorieService.getAllCategorie();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
