package fr.dawan.quizzapp.service;

import java.util.List;

import fr.dawan.quizzapp.entities.Quizz;

public interface IQuizzService {
	List<Quizz> findAll();
	Quizz createQuizz( Quizz quizz); 	
	Quizz findById(Long id);
	void deleteQuizzById(Long id);
	Quizz updateQuizzById(Quizz quizz,long id);

}
