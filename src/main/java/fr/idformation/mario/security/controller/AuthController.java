package fr.idformation.mario.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.idformation.mario.security.Dto.JwtResponse;
import fr.idformation.mario.security.Dto.LoginRequest;
import fr.idformation.mario.security.Dto.TokenRefreshRequest;
import fr.idformation.mario.security.Dto.TokenRefreshResponse;
import fr.idformation.mario.security.Dto.UserDto;
import fr.idformation.mario.security.jwt.JwtProvider;
import fr.idformation.mario.security.jwt.exception.TokenRefreshException;
import fr.idformation.mario.security.models.RefreshToken;
import fr.idformation.mario.security.models.User;
import fr.idformation.mario.security.service.IRefreshTokenService;
import fr.idformation.mario.security.service.impl.UserDetailsServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 * Classe permettant de gérer la sécurité.
 *
 * @author piot
 *
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = { "http://localhost:3666", "https://biller-375810.web.app/" })
public final class AuthController {

	/** token header to use in JWT. */
	@Value("${app.jwtTokenHeader}")
	private String tokenHeader;

	/** import authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;

	/** import jwtprovider. */
	@Autowired
	private JwtProvider tokenProvider;

	/** import refreshToken service. */
	@Autowired
	private IRefreshTokenService refreshTokenService;

	/** import user service. */
	@Autowired
	private UserDetailsServiceImpl userService;

	/**
	 *
	 * @param request a login + password couple
	 * @return a response with the jwt
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody final LoginRequest request) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(request.getUsername());

		User user = userService.loadUserDetails(request.getUsername());

		refreshTokenService.deleteExpired();
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());

		return ResponseEntity.ok(new JwtResponse(tokenHeader + " " + jwt, tokenProvider.getExpiryDate(jwt),
				new UserDto(user), refreshToken.getToken()));
	}

	/**
	 * Get a new token.
	 *
	 * @param request a valid refresh token
	 * @return a new token
	 */
	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@Valid @RequestBody final TokenRefreshRequest request) {
		String requestRefreshToken = request.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken).map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUser).map(user -> {
					String jwt = tokenProvider.generateToken(user.getUsername());
					RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());
					return ResponseEntity.ok(new TokenRefreshResponse(tokenHeader + " " + jwt,
							tokenProvider.getExpiryDate(jwt), refreshToken.getToken()));
				})
				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	}

	/**
	 *
	 * @param userDto a userDto containing at least a username and a list of
	 *                settings
	 * @param request the http request
	 * @return the updated user
	 */
	@PostMapping(value = "/updateSettings")
	public UserDto updateSettings(final @RequestBody UserDto userDto, final HttpServletRequest request) {
		User user = userService.loadUserDetails(userDto.getUsername());

		return new UserDto(userService.update(user));

	}
}
