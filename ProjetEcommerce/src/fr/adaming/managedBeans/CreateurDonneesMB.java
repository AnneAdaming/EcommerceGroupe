package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IProduitService;

@ManagedBean(name="createurDonneesMB")
@SessionScoped
public class CreateurDonneesMB implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private IAdminService adminService;
	@EJB
	private IClientService clientService;
	@EJB
	private ICategorieService categorieService;
	@EJB
	private IProduitService produitService;
	
	// Constructeur
	public CreateurDonneesMB() {
		super();
	}
	
	// Methodes
	public String remplirDB() {
		adminService.addAdmin(new Admin("a@a", "a"));
		adminService.addAdmin(new Admin("b@b", "b"));
		clientService.addClient(new Client("Gilmour", "David", "11, chemin", "d@g", "1111"));
		clientService.addClient(new Client("Waters", "Roger", "12, chemin", "r@w", "2222"));
		categorieService.addCategorie(new Categorie("cookie", "delicieux et bons pour la santé"));
		categorieService.addCategorie(new Categorie("drogue", "delicieux mais mauvais pour la santé"));
		categorieService.addCategorie(new Categorie("arme", "à manier avec précaution"));
		Categorie c1 = categorieService.getCategorieById(1);
		Categorie c2 = categorieService.getCategorieById(2);
		Categorie c3 = categorieService.getCategorieById(3);
		produitService.addProduit(new Produit("Cookie aux Smarties", "un cookie avec des smarties", "1", 59.99, 200), c1);
		produitService.addProduit(new Produit("Cookie Pere Noel", "un cookie en forme de Pere Noel", "2", 159.99, 30), c1);
		produitService.addProduit(new Produit("Cachet d'Ectasy", "un petit cachet qui vous ruine le cerveau", "1", 1.99, 2000), c2);
		produitService.addProduit(new Produit("Champignon Hallucinogène", "un champignon qui va vous faire planer", "2", 2.99, 5000), c2);
		produitService.addProduit(new Produit("AK-47", "si simple à utiliser qu'un enfant pourrait s'en servir", "1", 4.99, 500), c3);
		produitService.addProduit(new Produit("Bazooka", "KABOOM", "2", 10.99, 300), c3);
		return "home";
	}
}
