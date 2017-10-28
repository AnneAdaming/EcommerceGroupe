package fr.adaming.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@ManagedBean(name="afficheurHomeMB")
@SessionScoped
public class AfficheurHomeMB implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private IProduitService produitService;
	@EJB
	private ICategorieService categorieService;
	private List<Categorie> listeCategories = new ArrayList<Categorie>();
	private List<Produit> selectedProduits = new ArrayList<Produit>();
	private String[] selectedNomCategories;
	private String valueBarreRecherche;
	
	// Constructeur
	public AfficheurHomeMB() {
		super();
	}
	@PostConstruct
	public void init() {
		selectedProduits = produitService.getAllProduit();
		listeCategories = categorieService.getAllCategorie();
		List<Categorie> cats = categorieService.getAllCategorie();
//		selectedCategories = (String[]) categorieService.getAllCategorie().toArray();
	}
	
	// Getters / Setters
	public List<Categorie> getListeCategories() {
		return listeCategories;
	}
	public void setListeCategories(List<Categorie> listeCategories) {
		this.listeCategories = listeCategories;
	}
	public List<Produit> getSelectedProduits() {
		return selectedProduits;
	}
	public void setSelectedProduits(List<Produit> selectedProduits) {
		this.selectedProduits = selectedProduits;
	}
	public String[] getSelectedNomCategories() {
		return selectedNomCategories;
	}
	public void setSelectedNomCategories(String[] selectedCategories) {
		this.selectedNomCategories = selectedCategories;
	}
	public String getValueBarreRecherche() {
		return valueBarreRecherche;
	}
	public void setValueBarreRecherche(String valueBarreRecherche) {
		this.valueBarreRecherche = valueBarreRecherche;
	}
	
	// Methodes
	public String rechercherProduits() {
		List<Categorie> categories = new ArrayList<Categorie>();
		for (String idCategorie : selectedNomCategories) {
			long id = Long.parseLong(idCategorie);
			Categorie categorie = categorieService.getCategorieById(id);
			categories.add(categorie);
		}
		selectedProduits = produitService.getAllProduitByCategories(categories);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
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
