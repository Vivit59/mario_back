package fr.idformation.mario.security.models;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {
	/** technical id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/** username aka login. */
	@NonNull
	private String username = "...";


	/** password. */
	@NonNull
	private String password = "...";

	/** firstname. */
	@NonNull
	private String firstname = "...";

	/** lastname. */
	@NonNull
	private String lastname = "...";

	/** address.*/
	@NonNull
	private String address = "...";

	/** roles of the user. */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	/**
	 * Default constructor.
	 */
	public User() {
	}

	/**
	 * Construct a new User.
	 *
	 * @param pUsername the username
	 * @param pPassword the password
	 * @param pFirstName the firstname
	 * @param pLastName the lastname
	 * @param pAddress the address
	 */
	public User(final String pUsername, final String pPassword, final String pFirstName, final String pLastName, final String pAddress) {
		this.username = pUsername;
		this.password = pPassword;
		this.firstname = pFirstName;
		this.lastname = pLastName;
		this.address = pAddress;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(final String address) {
		this.address = address;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @return the name of the user
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
	 * @param pId the id to set
	 */
	public void setId(final Long pId) {
		this.id = pId;
	}

	/**
	 * @param pLastname the lastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
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
