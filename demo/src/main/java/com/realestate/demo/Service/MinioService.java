package com.realestate.demo.Service;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.GetObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class MinioService {

    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucketName}")
    private String bucketName;

    public void uploadFile(String objectName, InputStream inputStream, String contentType) throws Exception {
        try {
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(
                                    inputStream, -1, 10485760)
                            .contentType(contentType)
                            .build());
        } catch (MinioException e) {
            throw new Exception("Error occurred: " + e.getMessage());
        }
    }

    public InputStream downloadFile(String objectName) throws Exception {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (MinioException e) {
            throw new Exception("Error occurred: " + e.getMessage());
        }
    }
}