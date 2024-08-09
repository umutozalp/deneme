package com.realestate.demo.Service;

import com.realestate.demo.Entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachmentsService {

    public String createAttachments(Attachment attachment, MultipartFile file) throws Exception;
    public String updateAttachments(Attachment attachment);
    public String deleteAttachments(Integer id);
    public Attachment getAttachments(Integer id);
    public List<Attachment> getAllAttachments();
}