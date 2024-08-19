package com.realestate.demo.Service;

import com.realestate.demo.Entity.Property;
import com.realestate.demo.Entity.PropertyOwners;

import java.util.List;

public interface PropertyService {

     Property getProperty(Integer id);

     String createProperty(Property property);

     String updateProperty(Property property);

     String deleteProperty(Integer id);

     List<Property> getAllProperty();





}
