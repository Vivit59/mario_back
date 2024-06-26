package fr.idformation.mario.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.idformation.mario.core.domain.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

}
