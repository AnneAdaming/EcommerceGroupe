package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

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
	
	
	public PanierMB() {
		super();
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


	public String ajout() {
		return null;
	}
}
