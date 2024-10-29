package com.yudi_tech.service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.DetectDocumentTextRequest;
import software.amazon.awssdk.services.textract.model.DetectDocumentTextResponse;
import software.amazon.awssdk.services.textract.model.Block;
import software.amazon.awssdk.services.textract.model.BlockType;
import software.amazon.awssdk.services.textract.model.Document;

@Service
public class TextractService {

    private final TextractClient textractClient;

    public TextractService(TextractClient textractClient) {
        this.textractClient = textractClient;
    }

    public String extractText(MultipartFile file) throws IOException {
        // Convert MultipartFile to ByteBuffer
        ByteBuffer imageBytes = ByteBuffer.wrap(file.getBytes());

        // Build the request for DetectDocumentText
        DetectDocumentTextRequest request = DetectDocumentTextRequest.builder()
                .document(Document.builder().bytes(SdkBytes.fromByteBuffer(imageBytes)).build())
                .build();

        // Call the Textract API
        DetectDocumentTextResponse response = textractClient.detectDocumentText(request);

        // Debug: Print the entire response
        System.out.println("Textract Response: " + response);

        // Process the response and extract the text
        List<Block> blocks = response.blocks();
        System.out.println("Number of blocks: " + blocks.size());

        StringBuilder extractedText = new StringBuilder();
        for (Block block : blocks) {
            System.out.println("Block Type: " + block.blockType() + " | Text: " + block.text());
            if (block.blockType() == BlockType.LINE) {
                extractedText.append(block.text()).append("\n");
            }
        }

        return extractedText.toString();
    }
}
