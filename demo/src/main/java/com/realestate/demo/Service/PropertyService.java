package com.realestate.demo.Service;

import com.realestate.demo.Entity.Property;
import com.realestate.demo.Entity.PropertyOwners;

import java.util.List;

public interface PropertyService {

    public Property getProperty(Integer id);

    public String createProperty(Property property);

    public String updateProperty(Property property);

    public String deleteProperty(Integer id);

    public List<Property> getAllProperty();





}
