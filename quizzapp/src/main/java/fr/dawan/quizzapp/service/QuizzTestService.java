package fr.dawan.quizzapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.quizzapp.entities.QuizzTest;
import fr.dawan.quizzapp.repository.IQuizzTestRepository;


@Service
@Transactional
public class QuizzTestService  implements IQuizzTestService{
	@Autowired
	private IQuizzTestRepository qtRepository;
	@Override
	public List<QuizzTest> findAll() {
		// TODO Auto-generated method stub
		return qtRepository.findAll();
	}

	@Override
	public QuizzTest createQuizzTest(QuizzTest quizzTest) {
		// TODO Auto-generated method stub
		return qtRepository.save(quizzTest);
	}

	@Override
	public QuizzTest findById(Long id) {
	Optional <QuizzTest> q = qtRepository.findById(id);
		if (q.isPresent())
		{ return q.get();}
		
		return null;
	}

	@Override
	public void deleteQuizzTestById(Long id) {
		// TODO Auto-generated method stub
		qtRepository.deleteById(id);
		
	}

	@Override
	public QuizzTest updateQuizzTestById(QuizzTest quizzTest, long id) {
		if (quizzTest!= null) {
			quizzTest.setQuizzTestId(id);;
			return qtRepository.saveAndFlush(quizzTest);
		}
		return null;
	}

}
