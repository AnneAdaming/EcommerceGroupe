package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ligneCommandes")
public class LigneCommande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_li")
	private long id;
	@Column(name="quantite_li")
	private int quantite;
	@Column(name="prix_li")
	private int prix;
	
	// Constructeurs
	public LigneCommande() {
		super();
	}
	public LigneCommande(int quantite, int prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}
	public LigneCommande(long id, int quantite, int prix) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prix = prix;
	}
	
	// Getters / Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantite=" + quantite + ", prix=" + prix + "]";
	}
}
