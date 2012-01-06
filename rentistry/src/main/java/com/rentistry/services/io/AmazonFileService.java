package com.rentistry.services.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.AmazonClientException;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
public class AmazonFileService implements FileService {
	
	private String credPath;
	private String bucketPrefix;
	private String downloadURLLife;
	

	@Override
	public String getFileURL(FileId fileId) throws IOException {
		
		AmazonS3Client s3 = getS3Client();
		URL url = s3.generatePresignedUrl(getBucket(fileId), fileId.getPath(), getDateAfterUrlLife(), HttpMethod.GET);
		return url.toExternalForm();
	}

	@Override
	public boolean deleteFile(FileId fileId) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InputStream readFile(FileId fileId) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileId> listFiles() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

		
	@Override
	public boolean writeFile(FileId fileId, InputStream fileInputStream,
			long streamSize, String contentType) throws IOException {
		if(streamSize<=0)
      		return false;
		TransferManager tm;
		try {
			tm = new TransferManager(new PropertiesCredentials(
					AmazonFileService.class.getResourceAsStream(credPath)));
		} catch (IOException e1) {
			throw e1;
		}        

        // TransferManager processes all transfers asynchronously, 
        // so this call will return immediately.
        ObjectMetadata oMD=new ObjectMetadata();
        oMD.setContentLength(streamSize);
        if(contentType!=null)
        	oMD.setContentType(contentType);
        Upload upload = tm.upload(getBucket(fileId), fileId.getPath(), fileInputStream,oMD);
        try {
        	// Or you can block and wait for the upload to finish
        	upload.waitForCompletion();
        } catch (AmazonClientException amazonClientException) {
        	System.out.println("Unable to upload file, upload was aborted.");
        	throw amazonClientException;
        } catch (InterruptedException e) {
			System.out.println("Interrupted exception" + e.getStackTrace());
		}
	return true;
	}

	@Override
	public boolean exists(FileId fileId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendFileToBrowser(FileId fileId, HttpServletRequest request,
			HttpServletResponse response) throws IOException, IOException {
		// TODO Auto-generated method stub

	}
	
	private AmazonS3Client getS3Client() throws IOException{
		AmazonS3Client client = new AmazonS3Client(new PropertiesCredentials(AmazonFileService.class.getResourceAsStream(credPath)));
		return client;
	}
	
	public Date getDateAfterUrlLife() {
		long backDateMS = System.currentTimeMillis() + Long.parseLong(getDownloadURLLife()) *24*60*60*1000;
		Date backDate = new Date();
		backDate.setTime(backDateMS);
		return backDate;
	}
	
	public String getCredPath() {
		return credPath;
	}

	public void setCredPath(String credPath) {
		this.credPath = credPath;
	}

	public String getBucketPrefix() {
		return bucketPrefix;
	}

	public void setBucketPrefix(String bucketPrefix) {
		this.bucketPrefix = bucketPrefix;
	}

	public String getDownloadURLLife() {
		return downloadURLLife;
	}

	public void setDownloadURLLife(String downloadURLLife) {
		this.downloadURLLife = downloadURLLife;
	}
	
	private String getBucket(FileId fileId){
		//right now store everything in one bucket
		return bucketPrefix;
	}

}
