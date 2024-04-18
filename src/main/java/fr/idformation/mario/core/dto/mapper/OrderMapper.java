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

	/**
	 * maps an order into an orderDTO.
	 * @param order
	 * @return an orderDTO
	 */
	public static OrderDTO entityToDto(final Order order) {
		OrderDTO dto = null;
		if (order != null) {
			dto = new OrderDTO();

			dto.setId(order.getId());
			dto.setUser(order.getUser());
			dto.setDate(order.getDate());
			dto.setTotalAmount(order.getTotalAmount());
			dto.setOrderLines(OrderLineMapper.orderLineToDtos(order.getOrderLines()));
		}
		return dto;
	}
}
