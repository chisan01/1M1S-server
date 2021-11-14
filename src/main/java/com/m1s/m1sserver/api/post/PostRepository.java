package com.m1s.m1sserver.api.post;

import com.m1s.m1sserver.api.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
