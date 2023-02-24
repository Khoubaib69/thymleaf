package fr.dawan.quizzapp.service;

import java.util.List;

import fr.dawan.quizzapp.entities.Question;

public interface IQuestionService {
	
	List<Question> findAll();
	Question createQuestion( Question question); 	
	Question findById(Long id);
	void deleteQuestionById(Long id);
	Question updateQuestionById(Question question,long id);

}
