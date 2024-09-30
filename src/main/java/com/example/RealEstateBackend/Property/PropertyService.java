package com.example.RealEstateBackend.Property;

import com.example.RealEstateBackend.Owner.Owner;
import com.example.RealEstateBackend.Owner.OwnerRepository;
import com.example.RealEstateBackend.PropertyType.PropertyType;
import com.example.RealEstateBackend.PropertyType.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(int id) {
        return propertyRepository.findById(id).orElse(null);
    }

    public Property addProperty(PropertyDTO propertyDTO) {
        Property property = new Property();

        PropertyType propertyType = propertyTypeRepository.findById(propertyDTO.getPropTypeId()).orElseThrow();
        property.setPropertyType(propertyType);

        Owner owner = ownerRepository.findById(propertyDTO.getOwnerId()).orElseThrow();
        property.setOwner(owner);

        property.setSize(propertyDTO.getSize());
        property.setPrice(propertyDTO.getPrice());
        property.setAddress(propertyDTO.getAddress());
        property.setBedrooms(propertyDTO.getBedrooms());
        property.setBathrooms(propertyDTO.getBathrooms());
        property.setAge(propertyDTO.getAge());
        property.setBalcony(propertyDTO.isBalcony());
        property.setPool(propertyDTO.isPool());
        property.setBackyard(propertyDTO.isBackyard());
        property.setGarage(propertyDTO.isGarage());
        property.setDescription(propertyDTO.getDescription());

        return propertyRepository.save(property);
    }

    public Property updateProperty(int id, PropertyDTO propertyDTO) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {

            PropertyType propertyType = propertyTypeRepository.findById(propertyDTO.getPropTypeId()).orElseThrow();
            property.setPropertyType(propertyType);

            Owner owner = ownerRepository.findById(propertyDTO.getOwnerId()).orElseThrow();
            property.setOwner(owner);

            property.setSize(propertyDTO.getSize());
            property.setPrice(propertyDTO.getPrice());
            property.setAddress(propertyDTO.getAddress());
            property.setBedrooms(propertyDTO.getBedrooms());
            property.setBathrooms(propertyDTO.getBathrooms());
            property.setAge(propertyDTO.getAge());
            property.setBalcony(propertyDTO.isBalcony());
            property.setPool(propertyDTO.isPool());
            property.setBackyard(propertyDTO.isBackyard());
            property.setGarage(propertyDTO.isGarage());
            property.setDescription(propertyDTO.getDescription());

            return propertyRepository.save(property);
        }
        return null;
    }

    public void deleteProperty(int id) {
        propertyRepository.deleteById(id);
    }
}
