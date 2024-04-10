package fr.idformation.mario.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.idformation.mario.core.domain.Pizza;

@Repository
public interface IPizzaRepository extends JpaRepository<Pizza, Short> {

}
