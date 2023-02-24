package fr.dawan.quizzapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.quizzapp.entities.Question;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {

}
