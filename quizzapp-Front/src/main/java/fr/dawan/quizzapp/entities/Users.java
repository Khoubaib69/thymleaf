package fr.dawan.quizzapp.entities;

public class Users {
	private long userId ;
private String prenom;
	
	private String email;
	
	private String password;
	private boolean admin;
	
	
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public Users() {
		super();
	}
	public Users(String prenom, String email, String password, String nom) {
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
//	public Collection<QuizzTest> getQuizzTest() {
//		return quizzTest;
//	}
//	public void setQuizzTest(Collection<QuizzTest> quizzTest) {
//		this.quizzTest = quizzTest;
//	}
//	public Roles getRole() {
//		return role;
//	}
//	public void setRole(Roles role) {
//		this.role = role;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
	
	
//	private Collection<QuizzTest> quizzTest;
//	
//	private Roles role;
	
	

}
