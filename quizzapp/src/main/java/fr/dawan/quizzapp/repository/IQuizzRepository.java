package fr.dawan.quizzapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.dawan.quizzapp.entities.Quizz;
import fr.dawan.quizzapp.entities.Users;
@Repository
public interface IQuizzRepository extends JpaRepository<Quizz, Long> {
	
	List<Quizz> findAll();
//	Quizz findById(Long Id);
	//@Query("FROM Quizz q where q.quizzId=:id")
	//Quizz findQuizzById (long id);

}
