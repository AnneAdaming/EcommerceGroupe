package fr.adaming.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Admin;
import fr.adaming.service.IAdminService;

@ManagedBean(name="adminMB")
@SessionScoped
public class AdminMB implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private IAdminService adminService;
	private Admin admin;
	private boolean logged;

	// Constructeur
	public AdminMB() {
		super();
		this.logged = false;
	}

	// Getters / Setters
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	// Methodes
	public String login() {
		this.admin = adminService.getAdmin("a@a", "a");
		if (this.admin != null) {
			this.logged = true;
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	public String logout() {
		this.admin = null;
		this.logged = false;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
