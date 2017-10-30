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
//	private List<Categorie> listeCategories = new ArrayList<Categorie>();
	private List<Produit> selectedProduits = new ArrayList<Produit>();
	private String[] selectedNomCategories;
	private String valueBarreRecherche;
	
	// Constructeur
	public AfficheurHomeMB() {
		super();
	}
	@PostConstruct
	public void init() {
//		listeCategories = categorieService.getAllCategorie();
		selectedProduits = produitService.getAllProduit();
		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selectedProduits") == null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("selectedProduits", this.selectedProduits);
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().replace("selectedProduits", this.selectedProduits);
	}
	
	// Getters / Setters
//	public List<Categorie> getListeCategories() {
//		return listeCategories;
//	}
//	public void setListeCategories(List<Categorie> listeCategories) {
//		this.listeCategories = listeCategories;
//	}
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
	public void rechercherProduits() {
		List<Categorie> categories = new ArrayList<Categorie>();
		for (String idCategorie : selectedNomCategories) {
			long id = Long.parseLong(idCategorie);
			Categorie categorie = categorieService.getCategorieById(id);
			categories.add(categorie);
		}
		this.selectedProduits = produitService.getAllProduitByCategories(categories);
		for (Produit p : selectedProduits) {
			System.out.println("selectedProduit : " + p);
		}
		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selectedProduits") == null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("selectedProduits", this.selectedProduits);
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().replace("selectedProduits", this.selectedProduits);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
