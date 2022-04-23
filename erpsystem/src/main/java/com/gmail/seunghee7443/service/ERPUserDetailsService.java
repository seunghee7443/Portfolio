package com.gmail.seunghee7443.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gmail.seunghee7443.dto.UserAuthDTO;
import com.gmail.seunghee7443.entity.User;
import com.gmail.seunghee7443.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ERPUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserName : " + username);
		
		User user = userRepository.findUserId(username).get();
		
		UserAuthDTO userAuthDTO = new UserAuthDTO(
				user.getId(),
				user.getPw(),
				user.getRoleSet().stream().map(
						role -> new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toSet()));
		
		userAuthDTO.setId(user.getId());
		
		log.info(user);
		log.info(userAuthDTO);
		
		return userAuthDTO;
	}

}
