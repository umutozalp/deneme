package com.realestate.demo.Controller;

import com.realestate.demo.Entity.Image;
import com.realestate.demo.Service.ImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("{id}")
    public Image getImage(@PathVariable int id) {
        return imageService.getImage(id);
    }

    @GetMapping
    public List<Image> getAllImage() {
        return imageService.getAllImage();
    }

    @PostMapping
    public String createImage(@RequestBody Image image) {
        imageService.createImage(image);
        return "Image created Succesfully";
    }

    @PutMapping
    public String updateImage(@RequestBody Image image) {
        imageService.updateImage(image);
        return "Image updated Succesfully";
    }

    @DeleteMapping("{id}")
    public String deleteImage(@PathVariable int id) {
        imageService.deleteImage(id);
        return "Image deleted Succesfully";
    }

}
