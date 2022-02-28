package com.example.missingCats.kittys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

    // SELECT * FROM cat WHERE name = ?
    @Query("SELECT s FROM Cat s WHERE s.name = ?1")
    Optional<Cat> findCatByName(String name);
}
