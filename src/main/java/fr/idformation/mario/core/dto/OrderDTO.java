/**
 * author Sylvie Debue.
 */
package fr.idformation.mario.core.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import fr.idformation.mario.security.models.User;

/**
 * the orderDTO.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

	/** the id of the orderDTO. */
	private Long id;

	/** a user. */
	private User user;

	/** the date of the order. */
	private  LocalDateTime date;

	/** the total of the order. */
	private Double totalAmount;

    /** the list of the orderlinesDTO. */
	private List<OrderLineDTO> orderLines;

	/** default constructor. */
	public OrderDTO() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Long pId) {
		this.id = pId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param pUser the user to set
	 */
	public void setUser(final User pUser) {
		this.user = pUser;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param pDate the date to set
	 */
	public void setDate(final LocalDateTime pDate) {
		this.date = pDate;
	}

	/**
	 * @return the totalAmount
	 */
	public Double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param pTotalAmount the totalAmount to set
	 */
	public void setTotalAmount(final Double pTotalAmount) {
		this.totalAmount = pTotalAmount;
	}

	/**
	 * @return the orderLines
	 */
	public List<OrderLineDTO> getOrderLines() {
		return orderLines;
	}

	/**
	 * @param pOrderLines the orderLines to set
	 */
	public void setOrderLines(final List<OrderLineDTO> pOrderLines) {
		this.orderLines = pOrderLines;
	}

	/** method toString. */
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", user=" + user + ", date=" + date + ", totalAmount=" + totalAmount
				+ ", orderLines=" + orderLines + "]";
	}

}
