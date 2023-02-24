package fr.dawan.quizzapp.service;

import java.util.List;

import fr.dawan.quizzapp.entities.QuizzTest;

public interface IQuizzTestService {
	List<QuizzTest> findAll();
	QuizzTest createQuizzTest( QuizzTest quizzTest); 	
	QuizzTest findById(Long id);
	void deleteQuizzTestById(Long id);
	QuizzTest updateQuizzTestById(QuizzTest quizzTest,long id);


}
