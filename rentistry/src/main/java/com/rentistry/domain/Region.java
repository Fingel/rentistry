package com.rentistry.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Region {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<City> cities = new HashSet<City>();

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "defaultRegion")
    private Set<Account> accounts = new HashSet<Account>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    private Set<Item> items = new HashSet<Item>();

}
