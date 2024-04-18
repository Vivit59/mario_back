/**
 * author Sylvie.
 */
package fr.idformation.mario.core.service;

import fr.idformation.mario.core.domain.Order;

/**
 * the service for the order.
 */
public interface IOrderService {

	/**
	 * method to create or update an order.
	 * @param order
	 * @return an new order
	 */
	Order save(Order order);

}
