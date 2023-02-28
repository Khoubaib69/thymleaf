package fr.dawan.quizzapp.entities;

public class Reponse {
	private long reponseId;
	private String reponse;
	private boolean isCorrect;
	public long getReponseId() {
		return reponseId;
	}
	public void setReponseId(long reponseId) {
		this.reponseId = reponseId;
	}
	
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	public Reponse(String reponse, boolean isCorrect) {
		super();
		this.reponse = reponse;
		this.isCorrect = isCorrect;
	}
	public Reponse() {
		super();
	}
	

}
