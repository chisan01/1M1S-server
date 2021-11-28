package com.m1s.m1sserver.api.group.member;

import com.m1s.m1sserver.api.group.Party;
import com.m1s.m1sserver.api.group.PartyService;
import com.m1s.m1sserver.api.group.member.PartyMember;
import com.m1s.m1sserver.api.group.member.PartyMemberRepository;
import com.m1s.m1sserver.api.post.Post;
import com.m1s.m1sserver.auth.AuthService;
import com.m1s.m1sserver.auth.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/group/{group_id}/member")
public class PartyMemberController {
    @Autowired
    private PartyMemberRepository partyMemberRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private PartyMemberService partyMemberService;

    @Autowired
    private PartyService partyService;

    @GetMapping
    public Iterable<PartyMember> getGroupMembers(Authentication authentication, @PathVariable Long group_id) {
        Member me = authService.getMe(authentication);
        Party party = partyService.getParty(group_id);
        PartyMember partyMember = partyMemberService.getPartyMember(me, party);
        return partyMemberService.getPartyMembers(party);
    }

    @PutMapping("/{member_id}")
    public PartyMember editGroupMember(Authentication authentication, @PathVariable Long group_id, @PathVariable Long member_id, @RequestParam String authority) {
        Member me = authService.getMe(authentication);
        Party party = partyService.getParty(group_id);
        PartyMember partyMember = partyMemberService.getPartyMember(me, party);
        return partyMemberService.editPartyMember(partyMember, party, authority);
    }

    @DeleteMapping("/{party_member_id}")
    public void deleteGroupMember(Authentication authentication, @PathVariable Long group_id, @PathVariable Long party_member_id) {
        Member me = authService.getMe(authentication);
        Party party = partyService.getParty(group_id);
        PartyMember partyMemberMe = partyMemberService.getPartyMember(me, party);
        partyMemberService.deletePartyMember(partyMemberMe, party_member_id, party);
    }
}
