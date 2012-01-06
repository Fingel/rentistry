package com.rentistry.domain;

import com.rentistry.services.io.FileId;
import com.rentistry.services.io.FileService;
import com.rentistry.services.io.FileStorage;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findAccountsByRentUser" })
public class Account {

    @Transient
    @Autowired
    private FileService fileService;

    @ManyToOne
    private Region defaultRegion;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Item> providing = new HashSet<Item>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Item> requesting = new HashSet<Item>();

    private String aboutMe;

    private String avatarKey;

    private String avatarFileName;

    @OneToOne(mappedBy = "account")
    private RentUser rentUser;

    @Transient
    String avatarUrl;

    public String toString() {
        return this.defaultRegion.getCities().iterator().next().getName();
    }

    public String getAvatarUrl() throws IOException {
        FileId fileId = FileId.createFileIdWithKey(FileStorage.AVATAR, avatarFileName, avatarKey);
        return fileService.getFileURL(fileId);
    }

    public FileService getFileService() {
        return fileService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
}
