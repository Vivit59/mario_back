/**
 * author Sylvie.
 */
package fr.idformation.mario.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.idformation.mario.core.dto.OrderDTO;
import fr.idformation.mario.core.dto.mapper.OrderMapper;
import fr.idformation.mario.core.service.IOrderService;
import fr.idformation.mario.security.jwt.JwtAuthenticationFilter;
import fr.idformation.mario.security.jwt.JwtProvider;
import fr.idformation.mario.security.models.User;
import fr.idformation.mario.security.service.impl.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

/**
 * the orderController.
 */
@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:3000")
public class OrderController {

	/** order service.*/
	private IOrderService orderService;

	/** jwt authenticationFilter.*/
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	/** a jwt token provider. */
	@Autowired
	private JwtProvider jwtProvider;

	/** a service able to provide access to the users details. */
	@Autowired
	private UserDetailsServiceImpl userDetails;

	/**
	 * create or update an order.
	 * @param ord
	 * @param request
	 * @return an new or update order
	 */
	@PostMapping("/")
	public OrderDTO save(@RequestBody final OrderDTO ord, final HttpServletRequest request) {

		// Récupérer le jwt depuis la requête
		String jwt = jwtAuthenticationFilter.getJwtFromRequest(request);

		//Extraire le username du jwt token
		String username = jwtProvider.getUserUsernameFromJWT(jwt);

		// Charger les détails du user
		User user = userDetails.loadUserDetails(username);

		// Récupérer l'id du user
		ord.getUser().setId(user.getId());

		return OrderMapper.entityToDto(orderService.save(OrderMapper.dtoToEntity(ord)));
	}
}
