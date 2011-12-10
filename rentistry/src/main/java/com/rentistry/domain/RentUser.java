package com.rentistry.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.Transient;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;


@RooJavaBean
@RooToString
@RooEntity(finders = { "findRentUsersByUserEmailEquals" })
public class RentUser {

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

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Authority> givenAuthorities = new HashSet<Authority>();

    public static com.rentistry.domain.RentUser findUserByUserEmail(String userEmail) {
        if (userEmail == null || userEmail.length() == 0) throw new IllegalArgumentException("The userEmail argument is required");
        EntityManager em = RentUser.entityManager();
        Query q = em.createQuery("SELECT RentUser FROM RentUser AS rentuser WHERE rentuser.userEmail = :userEmail");
        q.setParameter("userEmail", userEmail);
        try {
            return (RentUser) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (Exception exx) {
            return null;
        }
    }


    public void updateRoles(){
    	Set<Authority> authorities= getGivenAuthorities();
        for (Authority authoritiy : authorities ) { 
        	grantedAuthorities.add(new GrantedAuthorityImpl(authoritiy.getName()));
        }
    }
}
