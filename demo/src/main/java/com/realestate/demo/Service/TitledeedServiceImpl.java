package com.realestate.demo.Service;

import com.realestate.demo.Entity.Titledeed;
import com.realestate.demo.Repository.TitledeedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TitledeedServiceImpl implements TitledeedService {

    TitledeedRepository titledeedRepository;
    public TitledeedServiceImpl(TitledeedRepository titledeedRepository) {
        this.titledeedRepository = titledeedRepository;
    }




    @Override
    public Titledeed getTitledeed(Integer id) {
        return titledeedRepository.findById(id).get();
    }

    @Override
    public String createTitledeed(Titledeed titledeed) {
        titledeedRepository.save(titledeed);
        return "Succes";
    }

    @Override
    public String updateTitledeed(Titledeed titledeed) {
        titledeedRepository.save(titledeed);
        return "Succes";
    }

    @Override
    public String deleteTitledeed(Integer id) {
        titledeedRepository.deleteById(id);
        return "Succes";
    }

    @Override
    public List<Titledeed> getAllTitledeed() {
        return titledeedRepository.findAll();
    }
}
