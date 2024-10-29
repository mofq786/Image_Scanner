package com.yudi_tech.controller;
//
//import java.io.IOException;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.yudi_tech.service.TextractService;
//
//@RestController
//@RequestMapping("/api/textract")
//public class ImageController {
//
//    private final TextractService textractService;
//
//    public ImageController(TextractService textractService) {
//        this.textractService = textractService;
//    }
//
//    @PostMapping("/extract")
//    public ResponseEntity<String> extractTextFromImage(@RequestParam("file") MultipartFile file) {
//        try {
//            String extractedText = textractService.extractText(file);
//            return ResponseEntity.ok(extractedText);
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Error processing file: " + e.getMessage());
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.RestController;
////import org.springframework.web.multipart.MultipartFile;
////
////import com.yudi_tech.service.VisionService;
////
////@RestController
////@RequestMapping("/api")
////public class ImageController {
////
////    @Autowired
////    private VisionService visionService;
////
////    @PostMapping("/upload")
////    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
////    	
////    	if (file.isEmpty()) {
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
////        }
////    	
////        try {
////            // Call service to process the image
////            String extractedText = visionService.extractTextFromImage(file);
////            
////            System.out.println(extractedText);
////            
////            return ResponseEntity.ok(extractedText);
////        } catch (Exception e) {
////        	e.printStackTrace();
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process image");
////        }
////    }
////}
