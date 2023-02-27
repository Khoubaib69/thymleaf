package fr.dawan.quizzapp.entities;

public class reponse {
	private long reponseId;
	private String text;
	private boolean isCorrect;
	public long getReponseId() {
		return reponseId;
	}
	public void setReponseId(long reponseId) {
		this.reponseId = reponseId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public reponse(String text, boolean isCorrect) {
		super();
		this.text = text;
		this.isCorrect = isCorrect;
	}
	public reponse() {
		super();
	}
	

}
