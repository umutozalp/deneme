package com.realestate.demo.Service;


import com.realestate.demo.Entity.Image;

import java.util.List;

public interface ImageService {

     Image getImage(Integer id);

     String createImage(Image image);

     String updateImage(Image image);

     String deleteImage(Integer id);

     List<Image> getAllImage();



}
