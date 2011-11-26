package com.rentistry.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class ItemTag {

    private String text;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tags")
    private Set<Item> items = new HashSet<Item>();
}
