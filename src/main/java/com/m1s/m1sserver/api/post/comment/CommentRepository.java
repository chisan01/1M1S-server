package com.m1s.m1sserver.api.post.comment;

import com.m1s.m1sserver.api.post.Post;
import com.m1s.m1sserver.api.post.comment.Comment;
import com.m1s.m1sserver.auth.member.Member;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Iterable<Comment> findByMember(Member member, Sort sort);
    Iterable<Comment> findByPostId(Long post_id, Sort sort);
}
