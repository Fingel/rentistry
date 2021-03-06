// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rentistry.domain;

import java.lang.String;

privileged aspect Item_Roo_ToString {
    
    public String Item.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Available: ").append(getAvailable()).append(", ");
        sb.append("Description: ").append(getDescription()).append(", ");
        sb.append("EndDate: ").append(getEndDate()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Images: ").append(getImages() == null ? "null" : getImages().size()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Price: ").append(getPrice()).append(", ");
        sb.append("PriceInterval: ").append(getPriceInterval()).append(", ");
        sb.append("ProvidedBy: ").append(getProvidedBy()).append(", ");
        sb.append("Region: ").append(getRegion()).append(", ");
        sb.append("RequestedBy: ").append(getRequestedBy() == null ? "null" : getRequestedBy().size()).append(", ");
        sb.append("StartDate: ").append(getStartDate()).append(", ");
        sb.append("Tags: ").append(getTags() == null ? "null" : getTags().size()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
