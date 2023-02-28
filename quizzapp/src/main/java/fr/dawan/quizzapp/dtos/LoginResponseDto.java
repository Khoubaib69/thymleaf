package fr.dawan.quizzapp.dtos;

import java.io.Serializable;

public class LoginResponseDto implements Serializable{

	private int userId;
	private String nom;
	private String prenom;
	
	public LoginResponseDto() {
		super();
	}
	public LoginResponseDto(String nom, String prenom, String email, boolean admin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.admin = admin;
	}
	private String email;
	private boolean admin;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	} 

	
	
	
	



}