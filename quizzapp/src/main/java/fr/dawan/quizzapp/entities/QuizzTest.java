package fr.dawan.quizzapp.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class QuizzTest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8215491007447572810L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long QuizzTestId;
	private double score;
	public long getQuizzTestId() {
		return QuizzTestId;
	}
	public void setQuizzTestId(long quizzTestId) {
		QuizzTestId = quizzTestId;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public LocalDate getDateQuizzTest() {
		return DateQuizzTest;
	}
	public void setDateQuizzTest(LocalDate dateQuizzTest) {
		DateQuizzTest = dateQuizzTest;
	}
	public Quizz getQuizz() {
		return quizz;
	}
	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private LocalDate DateQuizzTest;
	
	@ManyToOne
	private Quizz quizz;
	@ManyToOne
	private Users user;
}
