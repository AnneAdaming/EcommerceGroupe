package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	private Map<String,String> mapCategories = new HashMap<String,String>();
	private String nomCategorieChoisie;

	public CategorieMB() {
		super();
	}

	public Map<String, String> getMapCategories() {
		return mapCategories;
	}
	public void setMapCategories(Map<String, String> mapCategories) {
		this.mapCategories = mapCategories;
	}
	public String getNomCategorieChoisie() {
		return nomCategorieChoisie;
	}
	public void setNomCategorieChoisie(String nomCategorieChoisie) {
		this.nomCategorieChoisie = nomCategorieChoisie;
	}

	@PostConstruct
	public void init() {
		List<Categorie> categories = categorieService.getAllCategorie();
		for (Categorie categorie : categories) {
			mapCategories.put(categorie.getNomCategorie(), categorie.getNomCategorie());
		}
	}
	
    public void onCategorieChange() {
    	System.out.println(this.nomCategorieChoisie);
    }
}
