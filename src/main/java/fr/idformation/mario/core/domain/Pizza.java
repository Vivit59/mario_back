/**
 * author Sylvie Debue.
 */
package fr.idformation.mario.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The entity pizza.
 */
@Entity
@Table(name="pizza")
public class Pizza {

	/** unique id of a pizza. */
	@Id
	@Column(name="id")
	private Short id;

	/** pizza's name. */
	@Column(name="name")
	private String name;

	/** the pizza's description. */
	@Column(name="description")
	private String description;

	/** the pizza's picture. */
	@Column(name="image")
	private String image;

	/** the pizza's price. */
	@Column(name="price")
	private Short price;

	/**
	 * Default constructor.
	 */
	public Pizza() {
		super();
	}

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Short pId) {
		this.id = pId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param pName the name to set
	 */
	public void setName(final String pName) {
		this.name = pName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param pDescription the description to set
	 */
	public void setDescription(final String pDescription) {
		this.description = pDescription;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param pImage the image to set
	 */
	public void setImage(final String pImage) {
		this.image = pImage;
	}

	/**
	 * @return the price
	 */
	public Short getPrice() {
		return price;
	}

	/**
	 * @param pPrice the price to set
	 */
	public void setPrice(final Short pPrice) {
		this.price = pPrice;
	}
}
