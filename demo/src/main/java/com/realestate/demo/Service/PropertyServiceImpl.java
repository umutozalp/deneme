package com.realestate.demo.Service;

import com.realestate.demo.Entity.Property;
import com.realestate.demo.Entity.Titledeed;
import com.realestate.demo.Repository.PropertyRepository;
import com.realestate.demo.Repository.TitledeedRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    PropertyRepository propertyRepository;
    TitledeedRepository titledeedRepository;



    public PropertyServiceImpl(PropertyRepository propertyRepository, TitledeedRepository titledeedRepository) {
        this.propertyRepository = propertyRepository;
        this.titledeedRepository=titledeedRepository;
    }

    public Property getProperty(Integer id) {

        return propertyRepository.findById(id).get();
    }

    @Override
    public String createProperty(Property property) {


        if (property.getTitledeed() != null && property.getTitledeed().getId() != null) {
            Optional<Titledeed> titledeedOpt = titledeedRepository.findById(property.getTitledeed().getId());
            if (titledeedOpt.isPresent()) {
                property.setTitledeed(titledeedOpt.get());
            } else {
                throw new IllegalArgumentException("Titledeed not found");
            }
        }
         propertyRepository.save(property);
        return "Success";
    }

    @Override
    public String updateProperty(Property property) {
        propertyRepository.save(property);
        return "Succes";
    }

    @Override
    public String deleteProperty(Integer id) {



        propertyRepository.deleteById(id);
        return "Succes";
    }

    @Override
    public List<Property> getAllProperty() {
        return propertyRepository.findAll();
    }
}
