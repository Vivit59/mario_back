/**
 *
 */
package fr.idformation.mario.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.idformation.mario.core.domain.UserPizza;
import fr.idformation.mario.core.repository.IUserPizzaRepository;

/**
 *
 */
@RestController
@RequestMapping("/user")
public class UserPizzaController {

	/**  userPizza Repository.*/
	@Autowired
	private IUserPizzaRepository userRepository;

	/**
	 *
	 * @param newUser
	 * @return a new user
	 */
	@PostMapping("/")
	UserPizza newUser (@RequestBody final UserPizza newUser) {
		return userRepository.save(newUser);
	}
}
