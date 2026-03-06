package com.Architecture_Website.Architecture_Website.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final AmazonS3 s3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Value("${aws.s3.endpoint-url}")
    private String endpointUrl;

    public String uploadFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename != null && originalFilename.contains(".")
                ? originalFilename.substring(originalFilename.lastIndexOf("."))
                : "";
        String uniqueFileName = UUID.randomUUID().toString() + extension;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file.getInputStream(),
                metadata);
        // Backblaze does not always support all ACLs like AWS, but standard public
        // bucket doesn't strictly need it if bucket is public.
        // If it throws an error we can remove this line.
        putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);

        s3Client.putObject(putObjectRequest);

        // Generate the public URL
        // Backblaze B2 public URL format:
        // https://f004.backblazeb2.com/file/<bucketName>/<fileName>
        // Or using S3 endpoint:
        // https://<bucketName>.s3.us-west-004.backblazeb2.com/<fileName>
        String s3Endpoint = endpointUrl.replace("https://", "");
        return "https://" + bucketName + "." + s3Endpoint + "/" + uniqueFileName;
    }
}
