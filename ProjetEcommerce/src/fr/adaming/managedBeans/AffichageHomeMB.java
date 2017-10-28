package fr.adaming.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@ManagedBean(name="affichageHomeMB")
@SessionScoped
public class AffichageHomeMB implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private IProduitService produitService;
	@EJB
	private ICategorieService categorieService;
	public List<Produit> listeProduits = new ArrayList<Produit>();
	public String[] selectedCategories = {"1", "2", "3"};
	public String valueBarreRecherche;
	
	// Constructeur
	public AffichageHomeMB() {
		super();
	}
	
	// Getters / Setters
	public String[] getSelectedCategories() {
		return selectedCategories;
	}
	public void setSelectedCategories(String[] selectedCategories) {
		this.selectedCategories = selectedCategories;
	}
	public String getValueBarreRecherche() {
		return valueBarreRecherche;
	}
	public void setValueBarreRecherche(String valueBarreRecherche) {
		this.valueBarreRecherche = valueBarreRecherche;
	}
	public List<Produit> getListeProduits() {
		return listeProduits;
	}
	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	// Methodes
	public String rechercherProduits() {
		List<Categorie> categories = new ArrayList<Categorie>();
		for (String idCategorie : selectedCategories) {
			long id = Long.parseLong(idCategorie);
			Categorie categorie = categorieService.getCategorieById(id);
			categories.add(categorie);
		}
		listeProduits = produitService.getAllProduitByCategories(categories);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "home";
	}
	public List<String> getListeNomProduits() {
		List<String> nomProduits = new ArrayList<String>();
		List<Produit> produits = produitService.getAllProduit();
		for (Produit produit : produits) {
			String nomProduit = produit.getDesignation();
			System.out.println("nomProduit : " + nomProduit);
			nomProduits.add(nomProduit);
		}
		return nomProduits;
	}
}
