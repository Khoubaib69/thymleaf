package fr.dawan.quizzapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dawan.quizzapp.entities.Question;
import fr.dawan.quizzapp.entities.Quizz;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {
	//@Query(value="SELECT enonce From Question inner JOIN Quizz WHERE quizz.quizz_id= ?",nativeQuery = true)
	@Query("SELECT ques FROM Question ques WHERE ques.quizz = : quizz")
	List<Question> findQuestionByQuizzId (@Param("quizz")Quizz quizz);

}
