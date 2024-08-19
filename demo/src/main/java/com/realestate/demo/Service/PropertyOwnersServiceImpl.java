package com.realestate.demo.Service;

import com.realestate.demo.Entity.PropertyOwners;
import com.realestate.demo.Repository.PropertyOwnersRepository;
import com.realestate.demo.Repository.TitledeedRepository;
import org.springframework.stereotype.Service;
import com.realestate.demo.Entity.Titledeed;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyOwnersServiceImpl implements PropertyOwnersService {


    private final PropertyOwnersRepository propertyOwnersRepository;
    private final TitledeedRepository titledeedRepository;

    public PropertyOwnersServiceImpl(PropertyOwnersRepository propertyOwnersRepository, TitledeedRepository titledeedRepository) {
        this.propertyOwnersRepository = propertyOwnersRepository;
        this.titledeedRepository = titledeedRepository;

    }


    @Override
    public PropertyOwners getPropertyOwners(Integer id) {

        return propertyOwnersRepository.findById(id).get();

    }

    @Override
    public String createPropertyOwner(PropertyOwners propertyOwners) {

        if (propertyOwners.getTitledeed() != null && propertyOwners.getTitledeed().getId() != null) {
            Optional<Titledeed> titledeedOpt = titledeedRepository.findById(propertyOwners.getTitledeed().getId());
            if (titledeedOpt.isPresent()) {
                propertyOwners.setTitledeed(titledeedOpt.get());
            } else {
                throw new IllegalArgumentException("Titledeed not found");
            }
        }
        propertyOwnersRepository.save(propertyOwners);

        return "Property Owner Created";
    }

    @Override
    public String updatePropertyOwner(PropertyOwners propertyOwners) {
        propertyOwnersRepository.save(propertyOwners);
        return "Property Owner Updated";
    }

    @Override
    public String deletePropertyOwner(Integer id) {
        propertyOwnersRepository.deleteById(id);
        return "Property Owner Deleted";
    }

    @Override
    public List<PropertyOwners> getAllPropertyOwners() {
        return propertyOwnersRepository.findAll();
    }
}
