package fr.adaming.managedBeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import fr.adaming.model.Admin;
import fr.adaming.service.IAdminService;

@ManagedBean(name="adminMB")
@RequestScoped
public class AdminMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Attributs
	private Admin admin;
	
	@EJB
	private IAdminService adminService;

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
		Admin adminOut = adminService.getAdmin("a@a", "a");
		if (adminOut != null) {
			System.out.println("Login");
		}
		return "home";
	}
    public void login(ActionEvent actionEvent) {
    	System.out.println("Login");
    }
}
