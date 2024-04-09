package fr.idformation.mario.security.Dto;

import fr.idformation.mario.security.models.User;

/**
 * This class represents the details of a user.
 */
public class UserDto {

	/** the login. */
	private String username;

	/** the firstname. */
	private String firstname;

	/** the lastname. */
	private String lastname;

	/** the role of the user. */
	private String role;

	/** the address of the user.*/
	private String address;

	/** Default constructor. */
	public UserDto() {
		super();
	}

	/**
	 * Create a new UserDto from a User.
	 *
	 * @param pUser the user to use
	 */
	public UserDto(final User pUser) {
		this.username = pUser.getUsername();
		this.firstname = pUser.getFirstname();
		this.lastname = pUser.getLastname();
		this.role = pUser.getRoles().iterator().next().getName().name();
		this.address = pUser.getAddress();

	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param pAddress the address to set
	 */
	public void setAddress(final String pAddress) {
		this.address = pAddress;
	}

	/**
	 * @param pFirstname the firstname to set
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * @param pLastname the lastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @param pRole the role to set
	 */
	public void setRole(final String pRole) {
		this.role = pRole;
	}

	/**
	 * @param pUsername the username to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

}
