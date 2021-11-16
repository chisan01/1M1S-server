package com.m1s.m1sserver.api.post;

import com.m1s.m1sserver.api.post.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface PostRepository extends JpaRepository<Post, Long> {
    Iterable<Post> findByMemberId(Long user_id, Sort sort);
    Iterable<Post> findAllByInterestId(Long interest_id, Sort sort);
}
