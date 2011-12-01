package com.rentistry.domain;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.Transient;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findRentUsersByUserEmailEquals" })
public class RentUser implements UserDetails, CredentialsContainer {

    private String userEmail;

    private String firstName;

    private String lastName;

    private String password;

    private Boolean enabled;

    private Boolean accountExpired;

    private Boolean credentialsExpired;

    private Boolean accountLocked;
    
    @Transient
    Collection<GrantedAuthority> grantedAuthorities;

    @OneToOne
    private Account account;
    
    public static RentUser findUserByUserEmail(String userEmail) {
        if (userEmail == null || userEmail.length() == 0) throw new IllegalArgumentException("The userEmail argument is required");
        EntityManager em = RentUser.entityManager();
        Query q = em.createQuery("SELECT RentUser FROM RentUser AS rentuser WHERE rentuser.userEmail = :userEmail");
        q.setParameter("userEmail", userEmail);
        try{
        	return (RentUser) q.getSingleResult();

        }catch(NoResultException ex){
        	return null;
        }catch(Exception exx){
        	return null;
        }
    }

	@Override
	public void eraseCredentials() {
		this.password = "erasedpassword";
		
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !getAccountExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !getAccountLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !getCredentialsExpired();
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}
