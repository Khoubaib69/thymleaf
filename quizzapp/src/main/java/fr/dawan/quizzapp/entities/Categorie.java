package fr.dawan.quizzapp.entities;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity 

public class Categorie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 978634654256534029L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categorieId;
	private String categorieName;
	@OneToMany(mappedBy ="categorie")
	private Collection<Quizz> quizzes;
	public Long getCategorieId() {
		return categorieId;
	}
	public void setCategorieId(Long categorieId) {
		this.categorieId = categorieId;
	}
	public String getCategorieName() {
		return categorieName;
	}
	public void setCategorieName(String categorieName) {
		this.categorieName = categorieName;
	}
	public Collection<Quizz> getQuizzes() {
		return quizzes;
	}
	public void setQuizzes(Collection<Quizz> quizzes) {
		this.quizzes = quizzes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
