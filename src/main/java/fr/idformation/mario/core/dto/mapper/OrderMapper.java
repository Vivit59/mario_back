/**
 * author Sylvie.
 */
package fr.idformation.mario.core.dto.mapper;

import fr.idformation.mario.core.domain.Order;
import fr.idformation.mario.core.dto.OrderDTO;

/**
 * The mapper of the order.
 */
public class OrderMapper {

	/**
	 * maps an orderDTO into an order.
	 * @param orderD
	 * @return an order
	 */
	public static Order dtoToEntity (final OrderDTO orderD) {
		Order entity = null;

		if (orderD != null) {
			entity = new Order();

			entity.setId(orderD.getId());
			entity.setUser(orderD.getUser());
			entity.setDate(orderD.getDate());
			entity.setTotalAmount(orderD.getTotalAmount());
			entity.setOrderLines(OrderLineMapper.dtoToLines(orderD.getOrderLines()));
			}

		return entity;
	}
}
