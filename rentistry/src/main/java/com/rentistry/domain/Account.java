package com.rentistry.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;


@RooJavaBean
@RooToString
@RooEntity
public class Account {

    @ManyToOne
    private Region defaultRegion;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Item> providing = new HashSet<Item>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Item> requesting = new HashSet<Item>();
    
    public String toString(){
    	return this.defaultRegion.getCities().iterator().next().getName();
    }
}
