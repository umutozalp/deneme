package com.realestate.demo.Service;

import com.realestate.demo.Entity.PropertyOwners;

import java.util.List;

public interface PropertyOwnersService {

    public PropertyOwners getPropertyOwners(Integer id);

    public String createPropertyOwner(PropertyOwners propertyOwners);

    public String updatePropertyOwner(PropertyOwners propertyOwners);

    public String deletePropertyOwner(Integer id);

    public List<PropertyOwners> getAllPropertyOwners();

}
