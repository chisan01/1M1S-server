package com.m1s.m1sserver.api.post.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post/{post_id}/comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public Iterable<Comment> getComment(@PathVariable Long post_id) {
        return commentRepository.findByPostId(post_id, Sort.by(Sort.Direction.DESC, "writingDate"));
    }
}
