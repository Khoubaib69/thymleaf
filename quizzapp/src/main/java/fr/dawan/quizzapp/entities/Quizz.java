package fr.dawan.quizzapp.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
public class Quizz  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5156987783423833642L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long quizzId;
	private String quizzName;

	@OneToMany(mappedBy ="quizz")
	private Collection<Question> questions = new ArrayList<>();
	
	
	@ManyToOne
	private Categorie categorie;
	

	
	@OneToMany(mappedBy ="quizz")
	private Collection<QuizzTest> quizztest;
	
	public Long getQuizzId() {
		return quizzId;
	}


	public void setQuizzId(Long quizzId) {
		this.quizzId = quizzId;
	}


	public String getQuizzName() {
		return quizzName;
	}


	public void setQuizzName(String quizzName) {
		this.quizzName = quizzName;
	}


	public Collection<QuizzTest> getQuizztest() {
		return quizztest;
	}


	public void setQuizztest(Collection<QuizzTest> quizztest) {
		this.quizztest = quizztest;
	}


	public Collection<Question> getQuestion() {
		return questions;
	}


	public void setQuestion(Collection<Question> question) {
		this.questions = question;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
