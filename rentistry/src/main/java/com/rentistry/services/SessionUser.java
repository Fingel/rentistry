package com.rentistry.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.rentistry.domain.Authority;
import com.rentistry.domain.RentUser;

public class SessionUser implements UserDetails, CredentialsContainer {
	
	private String userEmail;

    private String firstName;

    private String lastName;

    private String password;

    private Boolean enabled;



	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
    
	private Collection<GrantedAuthority> authorities=null;
	
	public SessionUser(RentUser user){
		updateRoles(user);
		this.userEmail = user.getUserEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.password = user.getPassword();
		this.accountNonExpired=!user.getAccountExpired();
		this.accountNonLocked=!user.getAccountLocked();
		this.credentialsNonExpired=!user.getCredentialsExpired();
		this.enabled=user.getEnabled();
	}

	protected void updateRoles(RentUser user) {
    	Set<Authority> roles=user.getGivenAuthorities();
        authorities=new ArrayList<GrantedAuthority>(roles.size());
        for (Authority authority : roles) { 
        	authorities.add(new GrantedAuthorityImpl(authority.getName()));
        }
    }
	@Override
	public void eraseCredentials() {
		password="NOPASSWORD";

	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.getUserEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

}
