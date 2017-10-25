package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="clients")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cl")
	private long id;
	@Column(name="nom_cl")
	private String nom;
	@Column(name="adresse_cl")
	private String adresse;
	@Column(name="email_cl")
	private String email;
	@Column(name="telephone_cl")
	private String telephone;
	
	// Constructeurs
	public Client() {
		super();
	}
	public Client(String nom, String adresse, String email, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}
	public Client(int id, String nom, String adresse, String email, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}

	// Getters / Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", email=" + email + ", telephone="
				+ telephone + "]";
	}
}
