package fr.adaming.managedBeans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
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
	private String email;
	private String mdp;
	private boolean logged;

	// Constructeur
	public AdminMB() {
		super();
	}
	@PostConstruct
	public void init() {
		this.logged = false;
	}

	// Getters / Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	
	// Methodes
	public String login() {
		if (adminService.getAdmin(this.email, this.mdp) != null) {
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
		this.email = "";
		this.mdp = "";
		this.logged = false;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
