package fr.dawan.quizzapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.quizzapp.entities.Categorie;


@Repository
public interface ICategorieRepository extends JpaRepository<Categorie, Long> {

}
