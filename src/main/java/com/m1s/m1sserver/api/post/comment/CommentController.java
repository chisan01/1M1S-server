package com.m1s.m1sserver.api.post.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post/{post_id}/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public Iterable<Comment> getComments(@PathVariable Long post_id) {
        return commentService.getComments(post_id);
    }
}
