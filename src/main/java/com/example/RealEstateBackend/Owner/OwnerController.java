package com.example.RealEstateBackend.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable int id) {
        Owner owner = ownerService.getOwnerById(id);
        if (owner != null) {
            return ResponseEntity.ok(owner);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Owner addOwner(@RequestBody OwnerDTO ownerDTO) {
        return ownerService.addOwner(ownerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable int id, @RequestBody OwnerDTO ownerDTO) {
        Owner updateOwner = ownerService.updateOwner(id, ownerDTO);
        if (updateOwner != null) {
            return ResponseEntity.ok(updateOwner);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable int id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }
}
