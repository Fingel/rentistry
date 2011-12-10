package com.rentistry.services;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rentistry.domain.RentUser;

public class UserManager implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		RentUser user = RentUser.findUserByUserEmail(username);
		return new SessionUser(user);
	}
	

}
