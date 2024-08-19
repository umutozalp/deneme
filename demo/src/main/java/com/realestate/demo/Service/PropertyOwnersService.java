package com.realestate.demo.Service;

import com.realestate.demo.Entity.PropertyOwners;

import java.util.List;

public interface PropertyOwnersService {

    PropertyOwners getPropertyOwners(Integer id);

    String createPropertyOwner(PropertyOwners propertyOwners);

    String updatePropertyOwner(PropertyOwners propertyOwners);

    String deletePropertyOwner(Integer id);

    List<PropertyOwners> getAllPropertyOwners();

}
