/**
 * author Sylvie Debue.
 */
package fr.idformation.mario.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * pizza dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PizzaDTO {

	/** the id of pizza. */
	private Short id;

	/** pizza's name. */
	private String name;

	/** pizza'description. */
	private String description;

	/** pizza's image.*/
	private String image;

	/** pizza's price. */
	private Short price;

	/**
	 *  default constructor.
	 */
	public PizzaDTO() {
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
