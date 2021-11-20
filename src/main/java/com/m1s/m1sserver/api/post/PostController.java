package com.m1s.m1sserver.api.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public Iterable<Post> getAllPost(@RequestParam(required = false) Long interest_id) {
        if(interest_id == null) return postRepository.findAll(Sort.by("writingDate"));
        else return postRepository.findAllByInterestId(interest_id, Sort.by(Sort.Direction.DESC, "writingDate"));
    }

    @GetMapping("/{post_id}")
    public Post getPost(@PathVariable Long post_id) {
        return postRepository.findById(post_id).get();
    }
}
