package com.m1s.m1sserver.api.user.group;

import com.m1s.m1sserver.api.group.PartyRepository;
import com.m1s.m1sserver.api.group.member.PartyMember;
import com.m1s.m1sserver.api.group.member.PartyMemberRepository;
import com.m1s.m1sserver.api.post.Post;
import com.m1s.m1sserver.api.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/user/{user_id}/group/{group_id}/post")
public class PartyPostController {
    @Autowired
    private PartyMemberRepository partyMemberRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public ResponseEntity<Iterable<Post>> getGroupMemberPost(@PathVariable Long user_id, @PathVariable Long group_id) {
        PartyMember p = partyMemberRepository.findByMemberIdAndPartyId(user_id, group_id);
        if(p == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(p.getAuthority().equals("승인대기")) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(postRepository.findAllByPartyId(p.getParty().getId()), HttpStatus.OK);
    }
}
