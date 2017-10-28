package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "produitMB")
@RequestScoped
public class ProduitMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private IProduitService produitService;
	@EJB
	private ICategorieService categorieService;

	private List<Produit> listeProduits;
	private Categorie categorie;
	private Produit produit;
	private long idCategorie;

	public ProduitMB() {
		produit=new Produit();
	}

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

	@PostConstruct
	private void init() {
		this.listeProduits = produitService.getAllProduit();
	}

	public String modifierProduit() {
		categorie=categorieService.getCategorieById(idCategorie);
		produit.setCategorie(categorie);
		produit=produitService.modifyProduit(produit);
		if(produit!=null) {
			return "home";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Probl�me lors de la modification du produit."));
			return "ajout_produit";
		}
	}
	
	public String ajouterProduit() {
		categorie=categorieService.getCategorieById(idCategorie);
		produit=produitService.addProduit(produit, categorie);
		if(produit!=null) {
			return "home";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Probl�me lors de l'ajout du produit."));
			return "ajout_produit";
		}
	}
	
	public String supprimerProduit() {
		produitService.deleteProduit(produit);
		return "home";
	}
}
