package com.rentistry.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Item {

    @ManyToOne
    private Region region;

    @ManyToOne
    private Account providedBy;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Account> requestedBy = new HashSet<Account>();

    private Boolean available;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date endDate;

    private String description;

    @NotNull
    private String name;

    private int price;

    private int priceInterval;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ItemTag> tags = new HashSet<ItemTag>();
}
