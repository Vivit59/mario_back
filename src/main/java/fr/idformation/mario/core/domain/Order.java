/**
 * .
 */
package fr.idformation.mario.core.domain;

import java.time.LocalDateTime;
import java.util.Date;
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
@Table(name="order")
public class Order {

	/** the unique id of the order. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	/** the id of the client.*/
	//une commande est associée à un seul utilisateur.
	@ManyToOne
	@JoinColumn(name = "usr_id", nullable = false)
	private User user;

	/** the date of the order. */
	@Column(name="date", nullable = false)
	private  LocalDateTime date;

	/** the total of the order. */
	@Column(name="total_amount", nullable = false)
	private Double totalAmount;
	
	// une commande peut avoir plusieurs lignes de commande
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

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
	 * @param user the user to set
	 */
	public void setUser(final User user) {
		this.user = user;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(final LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the totalAmount
	 */
	public Double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(final Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the orderLines
	 */
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	/**
	 * @param orderLines the orderLines to set
	 */
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	
	
	
}
