package fr.adaming.managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Admin;

@ManagedBean(name="adminMB")
@RequestScoped
public class AdminMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Attributs
	private Admin admin;

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
		return "home";
	}
}
