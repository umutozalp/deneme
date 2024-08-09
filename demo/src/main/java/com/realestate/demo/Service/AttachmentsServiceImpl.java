package com.realestate.demo.Service;

import com.realestate.demo.Entity.Attachment;
import com.realestate.demo.Entity.Property;
import com.realestate.demo.Repository.AttachmentsRepository;
import com.realestate.demo.Repository.PropertyRepository;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentsServiceImpl implements AttachmentsService {

    private final AttachmentsRepository attachmentsRepository;
    private final PropertyRepository propertyRepository;
    private final MinioClient minioClient;

    @Value("${minio.bucketName}")
    private String bucketName;

    public AttachmentsServiceImpl(AttachmentsRepository attachmentsRepository, PropertyRepository propertyRepository, MinioClient minioClient) {
        this.attachmentsRepository = attachmentsRepository;
        this.propertyRepository = propertyRepository;
        this.minioClient = minioClient;
    }

    @Override
    public String createAttachments(Attachment attachment, MultipartFile file) throws Exception {
        // Dosya yükleme
        String fileName = file.getOriginalFilename();
        try (InputStream inputStream = file.getInputStream()) {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .stream(inputStream, -1, 10485760)
                            .contentType(file.getContentType())
                            .build());
        } catch (MinioException e) {
            throw new Exception("Error occurred: " + e.getMessage());
        }

        // URL oluşturma
        String fileUrl = "/files/download/" + fileName;

        // Attachment nesnesini güncelle
        attachment.setFileUrl(fileUrl);
        if (attachment.getProperty() != null && attachment.getProperty().getId() != null) {
            Optional<Property> propertyOpt = propertyRepository.findById(attachment.getProperty().getId());
            if (propertyOpt.isPresent()) {
                attachment.setProperty(propertyOpt.get());
            }
        }
        attachmentsRepository.save(attachment);
        return "Success";
    }

    @Override
    public String updateAttachments(Attachment attachment) {
        attachmentsRepository.save(attachment);
        return "Success";
    }

    @Override
    public String deleteAttachments(Integer id) {
        attachmentsRepository.deleteById(id);
        return "Success";
    }

    @Override
    public Attachment getAttachments(Integer id) {
        return attachmentsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Attachment> getAllAttachments() {
        return attachmentsRepository.findAll();
    }
}