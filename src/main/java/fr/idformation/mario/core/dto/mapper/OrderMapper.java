/**
 * author Sylvie.
 */
package fr.idformation.mario.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.idformation.mario.core.domain.Order;
import fr.idformation.mario.core.domain.OrderLine;
import fr.idformation.mario.core.dto.OrderDTO;
import fr.idformation.mario.core.dto.OrderLineDTO;

/**
 * The mapper of the order.
 */
public class OrderMapper {

	/*
	public static OrderDTO orderToDto(final Order order) {
		OrderDTO dto = null;

		if (order != null) {
			dto = new OrderDTO();

			dto.setId(order.getId());
			dto.setUser(order.getUser());
			dto.setDate(order.getDate());
			dto.setTotalAmount(order.getTotalAmount());

			if(order.getOrderLines() != null && !order.getOrderLines().isEmpty()) {
				List<OrderLineDTO> orderLineDTOs = new ArrayList<>();
				for (OrderLineDTO orderLineDTO : orderLineDTOs) {
				    OrderLineDTO orderLine = new OrderLineDTO();
				    orderLineDTO.setId(orderLine.getId());
				    orderLineDTO.setPizza(orderLine.getPizza());
				    orderLineDTO.setQuantity(orderLine.getQuantity());

				    orderLineDTOs.add(orderLineDTO);
				}
				dto.setOrderLines(orderLineDTOs);
			}
		}
		return dto;
	}*/
}
