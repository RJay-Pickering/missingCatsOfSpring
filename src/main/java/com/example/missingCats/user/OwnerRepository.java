package com.example.missingCats.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    // SELECT * FROM user WHERE name = ?
    @Query("SELECT s FROM Owner s WHERE s.name = ?1")
    Optional<Owner> findOwnerByName(String name);
}
