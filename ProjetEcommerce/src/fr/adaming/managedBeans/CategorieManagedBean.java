package fr.adaming.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Categorie;
import fr.adaming.service.CategorieServiceImpl;
import fr.adaming.service.ICategorieService;

@ManagedBean(name="categorieMB")
@RequestScoped
public class CategorieManagedBean {
	private List<Categorie> listeTtesCategories;
	private List<Categorie> categoriesSelectionnees;
	
	@EJB
	private ICategorieService categorieService;

	public CategorieManagedBean() {
		super();
	}

	public List<Categorie> getListeTtesCategories() {
		return listeTtesCategories;
	}

	public void setListeTtesCategories(List<Categorie> listeTtesCategories) {
		this.listeTtesCategories = listeTtesCategories;
	}
	
	public List<Categorie> getCategoriesSelectionnees() {
		return categoriesSelectionnees;
	}

	public void setCategoriesSelectionnees(List<Categorie> categoriesSelectionnees) {
		this.categoriesSelectionnees = categoriesSelectionnees;
	}

	@PostConstruct
	public void init(){
		listeTtesCategories=categorieService.getAllCategorie();
		for(Categorie c : listeTtesCategories) {
			System.out.println(c);
		}
		System.out.println("ble");
	}
	public String selectionnerCategories() {
		System.out.println("bla");
		if (categoriesSelectionnees==null){
			System.out.println("scrogneugneu");
		}
//		for(Categorie c : categoriesSelectionnees) {
//			System.out.println(c);
//		}
		return "#";
	}
}
