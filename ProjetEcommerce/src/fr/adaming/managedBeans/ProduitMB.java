package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "produitMB")
@SessionScoped
public class ProduitMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private IProduitService produitService;
	@EJB
	private ICategorieService categorieService;
	@EJB
	private ILigneCommandeService ligneCommandeService;
	
	private List<Produit> listeProduits;
	private Categorie categorie;
	private Produit produit;
	private long idCategorie;
	private long idProduit;

	public ProduitMB() {
		produit=new Produit();
	}
	@PostConstruct
	private void init() {
		this.listeProduits = produitService.getAllProduit();
	}
	
	// Getters / Setters
	public List<Produit> getListeProduits() {
		return listeProduits;
	}
	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}
	// Methodes
	public String modifierProduit() {
		System.out.println("le produit est " +produit);
		produit.setId(idProduit);
		System.out.println(idProduit);
		System.out.println("le produit est " +produit);
		categorie=categorieService.getCategorieById(idCategorie);
		produit.setCategorie(categorie);
		produit=produitService.modifyProduit(produit);
		if(produit==null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problème lors de la modification du produit."));
		} 
		return "home";
	}
	public String ajouterProduit() {
		categorie=categorieService.getCategorieById(idCategorie);
		produit=produitService.addProduit(produit, categorie);
		if(produit!=null) {
			return "home";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problème lors de l'ajout du produit."));
			return "ajout_produit";
		}
	}
	public String supprimerProduit() {
		List<LigneCommande> listeLigneCommande = ligneCommandeService.getAllLigneCommande();
		if (listeLigneCommande == null) {
			return "home";
		}
		int i = 0;
		while (true) {
			int size = listeLigneCommande.size();
			if (i == size) {
				break;
			}
			if (listeLigneCommande.get(i).getProduit().getId() == this.idProduit) {
				listeLigneCommande.remove(i);
				i = 0;
			}
			i++;
		}
		@SuppressWarnings("unchecked")
		List<Produit> selectedProduits = (List<Produit>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selectedProduits");
		for (int j=0; j<selectedProduits.size(); j++) {
			if (selectedProduits.get(j).getId() == idProduit) {
				selectedProduits.remove(j);
				break;
			}
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("selectedProduits", selectedProduits);
		this.produit = produitService.getProduitById(idProduit);
		produitService.deleteProduit(produit);
		return "home";
	}
	
	public String rechercherProduits() {
		System.out.println("rechercher produits");
		return "home";
	}
}
