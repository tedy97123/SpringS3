package com.tedy.awsimageuploader.Bucket;

public enum BucketName {

    PROFILE_IMAGE("tedy-image-upload-123");

    private final String bucketName;

    BucketName(String bucketName){
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
