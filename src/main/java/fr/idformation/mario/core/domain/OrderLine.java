/**
 * author Sylvie Debue.
 */
package fr.idformation.mario.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * OrderLine entity.
 */
@Entity
@Table(name = "order_line")
public class OrderLine {

	/**
	 * technical id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /** an order. */
	// an order line is associated with an order
	@ManyToOne
    @JoinColumn(name = "ord_id", nullable = false)
    private Order order;

    /** a pizza. */
	// an order line is associated with a pizza
	@ManyToOne
    @JoinColumn(name = "piz_id", nullable = false)
    private Pizza pizza;

    /** quantity. */
	@Column(nullable = false)
    private int quantity;

    /** Default constructor. */
    public OrderLine() {
		super();
	}

	/**
	 *
	 * @return an id
	 */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param pId
     */
	public void setId(final Long pId) {
        this.id = pId;
    }

    /**
     *
     * @return an order
     */
	public Order getOrder() {
        return order;
    }

    /**
     *
     * @param pOrder
     */
    public void setOrder(final Order pOrder) {
        this.order = pOrder;
    }

    /**
     *
     * @return a pizza
     */
    public Pizza getPizza() {
        return pizza;
    }

    /**
     *
     * @param pPizza
     */
    public void setPizza(final Pizza pPizza) {
        this.pizza = pPizza;
    }

    /**
     *
     * @return a quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param pQuantity
     */
    public void setQuantity(final int pQuantity) {
        this.quantity = pQuantity;
    }
}
