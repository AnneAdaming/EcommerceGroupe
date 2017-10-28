package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="affichageHomeMB")
@SessionScoped
public class AffichageHomeMB implements Serializable {
	private static final long serialVersionUID = 1L;
	public String[] selectedCategories = {"1", "2", "3"};
	public String valueBarreRecherche;
	
	// Constructeur
	public AffichageHomeMB() {
		super();
	}
	
	// Getters / Setters
	public String[] getSelectedCategories() {
		return selectedCategories;
	}
	public void setSelectedCategories(String[] selectedCategories) {
		this.selectedCategories = selectedCategories;
	}
	public String getValueBarreRecherche() {
		return valueBarreRecherche;
	}
	public void setValueBarreRecherche(String valueBarreRecherche) {
		this.valueBarreRecherche = valueBarreRecherche;
	}

	// Methodes
	public String afficherCategories() {
		for (String s : selectedCategories) {
			System.out.println("catégorie : " + s);
		}
		return "home";
	}
	public List<String> getListeNomProduits() {
		List<String> nomProduits = new ArrayList<String>();
		nomProduits.add("test1");
		nomProduits.add("test2");
		nomProduits.add("testABC");
		nomProduits.add("testAAA");
		nomProduits.add("abc");
		nomProduits.add("aaa");
		return nomProduits;
	}
}
