package com.example.missingCats.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> getSpecificOwner(Long ownerId) {
        return ownerRepository.findById(ownerId);
    }

    public void addNewOwner(Owner owner) {
        Optional<Owner> ownerOptional = ownerRepository.findOwnerByName(owner.getName());
        if (ownerOptional.isPresent()) {
            throw new IllegalStateException("this Owner has already registered");
        }
        ownerRepository.save(owner);
    }

    public void deleteOwner(Long ownerId) {
        boolean exists = ownerRepository.existsById(ownerId);
        if (!exists) {
            throw new IllegalStateException("Owner with id " + ownerId + " does not exists");
        }
        ownerRepository.deleteById(ownerId);
    }

    @Transactional
    public void updateOwner(Long ownerId, String name, Integer age) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new IllegalStateException("Owner with id " + ownerId + "does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(owner.getName(), name)) {
            ownerRepository.findOwnerByName(name);
            owner.setName(name);
        }

        if (age != null && !Objects.equals(owner.getAge(), age)) {
            owner.setAge(age);
        }
    }
}
