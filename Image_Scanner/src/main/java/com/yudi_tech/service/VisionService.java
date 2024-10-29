package com.yudi_tech.service;

//import com.google.cloud.vision.v1.ImageAnnotatorClient;
//import com.google.cloud.vision.v1.AnnotateImageRequest;
//import com.google.cloud.vision.v1.AnnotateImageResponse;
//import com.google.cloud.vision.v1.Feature;
//import com.google.cloud.vision.v1.Image;
//import com.google.protobuf.ByteString;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@Service
//public class VisionService {
//
//    public String extractTextFromImage(MultipartFile file) throws IOException {
//        ByteString imgBytes = ByteString.readFrom(file.getInputStream());
//
//        // Build the image request
//        Image img = Image.newBuilder().setContent(imgBytes).build();
//        Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
//        AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
//
//        // Call the Vision API
//        try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
//            AnnotateImageResponse response = vision.batchAnnotateImages(java.util.Arrays.asList(request)).getResponses(0);
//            if (response.hasError()) {
//                throw new IOException("Error: " + response.getError().getMessage());
//            }
//            return response.getFullTextAnnotation().getText();
//        }
//    }
//}
