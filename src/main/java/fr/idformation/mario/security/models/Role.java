package fr.idformation.mario.security.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	/** technical ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** Name of the role. */
	@Enumerated(EnumType.STRING)
	private RoleName name;

	/** set of users.*/
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();

	/** default constructor. */
	public Role() {
	}

	/**
	 * constructor from a rolename.
	 *
	 * @param pName a rolename
	 */
	public Role(final RoleName pName) {
		this.name = pName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the rolename
	 */
	public RoleName getName() {
		return name;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Integer pId) {
		this.id = pId;
	}

	/**
	 * @param pName the rolename to set
	 */
	public void setName(final RoleName pName) {
		this.name = pName;
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param pUsers the users to set
	 */
	public void setUsers(final Set<User> pUsers) {
		this.users = pUsers;
	}

}
