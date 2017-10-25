package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Admin;

public interface IAdminService {
	Admin getAdmin(String email, String mdp);
}
