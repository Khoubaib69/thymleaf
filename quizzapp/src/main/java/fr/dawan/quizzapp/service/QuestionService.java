package fr.dawan.quizzapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.quizzapp.entities.Question;
import fr.dawan.quizzapp.entities.Quizz;
import fr.dawan.quizzapp.repository.IQuestionRepository;

@Service
@Transactional
public class QuestionService implements IQuestionService{
	
	@Autowired
	private IQuestionRepository questionRepository;

	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

	@Override
	public Question createQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionRepository.save(question);
	}

	@Override
	public Question findById(Long id) {
		Optional <Question> q = questionRepository.findById(id);
		if (q.isPresent())
		{return q.get();}
		
		
		return null;
	}

	@Override
	public void deleteQuestionById(Long id) {
		questionRepository.deleteById(id);
	}

	@Override
	public Question updateQuestionById(Question question, long id) {
		if (question!= null) {
			question.setQuestionId(id);
			return questionRepository.saveAndFlush(question);
		}
		return null;
	}

	@Override
	public List<Question> findquestionByIdQuizz(Quizz quizz) {
		
		return questionRepository.findQuestionByQuizzId(quizz);
	}

}
