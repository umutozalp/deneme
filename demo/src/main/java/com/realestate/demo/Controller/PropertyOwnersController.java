package com.realestate.demo.Controller;

import com.realestate.demo.Entity.PropertyOwners;
import com.realestate.demo.Service.PropertyOwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propertyowners")
public class PropertyOwnersController {

    @Autowired
    private PropertyOwnersService propertyOwnersService;

    @GetMapping("{id}")
    public PropertyOwners getPropertyOwners(@PathVariable int id) {
        return propertyOwnersService.getPropertyOwners(id);
    }

    @GetMapping
    public List<PropertyOwners> getAllPropertyOwners() {
        return propertyOwnersService.getAllPropertyOwners();
    }

    @PostMapping
    public String createPropertyOwners(@RequestBody PropertyOwners propertyOwners) {
        propertyOwnersService.createPropertyOwner(propertyOwners);


        return "PropertyOwners created successfully";
    }

    @PutMapping
    public String updatePropertyOwners(@RequestBody PropertyOwners propertyOwners) {
        propertyOwnersService.updatePropertyOwner(propertyOwners);
        return "PropertyOwners updated successfully";
    }

    @DeleteMapping("{id}")
    public String deletePropertyOwners(@PathVariable int id) {
        propertyOwnersService.deletePropertyOwner(id);
        return "PropertyOwners deleted successfully";
    }

}
