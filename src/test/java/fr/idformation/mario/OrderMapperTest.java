/**
 *
 */
package fr.idformation.mario;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.idformation.mario.core.domain.Order;
import fr.idformation.mario.core.dto.OrderDTO;
import fr.idformation.mario.core.dto.mapper.OrderMapper;

/**
 *
 */
@SpringBootTest
public class OrderMapperTest {

	/** Test to convert null to entity.*/
	@Test
    public void convertNullToEntity() {
        // given
        OrderDTO dto = null;

        // when
        Order order = OrderMapper.dtoToEntity(dto);

        // then
        assertThat(order).isNull();
    }

	/** test to convert a dto into an entity.*/
	@Test
    public void convertDtoToEntity() {
        // given
        OrderDTO dto = new OrderDTO();
        dto.setId((long) 1 );

        // when
        Order order = OrderMapper.dtoToEntity(dto);

        // then
        assertThat(order).isNotNull();
        assertThat(order.getId()).isEqualTo(dto.getId());
        assertThat(order.getUser()).isEqualTo(dto.getUser());
        assertThat(order.getDate()).isEqualTo(dto.getDate());
        assertThat(order.getTotalAmount()).isEqualTo(dto.getTotalAmount());

    }

	/** Test to convert null to dto.*/
	@Test
	    public void convertNullToDto() {
	        // given
	        Order order = null;

	        // when
	        OrderDTO dto = OrderMapper.entityToDto(order);

	        // then
	        assertThat(dto).isNull();
	    }

	/** Test to convert an entity into a dto. */
	@Test
	    public void convertEntityToDto() {
	        // given
	        Order order = new Order();
	        order.setId((long) 1);

	        // when
	        OrderDTO dto = OrderMapper.entityToDto(order);

	        // then
	        assertThat(dto).isNotNull();
	        assertThat(dto.getId()).isEqualTo(order.getId());
	        assertThat(dto.getUser()).isEqualTo(order.getUser());
	        assertThat(dto.getDate()).isEqualTo(order.getDate());
	        assertThat(dto.getTotalAmount()).isEqualTo(order.getTotalAmount());
	    }

	/** test to call the default constructor. */
	@Test
	public void callDefaultConstructor() {
	    // given

	    // when
	    OrderMapper orderMapper = new OrderMapper();

	    // then
	    assertThat(orderMapper).isInstanceOf(OrderMapper.class);
	}
}
