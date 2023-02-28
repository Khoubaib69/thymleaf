package fr.dawan.quizzapp.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Reponse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	@JsonIgnore
	@ManyToOne
	private Question question;
	

}
