package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="agents")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ag")
	private long id;
	@Column(name="email_ag")
	private String email;
	@Column(name="mdp_ag")
	private String mdp;
	
	// Constructeurs
	public Admin() {
		super();
	}
	public Admin(String email, String mdp) {
		super();
		this.email = email;
		this.mdp = mdp;
	}
	public Admin(long id, String email, String mdp) {
		super();
		this.id = id;
		this.email = email;
		this.mdp = mdp;
	}
	
	// Getters / Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", mdp=" + mdp + "]";
	}
}
