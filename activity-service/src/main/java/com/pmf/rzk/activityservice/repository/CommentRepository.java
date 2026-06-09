package com.pmf.rzk.activityservice.repository;

import com.pmf.rzk.activityservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTicketId(Long ticketId);

    List<Comment> findByUserId(Long userId);

}
