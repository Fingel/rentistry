// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rentistry.domain;

import java.lang.Long;
import java.lang.String;

privileged aspect City_Roo_JavaBean {
    
    public String City.getName() {
        return this.name;
    }
    
    public void City.setName(String name) {
        this.name = name;
    }
    
    public String City.getStateCode() {
        return this.stateCode;
    }
    
    public void City.setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    
    public Long City.getZip() {
        return this.zip;
    }
    
    public void City.setZip(Long zip) {
        this.zip = zip;
    }
    
    public double City.getLatitude() {
        return this.latitude;
    }
    
    public void City.setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public double City.getLongitude() {
        return this.longitude;
    }
    
    public void City.setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public String City.getCounty() {
        return this.county;
    }
    
    public void City.setCounty(String county) {
        this.county = county;
    }
    
}