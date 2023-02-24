package fr.dawan.quizzapp.service;

import java.util.List;

import fr.dawan.quizzapp.entities.Reponse;

public interface IReponseService {
	List<Reponse> findAll();
	Reponse createReponse( Reponse reponse); 	
	Reponse findById(Long id);
	void deleteReponseById(Long id);
	Reponse updateReponseById(Reponse reponse,long id);


}
