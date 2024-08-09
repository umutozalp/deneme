package com.realestate.demo.Service;

import com.realestate.demo.Entity.Contract;
import com.realestate.demo.Entity.Image;

import java.util.List;

public interface ImageService {

    public Image getImage(Integer id);

    public String createImage(Image image);

    public String updateImage(Image image);

    public String deleteImage(Integer id);

    public List<Image> getAllImage();



}
