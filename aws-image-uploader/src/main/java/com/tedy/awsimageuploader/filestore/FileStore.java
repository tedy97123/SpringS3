package com.tedy.awsimageuploader.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

//@Autowired. It allows Spring to resolve and inject collaborating beans into our bean.
// declaring all the bean dependencies in a Spring configuration file, Spring container can autowire relationships between collaborating beans//
@Service
public class FileStore {
    private final AmazonS3 s3;

    @Autowired
    public FileStore(AmazonS3 s3) {
        this.s3 = s3;
    }

    public void save(String path, String fileName, Optional<Map<String,String>> optionalMetadata, InputStream inputStream)
    {
        ObjectMetadata metaData = new ObjectMetadata();

        optionalMetadata.ifPresent(map->{
            if (!map.isEmpty()) {
                map.forEach(metaData::addUserMetadata);
            }
        });

        try {
            s3.putObject(path, fileName, inputStream, metaData);
        }
        catch (AmazonServiceException e) {
            throw new IllegalStateException("Failed to store file to s3", e);
        }
    }
}
