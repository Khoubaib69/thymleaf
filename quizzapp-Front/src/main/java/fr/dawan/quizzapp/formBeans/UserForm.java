package fr.dawan.quizzapp.formBeans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserForm {
	private long userId;
	@NotEmpty
	private String prenom;
	@Email
	private String email;
	@NotEmpty
	private String password;
	private boolean admin;

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public UserForm() {
		super();
	}

	public UserForm(String prenom, String email, String password, String nom) {
		super();
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.nom = nom;
	}

	private String nom;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
