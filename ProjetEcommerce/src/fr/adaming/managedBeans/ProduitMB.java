package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name="produitMB")
@RequestScoped
public class ProduitMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IProduitService produitService;
	private List<Produit> listeProduits;
	
	public ProduitMB() {
		super();
	}
	
	public List<Produit> getListeProduits() {
		return listeProduits;
	}
	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	@PostConstruct
	private void init() {
		this.listeProduits = produitService.getAllProduit();
	}
}
