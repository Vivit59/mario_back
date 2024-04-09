package fr.idformation.mario.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.idformation.mario.core.domain.Pizza;

public interface IPizzaRepository extends JpaRepository<Pizza, Short> {

}
