package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;

@ManagedBean(name="panierMB")
@RequestScoped
public class PanierMB implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Panier panier;
	private LigneCommande ligne;
	private String test;
	
	
	public PanierMB() {
		this.panier=new Panier();
		this.ligne=new LigneCommande();
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


	public String getTest() {
		return test;
	}


	public void setTest(String test) {
		this.test = test;
	}


	public String ajout() {
		//ligne.setProduit(produit);
		System.out.println("Test vaut "+test);
		return "#";
	}
}
