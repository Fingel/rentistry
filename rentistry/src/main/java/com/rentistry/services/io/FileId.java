package com.rentistry.services.io;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

import com.rentistry.services.misc.TokenGenerator;

public class FileId {
	
    private String fileKey = null;

    private String fileName = null;
    
    private Long itemId = null;
    
    private FileStorage fileStorage;
    
    private static TokenGenerator tokenGenerator = new TokenGenerator();
    
    public static FileId createFileId(FileStorage fileStorage, String fileName){
    	FileId fileId = new FileId();
    	fileId.setFileName(fileName);
    	fileId.setFileStorage(fileStorage);
    	fileId.setFileKey(tokenGenerator.generateToken());
    	return fileId;
    }
    
    public static FileId createFileIdWithKey(FileStorage fileStorage, String fileName, String fileKey){
    	FileId fileId = new FileId();
    	fileId.setFileName(fileName);
    	fileId.setFileKey(fileKey);
    	fileId.setFileStorage(fileStorage);
    	return fileId;
    }
    
    public String getPath(){
    	StringBuilder sb = new StringBuilder();
    	sb.append(fileStorage + "/");
    	if(fileStorage.equals(FileStorage.ITEM_IMAGE)){
    		sb.append(itemId + "/");
    	}
    	sb.append(fileKey + "/" + fileName);
    	return sb.toString();
    }
    
    private String generateRandomFileName(String fileName) throws UnsupportedEncodingException, NoSuchAlgorithmException{
    	return DigestUtils.md5Hex(fileName);
    }
	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileStorage getFileStorage() {
		return fileStorage;
	}

	public void setFileStorage(FileStorage fileStorage) {
		this.fileStorage = fileStorage;
	}

}
