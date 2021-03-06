// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rentistry.domain;

import com.rentistry.domain.Account;
import com.rentistry.domain.Authority;
import java.lang.Boolean;
import java.lang.String;
import java.util.Collection;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;

privileged aspect RentUser_Roo_JavaBean {
    
    public String RentUser.getUserEmail() {
        return this.userEmail;
    }
    
    public void RentUser.setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    public String RentUser.getFirstName() {
        return this.firstName;
    }
    
    public void RentUser.setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String RentUser.getLastName() {
        return this.lastName;
    }
    
    public void RentUser.setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String RentUser.getPassword() {
        return this.password;
    }
    
    public void RentUser.setPassword(String password) {
        this.password = password;
    }
    
    public Boolean RentUser.getEnabled() {
        return this.enabled;
    }
    
    public void RentUser.setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    public Boolean RentUser.getAccountExpired() {
        return this.accountExpired;
    }
    
    public void RentUser.setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }
    
    public Boolean RentUser.getCredentialsExpired() {
        return this.credentialsExpired;
    }
    
    public void RentUser.setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }
    
    public Boolean RentUser.getAccountLocked() {
        return this.accountLocked;
    }
    
    public void RentUser.setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }
    
    public Collection<GrantedAuthority> RentUser.getGrantedAuthorities() {
        return this.grantedAuthorities;
    }
    
    public void RentUser.setGrantedAuthorities(Collection<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }
    
    public Account RentUser.getAccount() {
        return this.account;
    }
    
    public void RentUser.setAccount(Account account) {
        this.account = account;
    }
    
    public Set<Authority> RentUser.getGivenAuthorities() {
        return this.givenAuthorities;
    }
    
    public void RentUser.setGivenAuthorities(Set<Authority> givenAuthorities) {
        this.givenAuthorities = givenAuthorities;
    }
    
}
