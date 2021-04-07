package com.theweddingsupplier.util;

import javax.servlet.ServletContext;


import org.springframework.http.MediaType;

public class MediaTypeUtils {
	
	public static MediaType getMediaTypeForFileName(ServletContext servletContext, String fileName) {
		String type = servletContext.getMimeType(fileName);
		
		try {
			MediaType mediaType = MediaType.parseMediaType(type);
			return mediaType;
		}catch(Exception e) {
			return MediaType.APPLICATION_OCTET_STREAM;
		}
	}
}
