package fr.idformation.mario.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.idformation.mario.core.domain.UserPizza;

public interface IUserPizzaRepository extends JpaRepository<UserPizza, Long> {

}
