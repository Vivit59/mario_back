/**
 * author Sylvie.
 */
package fr.idformation.mario.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import fr.idformation.mario.core.domain.Pizza;

/**
 *  the object OrderLineDTO.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderLineDTO {

	/** the id of the DTO. */
	private Long id;

    /** a pizza. */
	private Pizza pizza;

    /** the quantity of the pizza. */
	private int quantity;

    /** the default constructor. */
	public OrderLineDTO() {
		super();
	}

	/**
	 *
	 * @return the id
	 */
	public Long getId() {
        return id;
    }

    /**
     *
     * @param pId the id to set
     */
	public void setId(final Long pId) {
        this.id = pId;
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
     * @param pPizza the pizza to set
     */
	public void setPizza(final Pizza pPizza) {
        this.pizza = pPizza;
    }

    /**
     *
     * @return the quantity of the pizza
     */
	public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param pQuantity the quantity to set
     */
	public void setQuantity(final int pQuantity) {
        this.quantity = pQuantity;
    }
}
