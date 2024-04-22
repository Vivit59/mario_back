/**
 * author Sylvie.
 */
package fr.idformation.mario;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.idformation.mario.core.domain.OrderLine;
import fr.idformation.mario.core.dto.OrderLineDTO;
import fr.idformation.mario.core.dto.mapper.OrderLineMapper;

/**
 * Tests for the OrderLineMapper.
 */
public class OrderLineMapperTest {


	/** test to convert null to entity. */
	@Test
    public void convertNullToEntity() {
        // given
        OrderLineDTO dto = null;

        // when
        OrderLine orderLine = OrderLineMapper.dtoToEntity(dto);

        // then
        assertThat(orderLine).isNull();
    }

	/** test convert dto to an entity. */
	@Test
    public void convertDtoToEntity() {
        // given
        OrderLineDTO dto = new OrderLineDTO();
        dto.setId((long) 1);
        // Set other properties as needed

        // when
        OrderLine orderLine = OrderLineMapper.dtoToEntity(dto);

        // then
        assertThat(orderLine).isNotNull();
        assertThat(orderLine.getId()).isEqualTo(dto.getId());
        assertThat(orderLine.getPizza()).isEqualTo(dto.getPizza());
        assertThat(orderLine.getQuantity()).isEqualTo(dto.getQuantity());
    }

	/** Test ListDto null to Entity List.*/
	@Test
    public void convertNullListToEntityList() {
        // given
        List<OrderLineDTO> dtoList = null;

        // when
        List<OrderLine> orderLines = OrderLineMapper.dtoToLines(dtoList);

        // then
        assertThat(orderLines).isNull();
    }

	/** test convert a dto list to an entity list. */
	@Test
    public void convertDtoListToEntityList() {
        // given
        List<OrderLineDTO> dtoList = new ArrayList<>();
        OrderLineDTO dto = new OrderLineDTO();
        dtoList.add(dto);

        // when
        List<OrderLine> orderLines = OrderLineMapper.dtoToLines(dtoList);

        // then
        assertThat(orderLines).isNotNull();
        assertThat(orderLines).hasSize(dtoList.size());
        assertThat(orderLines.get(0).getId()).isEqualTo(dtoList.get(0).getId());
        assertThat(orderLines.get(0).getPizza()).isEqualTo(dtoList.get(0).getPizza());
        assertThat(orderLines.get(0).getQuantity()).isEqualTo(dtoList.get(0).getQuantity());
    }

	/** test to convert a null orderLine into a dto. */
	@Test
    public void convertNullToDto() {
        // given
        OrderLine orderLine = null;

        // when
        OrderLineDTO dto = OrderLineMapper.entityToDto(orderLine);

        // then
        assertThat(dto).isNull();
    }

	/** Test to convert an entity to a dto. */
	@Test
    public void convertEntityToDto() {
        // given
        OrderLine orderLine = new OrderLine();
        orderLine.setId((long) 1);

        // when
        OrderLineDTO dto = OrderLineMapper.entityToDto(orderLine);

        // then
        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(orderLine.getId());
        assertThat(dto.getPizza()).isEqualTo(orderLine.getPizza());
        assertThat(dto.getQuantity()).isEqualTo(orderLine.getQuantity());
    }

	/** Test convert null orderLinesList to dtoList. */
	@Test
    public void convertNullListToDtoList() {
        // given
        List<OrderLine> orderLines = null;

        // when
        List<OrderLineDTO> dtoList = OrderLineMapper.orderLineToDtos(orderLines);

        // then
        assertThat(dtoList).isNull();
    }

	/** Test to convert an orderLineList to a dtoList. */
	@Test
    public void convertEntityListToDtoList() {
        // given
        List<OrderLine> orderLines = new ArrayList<>();
        OrderLine orderLine1 = new OrderLine();
        orderLine1.setId((long) 1);
        orderLines.add(orderLine1);

        // when
        List<OrderLineDTO> dtoList = OrderLineMapper.orderLineToDtos(orderLines);

        // then
        assertThat(dtoList).isNotNull();
        assertThat(dtoList).hasSize(orderLines.size());
        assertThat(dtoList.get(0).getId()).isEqualTo(orderLines.get(0).getId());
        assertThat(dtoList.get(0).getPizza()).isEqualTo(orderLines.get(0).getPizza());
        assertThat(dtoList.get(0).getQuantity()).isEqualTo(orderLines.get(0).getQuantity());
    }

	/** Test to call the default constructor. */
	@Test
	public void callDefaultConstructor() {
		// given

		// when
		OrderLineMapper orderLineMapper = new OrderLineMapper();

		// then
		assertThat(orderLineMapper).isInstanceOf(OrderLineMapper.class);
	}
}
