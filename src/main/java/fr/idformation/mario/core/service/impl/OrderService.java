package fr.idformation.mario.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.idformation.mario.core.repository.IOrderRepository;
import fr.idformation.mario.core.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	/** repository for the orders.*/
	@Autowired
	private IOrderRepository orderRepo;


}
