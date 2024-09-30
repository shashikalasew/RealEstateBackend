package com.example.RealEstateBackend.PropertyType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyTypeService {

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeRepository.findAll();
    }

    public PropertyType getPropertyTypeById(int id) {
        return propertyTypeRepository.findById(id).orElse(null);
    }

    public PropertyType addPropertyType(PropertyTypeDTO propertyTypeDTO) {
        PropertyType propertyType = new PropertyType();

        propertyType.setName(propertyTypeDTO.getName());
        propertyType.setDescription(propertyTypeDTO.getDescription());

        return propertyTypeRepository.save(propertyType);
    }

    public PropertyType updatePropertyType(int id, PropertyTypeDTO propertyTypeDTO) {
        PropertyType propertyType = propertyTypeRepository.findById(id).orElse(null);
        if (propertyType != null) {
            propertyType.setName(propertyTypeDTO.getName());
            propertyType.setDescription(propertyTypeDTO.getDescription());

            return propertyTypeRepository.save(propertyType);
        }
        return null;
    }

    public void deletePropertyType(int id) {
        propertyTypeRepository.deleteById(id);
    }
}
