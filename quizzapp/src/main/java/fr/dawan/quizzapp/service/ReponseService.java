package fr.dawan.quizzapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.quizzapp.entities.Reponse;
import fr.dawan.quizzapp.repository.IReponseRepository;

@Service
@Transactional
public class ReponseService implements IReponseService{
@Autowired
private IReponseRepository rRepository;
	@Override
	public List<Reponse> findAll() {
		// TODO Auto-generated method stub
		return rRepository.findAll();
	}

	@Override
	public Reponse createReponse(Reponse reponse) {
		// TODO Auto-generated method stub
		return rRepository.save(reponse);
	}

	@Override
	public Reponse findById(Long id) {
		Optional <Reponse> r = rRepository.findById(id);
		if ( r.isPresent())
		{ return (r.get());}
		
		
		return null;
	}

	@Override
	public void deleteReponseById(Long id) {
		rRepository.deleteById(id);
		
	}

	@Override
	public Reponse updateReponseById(Reponse reponse, long id) {
		if (reponse!= null) {
			reponse.setReponseId(id);;
			return rRepository.saveAndFlush(reponse);
		}
		return null;
	}

}
