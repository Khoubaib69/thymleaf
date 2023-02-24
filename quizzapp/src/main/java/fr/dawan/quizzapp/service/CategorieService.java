package fr.dawan.quizzapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.quizzapp.entities.Categorie;
import fr.dawan.quizzapp.repository.ICategorieRepository;


@Service
@Transactional
public class CategorieService implements ICategorieService {
	@Autowired
	private ICategorieRepository cRepository;
	@Override
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub
		return cRepository.findAll();
	}

	@Override
	public Categorie createCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return cRepository.save(categorie);
	}

	@Override
	public Categorie findById(Long id) {
		Optional <Categorie> c = cRepository.findById(id);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}

	@Override
	public void deleteCategorieById(Long id) {
		// TODO Auto-generated method stub
		cRepository.deleteById(id);
	}

	@Override
	public Categorie updateCategorieById(Categorie categorie, long id) {
		if (categorie!= null) {
			categorie.setCategorieId(id);;
			return cRepository.saveAndFlush(categorie);
		}
		return null;
	}

}
