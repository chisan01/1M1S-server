package com.m1s.m1sserver.api.group.member;


import com.m1s.m1sserver.api.group.Party;
import com.m1s.m1sserver.api.group.PartyService;
import com.m1s.m1sserver.auth.member.Member;
import com.m1s.m1sserver.utils.CustomException;
import com.m1s.m1sserver.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyMemberService {
    @Autowired
    private PartyMemberRepository partyMemberRepository;

    @Autowired
    private PartyService partyService;

    public PartyMember createPartyMember(Member member, Party party, String authority){
        return save(PartyMember.builder()
                .party(party)
                .member(member)
                .authority(authority)
                .build());
    }

    public PartyMember editPartyMember(PartyMember partyMember, Party party, String authority){
        partyService.checkOwner(partyMember, party);
        partyMember.setAuthority(authority);
        return partyMemberRepository.save(partyMember);
    }

    public PartyMember getPartyMember(Member member, Party party){
        if(!partyMemberRepository.existsByMemberAndParty(member, party))
            throw new CustomException(ErrorCode.PARTICIPANT_NOT_FOUND);
        return partyMemberRepository.findByMemberAndParty(member, party);
    }
    public PartyMember getPartyMember(Long party_member_id){
        if(!partyMemberRepository.existsById(party_member_id))throw new CustomException(ErrorCode.PARTICIPANT_NOT_FOUND);
        return partyMemberRepository.findById(party_member_id).get();
    }
    public Iterable<PartyMember> getPartyMembers(Party party){
        return partyMemberRepository.findAllByParty(party);
    }

    public void deletePartyMembers(Party party){
        partyMemberRepository.deleteAllByParty(party);
    }

    public void deletePartyMember(PartyMember requester, Long target_id, Party party){
        partyService.checkOwner(requester, party);
        deletePartyMember(target_id);
    }

    public void deletePartyMember(Long party_member_id){
        if(!partyMemberRepository.existsById(party_member_id))throw new CustomException(ErrorCode.PARTICIPANT_NOT_FOUND);
        partyMemberRepository.deleteById(party_member_id);
    }

    public void deletePartyMembers(Member member){
        partyMemberRepository.deleteAllByMember(member);
    }
    public PartyMember save(PartyMember partyMember){
        return partyMemberRepository.save(partyMember);
    }
}
