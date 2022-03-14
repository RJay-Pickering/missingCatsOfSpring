package com.example.missingCats.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    @GetMapping(path="{ownerId}")
    public Optional<Owner> getSpecificOwner(@PathVariable Long ownerId) {
        return ownerService.getSpecificOwner(ownerId);
    }

    @PostMapping
    public void registerNewOwner(@RequestBody Owner owner) {
        ownerService.addNewOwner(owner);
    }

    @DeleteMapping(path = "{ownerId}")
    public void deleteOwner(@PathVariable("ownerId") Long ownerId) {
        ownerService.deleteOwner(ownerId);
    }

    @PutMapping(path = "{ownerId}")
    public void updateOwner(@PathVariable("ownerId") Long ownerId, @RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        ownerService.updateOwner(ownerId, name, age);
    }
}

