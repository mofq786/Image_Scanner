package com.yudi_tech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.textract.TextractClient;

@Configuration
public class TextractConfig {

	@Bean
	public TextractClient createTextractClient() {
		
		String accessKey = ""; // Replace with your access key
        String secretKey = ""; // Replace with your secret key
        String region = "ap-southeast-2"; // Set your AWS region
		
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);
	    TextractClient textractClient = TextractClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .region(Region.of(region))
                .build();
	    //System.out.println(text.resolveCredentials()); // Print the credentials
	    return textractClient;
	}
}