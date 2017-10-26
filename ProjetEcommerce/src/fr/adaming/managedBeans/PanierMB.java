package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;
import fr.adaming.service.ProduitServiceImpl;

@ManagedBean(name = "panierMB")
@RequestScoped
public class PanierMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private Panier panier;
	private LigneCommande ligne;
	private long id;

	@EJB
	private IProduitService produitService;

	HttpSession maSession;

	public PanierMB() {
		FacesContext context = FacesContext.getCurrentInstance();
		maSession = (HttpSession) context.getExternalContext().getSession(false);
		if (maSession == null) {
			// On ne peut pas être sûr que la session a déjà été créée, donc si
			// ça n'est pas le cas, on la crée avec son attribut panier
			maSession = (HttpSession) context.getExternalContext().getSession(true);
			this.panier = new Panier();
			this.panier.setListe(new ArrayList<LigneCommande>());
			maSession.setAttribute("panier", panier);
		} else {
			System.out.println("Sesssion existante");
			this.panier = (Panier) maSession.getAttribute("panier");
			if (panier == null) {
				System.out.println("Scrogneugneu");
				this.panier = new Panier();
				this.panier.setListe(new ArrayList<LigneCommande>());
				maSession.setAttribute("panier", panier);
			}
		}

		this.ligne = new LigneCommande();
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public LigneCommande getLigne() {
		return ligne;
	}

	public void setLigne(LigneCommande ligne) {
		this.ligne = ligne;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String ajout() {
		System.out.println("La quantité est de "+ligne.getQuantite());
		Produit produit = produitService.getProduitById(id);
		ligne.setProduit(produit);
		ligne.setPrix(produit.getPrix());
		panier.getListe().add(ligne);
		maSession.setAttribute("panier", panier);
		
		System.out.println(ligne);
		System.out.println(panier);
		return "#";
	}
}
