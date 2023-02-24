package fr.dawan.quizzapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.quizzapp.entities.Quizz;
import fr.dawan.quizzapp.repository.IQuizzRepository;
@Service
@Transactional
public class QuizzService implements IQuizzService{
	@Autowired
	private IQuizzRepository qRepository;
	@Override
	public List<Quizz> findAll() {
		// TODO Auto-generated method stub
		return qRepository.findAll();
	}

	@Override
	public Quizz createQuizz(Quizz quizz) {
		// TODO Auto-generated method stub
		return qRepository.save(quizz);
	}

	@Override
	public Quizz findById(Long id) {
		Optional<Quizz> q = qRepository.findById(id);
				if (q.isPresent())
				{q.get();}
		
		return null;
	}

	@Override
	public void deleteQuizzById(Long id) {
		qRepository.deleteById(id);
		
	}

	@Override
	public Quizz updateQuizzById(Quizz quizz, long id) {
		if (quizz!= null) {
			quizz.setQuizzId(id);
			return qRepository.saveAndFlush(quizz);
		}
		return null;
	}

}
