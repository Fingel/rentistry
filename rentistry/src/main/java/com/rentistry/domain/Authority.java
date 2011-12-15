package com.rentistry.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findAuthoritysByNameEquals" })
public class Authority {

    @Column(unique = true, updatable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "givenAuthorities")
    private Set<RentUser> rentUsers = new HashSet<RentUser>();
}
