// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rentistry.domain;

import com.rentistry.domain.Account;
import com.rentistry.domain.City;
import com.rentistry.domain.Item;
import java.lang.String;
import java.util.Set;

privileged aspect Region_Roo_JavaBean {
    
    public Set<City> Region.getCities() {
        return this.cities;
    }
    
    public void Region.setCities(Set<City> cities) {
        this.cities = cities;
    }
    
    public String Region.getName() {
        return this.name;
    }
    
    public void Region.setName(String name) {
        this.name = name;
    }
    
    public Set<Account> Region.getAccounts() {
        return this.accounts;
    }
    
    public void Region.setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
    
    public Set<Item> Region.getItems() {
        return this.items;
    }
    
    public void Region.setItems(Set<Item> items) {
        this.items = items;
    }
    
}
