package fr.dawan.quizzapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.quizzapp.entities.Reponse;

@Repository
public interface IReponseRepository extends JpaRepository<Reponse, Long> {

}
