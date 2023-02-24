package fr.dawan.quizzapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fr.dawan.quizzapp.entities.QuizzTest;

@Repository
public interface IQuizzTestRepository extends JpaRepository<QuizzTest, Long>{

}
