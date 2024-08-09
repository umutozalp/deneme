package com.realestate.demo.Service;

import com.realestate.demo.Entity.Attachment;
import com.realestate.demo.Entity.Image;
import com.realestate.demo.Repository.AttachmentsRepository;
import com.realestate.demo.Repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    ImageRepository imageRepository;
    AttachmentsRepository attachmentsRepository;

    public ImageServiceImpl(ImageRepository imageRepository, AttachmentsRepository attachmentsRepository)
    {
        this.imageRepository = imageRepository;
        this.attachmentsRepository = attachmentsRepository;
    }



    @Override
    public Image getImage(Integer id) {
        return imageRepository.findById(id).get();
    }

    @Override
    public String createImage(Image image) {

        if(image.getAttachment()!=null && image.getAttachment().getId()!=null)
        {
            Optional<Attachment> attachmentOpt = attachmentsRepository.findById(image.getAttachment().getId());
            if(attachmentOpt.isPresent())
            {
                image.setAttachment(attachmentOpt.get());
            }
        }
        imageRepository.save(image);
        return "Success";
    }

    @Override
    public String updateImage(Image image) {
        imageRepository.save(image);
        return "Success";
    }

    @Override
    public String deleteImage(Integer id) {
        imageRepository.deleteById(id);
        return "Success";
    }

    @Override
    public List<Image> getAllImage() {
        return imageRepository.findAll();
    }
}
