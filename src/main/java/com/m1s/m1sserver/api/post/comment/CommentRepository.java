package com.m1s.m1sserver.api.post.comment;

import com.m1s.m1sserver.api.post.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
