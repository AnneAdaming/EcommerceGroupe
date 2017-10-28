package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.IProduitService;
import fr.adaming.service.ProduitServiceImpl;

@ManagedBean(name = "panierMB")
@SessionScoped
public class PanierMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private Panier panier;
	private LigneCommande ligne;
	private long id;
	private Client client;
	private double total;

	@EJB
	private IProduitService produitService;
	@EJB
	private ICommandeService commandeService;
	@EJB
	private IClientService clientService;

	HttpSession maSession;

	public PanierMB() {
		this.ligne = new LigneCommande();
		this.client = new Client();
	}

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		maSession = (HttpSession) context.getExternalContext().getSession(false);

		this.panier = (Panier) maSession.getAttribute("panier");
		if (panier == null) {
			this.panier = new Panier();
			this.panier.setListe(new ArrayList<LigneCommande>());
			maSession.setAttribute("panier", panier);
		}
		if (maSession.getAttribute("total") != null) {
			total = (double) maSession.getAttribute("total");
		}

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	// Méthodes métier

	public String valider() {
		client = clientService.addClient(client);
		Date date = new Date();
		Commande commande = new Commande(date);
		commande.setListeLigneCommande(panier.getListe());
		commandeService.addCommande(commande, client);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La commande a bien été validée."));
		return "panier";
	}

	public String augmenter() {
		Produit produit = produitService.getProduitById(id);
		boolean existe = false;
		for (LigneCommande ligneP : panier.getListe()) {
			Produit produitCompare = ligneP.getProduit();
			if (produitCompare.getId() == produit.getId()) {
				if (produit.getQuantite() > ligneP.getQuantite()) {
					ligneP.setQuantite(ligneP.getQuantite() + 1);
					ligneP.setTotal(ligneP.getQuantite() * ligneP.getPrix());
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Vous ne pouvez plus rajouter de ce produit."));
				}
				existe = true;
				break;
			}
		}
		if (existe == false) {
			ligne.setProduit(produit);
			ligne.setQuantite(1);
			ligne.setPrix(produit.getPrix());
			panier.getListe().add(ligne);
			ligne.setTotal(ligne.getQuantite() * ligne.getPrix());
		}
		total = 0;
		for (LigneCommande ligne : panier.getListe()) {
			total += ligne.getTotal();
		}
		maSession.setAttribute("total", total);
		return "home";
	}

	public String diminuer() {
		Produit produit = produitService.getProduitById(id);
		boolean existe = false;
		for (LigneCommande ligneP : panier.getListe()) {
			Produit produitCompare = ligneP.getProduit();
			if (produitCompare.getId() == produit.getId()) {
				if (ligneP.getQuantite() == 1) {
					panier.getListe().remove(ligneP);
				} else if (ligneP.getQuantite() > 0) {
					ligneP.setQuantite(ligneP.getQuantite() - 1);
				}
				existe = true;
				break;
			}
		}
		if (existe == false) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Vous n'aviez pas sélectionné ce produit."));
		} else {
			ligne.setTotal((double) ligne.getQuantite() * ligne.getPrix());
		}
		total = 0;
		for (LigneCommande ligne : panier.getListe()) {
			total += ligne.getTotal();
		}
		maSession.setAttribute("total", total);
		return "home";
	}
}
