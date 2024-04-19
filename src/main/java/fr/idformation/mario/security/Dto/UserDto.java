package fr.idformation.mario.security.Dto;

import java.util.Set;

import fr.idformation.mario.security.models.Role;
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

	/** the address. */
	private String address;

	/** the password. */
	private String password;

	/** the list of roles of the user. */
	private Set<Role> roles;

	/** Default constructor. */
	public UserDto() {
		super();
	}


	/**
	 * create a user with all fields.
	 * @param pUser the user to use
	 */
	public UserDto(final User pUser) {
		super();
		this.username = pUser.getUsername();
		this.firstname = pUser.getFirstname();
		this.lastname = pUser.getLastname();
		this.address = pUser.getAddress();
		this.password = pUser.getPassword();
		this.roles = pUser.getRoles();
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
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
	 * @param pRoles the roles to set
	 */
	public void setRoles(final Set<Role> pRoles) {
		this.roles = pRoles;
	}

	/**
	 * @param pUsername the username to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

}
