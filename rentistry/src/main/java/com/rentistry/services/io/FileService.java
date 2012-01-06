package com.rentistry.services.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rentistry.services.io.FileId;


public interface FileService {
	
	public String getFileURL(FileId fileId) throws IOException;
	
	public boolean deleteFile(FileId fileId) throws IOException;
	
	public InputStream readFile(FileId fileId) throws IOException;
	
	public List<FileId> listFiles() throws IOException;

	public boolean writeFile(FileId fileId, InputStream fileInputStream, long streamSize, String contentType) throws IOException;
	
	public boolean exists(FileId fileId);
	
	public void sendFileToBrowser(FileId fileId, HttpServletRequest request, HttpServletResponse response) throws IOException, IOException;

}
