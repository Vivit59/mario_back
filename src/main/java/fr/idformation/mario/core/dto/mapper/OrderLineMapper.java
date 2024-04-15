/**
 * author Sylvie.
 */
package fr.idformation.mario.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.idformation.mario.core.domain.OrderLine;
import fr.idformation.mario.core.dto.OrderLineDTO;

/**
 * the mapper of the OrderLine.
 */
public class OrderLineMapper {

	/**
	 *
	 * @param pOrderLine an orderLine
	 * @return the orderLine turned in its sibling OrderLine
	 */
	public static OrderLineDTO orderLineToDto (final OrderLine pOrderLine) {
		OrderLineDTO dto = null;

		if (pOrderLine != null) {
			dto= new OrderLineDTO();

			dto.setId(pOrderLine.getId());
			dto.setPizza(pOrderLine.getPizza());
			dto.setQuantity(pOrderLine.getQuantity());
		}

		return dto;
	}

	/**
	 *
	 * @param pLines
	 * @return the sibling DTO list of orderlines
	 */
	public static List<OrderLineDTO> orderLinesToDtos (final List<OrderLine> pLines){
		List<OrderLineDTO> dtos = null;

		if (pLines != null) {
			dtos = new ArrayList<OrderLineDTO>();
			for(OrderLine orderLine : pLines) {
				dtos.add(orderLineToDto(orderLine));
			}
		}
		return dtos;
	}

}
