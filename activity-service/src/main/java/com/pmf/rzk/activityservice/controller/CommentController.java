package com.pmf.rzk.activityservice.controller;

import com.pmf.rzk.activityservice.model.Comment;
import com.pmf.rzk.activityservice.service.CommentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/comments/{id}")
    public Comment getCommentById(@PathVariable @Min(1) Long id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/comments/ticket/{ticketId}")
    public List<Comment> getCommentsByTicketId(@PathVariable @Min(1) Long ticketId) {
        return commentService.getCommentsByTicketId(ticketId);
    }

    @GetMapping("/comments/user/{userId}")
    public List<Comment> getCommentsByUserId(@PathVariable @Min(1) Long userId) {
        return commentService.getCommentsByUserId(userId);
    }

    @PostMapping("/comments")
    public Comment createComment(@Valid @RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable @Min(1) Long id) {
        commentService.deleteComment(id);
    }

    @PutMapping("/comments/{id}")
    public Comment updateComment(
            @PathVariable @Min(1) Long id,
            @Valid @RequestBody Comment comment) {

        return commentService.updateComment(id, comment);
    }
}