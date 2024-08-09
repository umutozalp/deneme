package com.realestate.demo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realestate.demo.Entity.Attachment;
import com.realestate.demo.Service.AttachmentsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentsController {

    private final AttachmentsService attachmentsService;

    public AttachmentsController(AttachmentsService attachmentsService) {
        this.attachmentsService = attachmentsService;
    }

    @GetMapping("/{id}")
    public Attachment getAttachments(@PathVariable int id) {
        return attachmentsService.getAttachments(id);
    }

    @GetMapping
    public List<Attachment> getAttachments() {
        return attachmentsService.getAllAttachments();
    }

    @PostMapping("/upload")
    public String createAttachments(@RequestParam("file") MultipartFile file, @RequestParam("attachment") String attachmentJson) throws Exception {
        // JSON parse işlemi
        Attachment attachment = new ObjectMapper().readValue(attachmentJson, Attachment.class);
        attachmentsService.createAttachments(attachment,file);
        return "Attachment created successfully";
    }

    @PutMapping
    public String updateAttachments(@RequestBody Attachment attachment) {
        attachmentsService.updateAttachments(attachment);
        return "Attachment updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteAttachments(@PathVariable int id) {
        attachmentsService.deleteAttachments(id);
        return "Attachment deleted successfully";
    }
}