package com.example.RealEstateBackend.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(int id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public Owner addOwner(OwnerDTO ownerDTO) {
        Owner owner = new Owner();

        owner.setName(ownerDTO.getName());
        owner.setPhone(ownerDTO.getPhone());
        owner.setEmail(ownerDTO.getEmail());
        owner.setAddress(ownerDTO.getAddress());

        owner.setCreatedAt(java.time.LocalDateTime.now());

        return ownerRepository.save(owner);
    }

    public Owner updateOwner(int id, OwnerDTO ownerDTO) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        if (owner != null) {
            owner.setName(ownerDTO.getName());
            owner.setPhone(ownerDTO.getPhone());
            owner.setEmail(ownerDTO.getEmail());
            owner.setAddress(ownerDTO.getAddress());

            owner.setCreatedAt(java.time.LocalDateTime.now());

            return ownerRepository.save(owner);
        }
        return null;
    }

    public void deleteOwner(int id) {
        ownerRepository.deleteById(id);
    }
}
