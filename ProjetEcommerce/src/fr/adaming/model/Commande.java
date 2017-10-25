package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="commandes")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_co")
	private long id;
	@Column(name="date_co")
	private Date date;
	@ManyToOne
	@JoinColumn(name="id_cl", referencedColumnName="id_cl")
	private Client client;

	// Constructeurs
	public Commande() {
		super();
	}
	public Commande(Date date) {
		super();
		this.date = date;
	}
	public Commande(long id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	
	// Getters / Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + "]";
	}
}
