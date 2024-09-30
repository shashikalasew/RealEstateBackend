package com.example.RealEstateBackend.PropertyType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/property_type")
public class PropertyTypeController {

    @Autowired
    private PropertyTypeService propertyTypeService;

    @GetMapping
    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeService.getAllPropertyTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyType> getPropertyTypeById(@PathVariable int id) {
        PropertyType propertyType = propertyTypeService.getPropertyTypeById(id);
        if (propertyType != null) {
            return ResponseEntity.ok(propertyType);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public PropertyType addPropertyType(@RequestBody PropertyTypeDTO propertyTypeDTO) {
        return propertyTypeService.addPropertyType(propertyTypeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyType> updatePropertyType(@PathVariable int id, @RequestBody PropertyTypeDTO propertyTypeDTO) {
        PropertyType updatedPropertyType = propertyTypeService.updatePropertyType(id, propertyTypeDTO);
        if (updatedPropertyType != null) {
            return ResponseEntity.ok(updatedPropertyType);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropertyType(@PathVariable int id) {
        propertyTypeService.deletePropertyType(id);
        return ResponseEntity.noContent().build();
    }
}
