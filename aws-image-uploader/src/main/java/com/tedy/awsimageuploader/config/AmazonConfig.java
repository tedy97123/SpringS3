package com.tedy.awsimageuploader.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// gives us access to S3 client on Amazon Platform//

@Configuration
public class AmazonConfig {

    @Bean // for class injection //
    public AmazonS3 s3() {
        String secretKey;
        String accessKey;
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                accessKey =  "AKIATCCS4K5YVOPHSHLA",
                secretKey = "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"
        );

        return AmazonS3ClientBuilder
             .standard()
             .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
             .build();
    }
}
