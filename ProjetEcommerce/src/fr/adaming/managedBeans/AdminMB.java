package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@ManagedBean(name="adminMB")
@RequestScoped
public class AdminMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Attributs
	private Admin admin;
	
	@EJB
	private IProduitService produitService;
	@EJB
	private ICategorieService categorieService;

	// Constructeur
	public AdminMB() {
		super();
	}

	// Getters / Setters
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	// Methodes
	public String login() {
		System.out.println("LOGIN LOGIN LOGIN LOGIN");
		Categorie c1=new Categorie("Mobilier", "Tout plein de meubles");
		Categorie c2=new Categorie("Cuisine", "Pour faire à manger");
		categorieService.addCategorie(c1);
		categorieService.addCategorie(c2);
		
		/*List<Produit> listeProduits=produitService.getAllProduit();
		for (Produit p : listeProduits) {
			System.out.println(p);
		}*/
		return "home";
	}
}
