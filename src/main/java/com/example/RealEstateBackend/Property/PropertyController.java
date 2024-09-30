package com.example.RealEstateBackend.Property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable int id) {
        Property property = propertyService.getPropertyById(id);
        if (property != null) {
            return ResponseEntity.ok(property);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Property addProperty(@RequestBody PropertyDTO propertyDTO) {
        return propertyService.addProperty(propertyDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable int id, @RequestBody PropertyDTO propertyDTO) {
        Property updatedProperty = propertyService.updateProperty(id, propertyDTO);
        if (updatedProperty != null) {
            return ResponseEntity.ok(updatedProperty);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable int id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
