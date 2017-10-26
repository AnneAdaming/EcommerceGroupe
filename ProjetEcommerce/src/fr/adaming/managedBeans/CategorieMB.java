package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name="categorieMB")
@RequestScoped
public class CategorieMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICategorieService categorieService;
	private String[] selectedNomCategories;
	private List<String> listeNomCategories;
	private List<Categorie> listeCategories;

	public CategorieMB() {
		super();
	}
	
	public String[] getSelectedNomCategories() {
		return selectedNomCategories;
	}
	public void setSelectedNomCategories(String[] selectedNomCategories) {
		this.selectedNomCategories = selectedNomCategories;
	}
	public List<String> getListeNomCategories() {
		return listeNomCategories;
	}
	public void setListeNomCategories(List<String> listeNomCategories) {
		this.listeNomCategories = listeNomCategories;
	}
	public List<Categorie> getListeCategories() {
		return listeCategories;
	}
	public void setListeCategories(List<Categorie> listeCategories) {
		this.listeCategories = listeCategories;
	}

	@PostConstruct
	public void init() {
		this.listeCategories = categorieService.getAllCategorie();
		for (Categorie categorie : listeCategories) {
			System.out.println("Categorie : " + categorie);
		}
//		for (int i = 0; i < selectedNomCategories.length; i++) {
//			listeNomCategories.add(listeCategories.get(i).getNomCategorie());
//		}
	}
	
    public void onCategorieChange(ActionEvent actionEvent) {
    	System.out.println("categorie changed");
    }
}
