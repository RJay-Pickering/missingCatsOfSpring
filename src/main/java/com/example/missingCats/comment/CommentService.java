package com.example.missingCats.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getSpecificComment(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public void addNewComment(Comment comment) {
        Optional<Comment> commentOptional = commentRepository.findCommentByHuman(comment.getHuman());
        if (commentOptional.isPresent()) {
            throw new IllegalStateException("this Comment has already registered");
        }
        commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        boolean exists = commentRepository.existsById(commentId);
        if (!exists) {
            throw new IllegalStateException("Comment with id " + commentId + " does not exists");
        }
        commentRepository.deleteById(commentId);
    }
}