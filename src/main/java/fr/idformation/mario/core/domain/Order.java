/**
 * .
 */
package fr.idformation.mario.core.domain;

import java.time.LocalDateTime;
import java.util.List;

import fr.idformation.mario.security.models.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * The entity order.
 */
@Entity
@Table(name="`order`")
public class Order {

	/** the unique id of the order. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	/** the id of the client.*/
	//an order is associated with an user.
	@ManyToOne
	@JoinColumn(name = "usr_id", nullable = false)
	private User user;

	/** the date of the order. */
	@Column(name="date", nullable = false)
	private  LocalDateTime date;

	/** the total of the order. */
	@Column(name="total_amount", nullable = false)
	private Double totalAmount;

	/** the list of the orderlines. */
	// an order can have multiple order lines.
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

	/**
	 * default constructor.
	 */
	public Order() {
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
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	/**
	 * @param pOrderLines the orderLines to set
	 */
	public void setOrderLines(final List<OrderLine> pOrderLines) {
		this.orderLines = pOrderLines;
	}

	/** method toString. */
	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", date=" + date + ", totalAmount=" + totalAmount
				+ ", orderLines=" + orderLines + "]";
	}

}
