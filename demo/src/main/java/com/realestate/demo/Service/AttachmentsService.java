package com.realestate.demo.Service;

import com.realestate.demo.Entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachmentsService {

     String createAttachments(Attachment attachment, MultipartFile file) throws Exception;
     String updateAttachments(Attachment attachment);
     String deleteAttachments(Integer id);
     Attachment getAttachments(Integer id);
     List<Attachment> getAllAttachments();
}