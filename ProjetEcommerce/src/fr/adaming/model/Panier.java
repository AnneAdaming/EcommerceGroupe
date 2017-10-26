package fr.adaming.model;

import java.util.List;

public class Panier {
	// Attribut
	private List<LigneCommande> liste;

	//Constructeur
	public Panier() {
		super();
	}

	public Panier(List<LigneCommande> liste) {
		super();
		this.liste = liste;
	}

	//Getters et setters
	public List<LigneCommande> getListe() {
		return liste;
	}

	public void setListe(List<LigneCommande> liste) {
		this.liste = liste;
	}

	@Override
	public String toString() {
		return "Panier [liste=" + liste + "]";
	}
	
}
