/**
 * author Sylvie.
 */
package fr.idformation.mario.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.idformation.mario.security.models.Role;
import fr.idformation.mario.security.models.RoleName;

/**
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	/**
	 * method to find a RoleName.
	 * @param name
	 * @return a RoleName
	 */

	Optional<Role> findByName(RoleName name);
}
