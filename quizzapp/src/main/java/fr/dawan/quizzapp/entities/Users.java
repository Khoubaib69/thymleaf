package fr.dawan.quizzapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6832247712707550439L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long userId ;
	@Column(nullable=false)
	private String prenom;
	@Column(nullable=false, unique= true)
	private String email;
	@Column(nullable=false)
	private String password;
	@OneToMany(mappedBy ="user")
	private Collection<QuizzTest> quizzTest = new ArrayList<>();
	private boolean admin;
	public boolean isAdmin() {
		return admin;
	}
	public Users() {
		super();
	}
	public Users(String prenom, String email, String password, boolean admin, String nom) {
		super();
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.nom = nom;
	}
	public Users(long userId, String prenom, String email, String password, boolean admin, String nom) {
		super();
		this.userId = userId;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.nom = nom;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	@Column(nullable=false)
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
	public Collection<QuizzTest> getQuizzTest() {
		return quizzTest;
	}
	public void setQuizzTest(Collection<QuizzTest> quizzTest) {
		this.quizzTest = quizzTest;
	}

	


	
	
	

}
