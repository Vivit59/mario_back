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
	 * Create an orderline from an orderlineDTO.
	 * @param dto the dto used as a source
	 * @return an orderline filled with datas from dto
	 */
	public static OrderLine dtoToEntity (final OrderLineDTO dto) {
		OrderLine entity = null;

		if (dto != null) {
			entity = new OrderLine();

			entity.setId(dto.getId());
			entity.setPizza(dto.getPizza());
			entity.setQuantity(dto.getQuantity());
		}

		return entity;
	}

	/**
	 *  maps a list of OrderLineDTO in a list of order lines.
	 * @param linesD
	 * @return a list of order lines
	 */
	public static List<OrderLine> dtoToLines (final List<OrderLineDTO> linesD){
		List<OrderLine> lines = null;
		if (linesD != null) {
			lines = new ArrayList<OrderLine>();
			for (OrderLineDTO lineD :linesD) {
				lines.add(dtoToEntity(lineD));
			}
		}
				return lines;
	}

	/**
	 * Create an orderlineDTo from an orderline.
	 * @param line the line used as a source
	 * @return an orderlineDTO filled with datas from line
	 */
	public static OrderLineDTO entityToDto (final OrderLine line) {
		OrderLineDTO dto = null;

		if (line != null) {
			dto = new OrderLineDTO();

			dto.setId(line.getId());
			dto.setPizza(line.getPizza());
			dto.setQuantity(line.getQuantity());
		}

		return dto;
	}

	/**
	 *  maps a list of OrderLine in a list of orderLineDtos.
	 * @param lines
	 * @return a list of orderLinesDtos
	 */
	public static List<OrderLineDTO> orderLineToDtos (final List<OrderLine> lines){
		List<OrderLineDTO> linesDto = null;
		if (lines != null) {
			linesDto = new ArrayList<OrderLineDTO>();
			for (OrderLine line :lines) {
				linesDto.add(entityToDto(line));
			}
		}
				return linesDto;
	}
}
