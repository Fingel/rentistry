package com.rentistry.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class City {

    private String name;

    private String stateCode;

    private Long zip;

    private double latitude;

    private double longitude;

    private String county;
}
