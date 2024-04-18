/**
 * author Sylvie.
 */
package fr.idformation.mario.core.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.lang.NonNull;

import fr.idformation.mario.security.models.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 *
 */
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class UserPizza {

		/** technical id. */
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;

		/** username aka login. */
		@NonNull
		@Column(name="phonenumber")
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
		@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
		private Set<Role> roles = new HashSet<>();

		/** a user can have several orders. */
		@OneToMany(mappedBy = "user")
		private List<Order> orders;

		/**
		 * Default constructor.
		 */
		public UserPizza() {
		}

		/**
		 * constructor with fields.
		 * @param pId
		 * @param pUsername
		 * @param pPassword
		 * @param pFirstname
		 * @param pLastname
		 * @param pAddress
		 * @param pRoles
		 */
		public UserPizza(final Long pId, final String pUsername, final String pPassword, final String pFirstname,
				final String pLastname, final String pAddress, final Set<Role> pRoles) {
			super();
			this.id = pId;
			this.username = pUsername;
			this.password = pPassword;
			this.firstname = pFirstname;
			this.lastname = pLastname;
			this.address = pAddress;
			this.roles = pRoles;
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
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}

		/**
		 * @param pUsername the username to set
		 */
		public void setUsername(final String pUsername) {
			this.username = pUsername;
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
		 * @return the firstname
		 */
		public String getFirstname() {
			return firstname;
		}

		/**
		 * @param pFirstname the firstname to set
		 */
		public void setFirstname(final String pFirstname) {
			this.firstname = pFirstname;
		}

		/**
		 * @return the lastname
		 */
		public String getLastname() {
			return lastname;
		}

		/**
		 * @param pLastname the lastname to set
		 */
		public void setLastname(final String pLastname) {
			this.lastname = pLastname;
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
		 * @return the roles
		 */
		public Set<Role> getRoles() {
			return roles;
		}

		/**
		 * @param pRoles the roles to set
		 */
		public void setRoles(final Set<Role> pRoles) {
			this.roles = pRoles;
		}

		/**
		 * @return the orders
		 */
		public List<Order> getOrders() {
			return orders;
		}

		/**
		 * @param pOrders the orders to set
		 */
		public void setOrders(final List<Order> pOrders) {
			this.orders = pOrders;
		}

}
