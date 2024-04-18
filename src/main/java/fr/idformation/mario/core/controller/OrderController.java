/**
 * author Sylvie.
 */
package fr.idformation.mario.core.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.idformation.mario.core.domain.Order;
import fr.idformation.mario.core.dto.OrderDTO;
import fr.idformation.mario.core.dto.mapper.OrderMapper;
import fr.idformation.mario.core.service.IOrderService;

/**
 * the orderController.
 */
@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:3000")
public class OrderController {

	/** order service.*/
	private IOrderService orderService;

	/**
	 * create or update an order.
	 * @param order
	 * @return an new or update order
	 */
	@PostMapping("/")
	public OrderDTO save(@RequestBody final OrderDTO ord) {
		
		return OrderMapper.entityToDto(orderService.save(OrderMapper.dtoToEntity(ord)));
	}
}
