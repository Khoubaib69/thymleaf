package fr.dawan.quizzapp.service;

import java.util.List;

import fr.dawan.quizzapp.entities.Question;
import fr.dawan.quizzapp.entities.Quizz;

public interface IQuestionService {
	
	List<Question> findAll();
	Question createQuestion( Question question); 	
	Question findById(Long id);
	void deleteQuestionById(Long id);
	Question updateQuestionById(Question question,long id);
	List<Question> findquestionByIdQuizz (Quizz quizz);
}
