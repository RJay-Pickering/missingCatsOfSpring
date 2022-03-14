package com.example.missingCats.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // SELECT * FROM user WHERE name = ?
    @Query("SELECT s FROM Comment s WHERE s.human_id = ?1")
    Optional<Comment> findCommentByHuman(Integer human);
}
