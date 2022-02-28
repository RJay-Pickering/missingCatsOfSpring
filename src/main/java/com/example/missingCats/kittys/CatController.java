package com.example.missingCats.kittys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/cat")
public class CatController {

    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public List<Cat> getCats() {
        return catService.getCats();
    }

    @GetMapping(path="{catId}")
    public Optional<Cat> getSpecificCats(@PathVariable Long catId) {
        return catService.getSpecificCats(catId);
    }

    @PostMapping
    public void registerNewCat(@RequestBody Cat cat) {
        catService.addNewCat(cat);
    }

    @DeleteMapping(path = "{catId}")
    public void deleteCat(@PathVariable("catId") Long catId) {
        catService.deleteCat(catId);
    }

    @PutMapping(path = "{catId}")
    public void updateCat(@PathVariable("catId") Long catId, @RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(required = false) Integer age) {
        catService.updateCat(catId, name, description, age);
    }
}

