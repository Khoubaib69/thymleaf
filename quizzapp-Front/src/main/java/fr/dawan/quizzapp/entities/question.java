package fr.dawan.quizzapp.entities;

public class question {
	private long questionId;
	private String enonce;
	private boolean multiple;
	private int ordre ;
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public boolean isMultiple() {
		return multiple;
	}
	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public question(String enonce, boolean multiple, int ordre) {
		super();
		this.enonce = enonce;
		this.multiple = multiple;
		this.ordre = ordre;
	}
	public question() {
		super();
	}
	
	

}
