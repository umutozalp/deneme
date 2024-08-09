package com.realestate.demo.Service;

import com.realestate.demo.Entity.Titledeed;

import java.util.List;

public interface TitledeedService {

    public Titledeed getTitledeed(Integer id);
    public String createTitledeed(Titledeed titledeed);
    public String updateTitledeed(Titledeed titledeed);
    public String deleteTitledeed(Integer id);
    public List<Titledeed> getAllTitledeed();

}
