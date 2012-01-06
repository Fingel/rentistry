package com.rentistry.services.misc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageUtils {
	
	public static File resizeUploadImage(CommonsMultipartFile file, int width, int height) throws IOException{
    	File finalFile = File.createTempFile(TokenGenerator.generateToken(), "");
    	BufferedImage originalImage = ImageIO.read(file.getInputStream());
    	BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
    	Graphics2D g = resizedImage.createGraphics();
    	g.drawImage(originalImage, 0, 0, width, height, null);
    	g.dispose();
    	ImageIO.write(resizedImage,"png",finalFile);
    	return finalFile;
    }

}
