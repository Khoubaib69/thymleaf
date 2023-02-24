package fr.dawan.quizzapp.service;

import java.util.List;

import fr.dawan.quizzapp.entities.Categorie;



public interface ICategorieService {
	List<Categorie> findAll();
	Categorie createCategorie( Categorie categorie); 	
	Categorie findById(Long id);
	void deleteCategorieById(Long id);
	Categorie updateCategorieById(Categorie categorie,long id);

}
