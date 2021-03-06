package com.theweddingsupplier.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.theweddingsupplier.util.MediaTypeUtils;

@Controller
public class ImageComtroller {
//	private static final String DIRECTORY = "E:\\TheWeddingSupplier\\frontend\\tws-frontend\\public\\images";
//	private static final String DEFAULT_FILE_NAME="blog-theme.jpg";
//	
//	@Autowired
//	private ServletContext servletContext;
//	
//	@RequestMapping("/download-image")
//    public ResponseEntity<InputStreamResource> downloadFile1(
//            @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName) throws IOException {
// 
//        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
//        System.out.println("fileName: " + fileName);
//        System.out.println("mediaType: " + mediaType);
// 
//        File file = new File(DIRECTORY + "/" + fileName);
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
// 
//        return ResponseEntity.ok()
//                // Content-Disposition
//                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + file.getName())
//                // Content-Type
//                .contentType(mediaType)
//                // Content-Length
//                .contentLength(file.length()) //
//                .body(resource);
//    }
}
