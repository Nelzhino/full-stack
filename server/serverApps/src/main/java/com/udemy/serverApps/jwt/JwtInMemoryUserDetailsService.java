package com.udemy.serverApps.jwt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.udemy.serverApps.entities.UserRol;
import com.udemy.serverApps.repositories.UserRepository;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.udemy.serverApps.entities.User userEntity = userRepository.findByUsername(username);

		if (userEntity == null) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return buildUser(userEntity);
	}

	private User buildUser(com.udemy.serverApps.entities.User user) {
		return new User(user.getUsername(), user.getPassword(), true, true, true, true,
				buildAuthorities(user.getRoles()));

	}

	private List<GrantedAuthority> buildAuthorities(Set<UserRol> roles) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		roles.forEach(rol -> authorities.add(new SimpleGrantedAuthority(rol.getRol())));
		return new ArrayList<GrantedAuthority>(authorities);
	}

}
