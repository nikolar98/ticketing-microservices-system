package com.pmf.rzk.activityservice.service;

import com.pmf.rzk.activityservice.exception.CommentNotFoundException;
import com.pmf.rzk.activityservice.model.Comment;
import com.pmf.rzk.activityservice.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found"));
    }

    public List<Comment> getCommentsByTicketId(Long ticketId) {
        return commentRepository.findByTicketId(ticketId);
    }

    public List<Comment> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserId(userId);
    }

    public Comment createComment(Comment comment) {
        comment.setCreatedAt(Instant.now());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found"));

        commentRepository.delete(comment);
    }

    public Comment updateComment(Long id, Comment comment) {

        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found"));

        existingComment.setContent(comment.getContent());
        existingComment.setCreatedAt(Instant.now());

        return commentRepository.save(existingComment);
    }
}