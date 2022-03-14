package com.example.missingCats.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    @GetMapping(path="{commentId}")
    public Optional<Comment> getSpecificComment(@PathVariable Long commentId) {
        return commentService.getSpecificComment(commentId);
    }

    @PostMapping
    public void registerNewComment(@RequestBody Comment comment) {
        commentService.addNewComment(comment);
    }

    @DeleteMapping(path = "{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
    }
}

