package fr.dawan.quizzapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1151891947894571471L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long questionId;
	private String enonce;
	private boolean multiple;
	private int ordre ;
	
	
	public Question(long questionId, String enonce, boolean multiple, int ordre) {
		super();
		this.questionId = questionId;
		this.enonce = enonce;
		this.multiple = multiple;
		this.ordre = ordre;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	@ManyToOne
	@JoinColumn(name="CODE_QUIZZ")
	private Quizz quizz;
	



	public Question() {
		super();
	}

	public Question(String enonce, boolean multiple, int ordre) {
		super();
		this.enonce = enonce;
		this.multiple = multiple;
		this.ordre = ordre;
	}

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

	public Quizz getQuizz() {
		return quizz;
	}

	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}

	public Collection<Reponse> getReponse() {
		return reponses;
	}

	public void setReponse(Collection<Reponse> reponse) {
		this.reponses = reponse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToMany(mappedBy ="question")
	private Collection<Reponse> reponses= new ArrayList<>();


}
