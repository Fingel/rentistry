// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rentistry.domain;

import com.rentistry.domain.Item;
import com.rentistry.domain.Region;
import java.lang.String;
import java.util.Set;

privileged aspect Account_Roo_JavaBean {
    
    public Region Account.getDefaultRegion() {
        return this.defaultRegion;
    }
    
    public void Account.setDefaultRegion(Region defaultRegion) {
        this.defaultRegion = defaultRegion;
    }
    
    public Set<Item> Account.getProviding() {
        return this.providing;
    }
    
    public void Account.setProviding(Set<Item> providing) {
        this.providing = providing;
    }
    
    public Set<Item> Account.getRequesting() {
        return this.requesting;
    }
    
    public void Account.setRequesting(Set<Item> requesting) {
        this.requesting = requesting;
    }
    
    public String Account.getAboutMe() {
        return this.aboutMe;
    }
    
    public void Account.setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
    
    public String Account.getAvatarKey() {
        return this.avatarKey;
    }
    
    public void Account.setAvatarKey(String avatarKey) {
        this.avatarKey = avatarKey;
    }
    
}
