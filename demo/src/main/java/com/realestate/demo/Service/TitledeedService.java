package com.realestate.demo.Service;

import com.realestate.demo.Entity.Titledeed;

import java.util.List;

public interface TitledeedService {

     Titledeed getTitledeed(Integer id);
     String createTitledeed(Titledeed titledeed);
     String updateTitledeed(Titledeed titledeed);
     String deleteTitledeed(Integer id);
     List<Titledeed> getAllTitledeed();

}
