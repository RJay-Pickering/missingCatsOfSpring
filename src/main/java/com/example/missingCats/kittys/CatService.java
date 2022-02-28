package com.example.missingCats.kittys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CatService {

    private final CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<Cat> getCats() {
        return catRepository.findAll();
    }

    public Optional<Cat> getSpecificCats(Long catId) {
        return catRepository.findById(catId);
    }

    public void addNewCat(Cat cat) {
        Optional<Cat> catOptional = catRepository.findCatByName(cat.getName());
        if (catOptional.isPresent()) {
            throw new IllegalStateException("cat already registered");
        }
        catRepository.save(cat);
    }

    public void deleteCat(Long catId) {
        boolean exists = catRepository.existsById(catId);
        if (!exists) {
            throw new IllegalStateException("cat with id " + catId + " does not exists");
        }
        catRepository.deleteById(catId);
    }

    @Transactional
    public void updateCat(Long catId, String name, String description, Integer age) {
        Cat cat = catRepository.findById(catId).orElseThrow(() -> new IllegalStateException("cat with id " + catId + "does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(cat.getName(), name)) {
            catRepository.findCatByName(name);
            cat.setName(name);
        }

        if (description != null && description.length() > 0 && !Objects.equals(cat.getDescription(), description)) {
            cat.setDescription(description);
        }

        if (age != null && !Objects.equals(cat.getAge(), age)) {
            cat.setAge(age);
        }
    }
}
