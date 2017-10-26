package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name="categorieMB")
@RequestScoped
public class CategorieMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICategorieService categorieService;
	private List<Categorie> listeCategories = new ArrayList<Categorie>();
	private Categorie selectedCategorie = new Categorie();

	public CategorieMB() {
		super();
	}

	public List<Categorie> getListeCategories() {
		return listeCategories;
	}
	public void setListeCategories(List<Categorie> listeCategories) {
		this.listeCategories = listeCategories;
	}
	public Categorie getSelectedCategorie() {
		return selectedCategorie;
	}
	public void setSelectedCategorie(Categorie selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}

	@PostConstruct
	public void init() {
		this.listeCategories = categorieService.getAllCategorie();
	}
	
    public void onCategorieChange() {
    	System.out.println(this.selectedCategorie);
    }
}
