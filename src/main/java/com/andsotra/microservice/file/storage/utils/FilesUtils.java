package com.andsotra.microservice.file.storage.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilesUtils {
	
	static Base64 base64 = new Base64();
    private static final Logger logger = LogManager.getLogger(FilesUtils.class);
    
	public static String fileToBase64(String path) {
		File file = new File(path);
		byte[] fileArray = new byte[(int) file.length()];
		InputStream inputStream;

		String encodedFile = "";
		try {
			inputStream = new FileInputStream(file);
			inputStream.read(fileArray);
			encodedFile = base64.encodeToString(fileArray);
		} catch (Exception e) {
			logger.error("Ha ocurrido un error", e);
			encodedFile = null;
		}
		
		return encodedFile;
		
	}
	
	public static boolean createFile(String path, String base64image) {
		byte[] data = Base64.decodeBase64(base64image);
		boolean fileCreated = false;
		try (OutputStream stream = new FileOutputStream(path)) {
		    stream.write(data);
		    fileCreated = true;
		} catch (IOException e) {
			logger.error("Ha ocurrido un error", e);
		}
		
		return fileCreated;
	}

}
