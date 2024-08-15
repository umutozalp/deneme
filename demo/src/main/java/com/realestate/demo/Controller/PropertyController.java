package com.realestate.demo.Controller;

import com.realestate.demo.Entity.Property;
import com.realestate.demo.Service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    PropertyService propertyService;
    public PropertyController(PropertyService propertyService)
    {
        this.propertyService = propertyService;
    }

    @GetMapping("{id}")
    public Property getProperty(@PathVariable int id)
    {
        return propertyService.getProperty(id);
    }
    @GetMapping
    public List<Property> getAllPropertyList()
    {
        return propertyService.getAllProperty();
    }

    @PostMapping()
    public Property createProperty(@RequestBody Property property)
    {

        propertyService.createProperty(property);
        return propertyService.getProperty(property.getId());
    }
    @PutMapping
    public String updateProperty(@RequestBody Property property)
    {
        propertyService.updateProperty(property);
        return "Property updated successfully";
    }
    @DeleteMapping("{id}")
    public String deleteProperty(@PathVariable int id)
    {
        propertyService.deleteProperty(id);
        return "Property deleted successfully";
    }

}
