package com.m1s.m1sserver.api.user.interest;


import com.m1s.m1sserver.api.interest.Interest;
import com.m1s.m1sserver.api.interest.InterestService;
import com.m1s.m1sserver.api.ranking.Ranking;
import com.m1s.m1sserver.api.ranking.RankingService;
import com.m1s.m1sserver.auth.member.Member;
import com.m1s.m1sserver.utils.CustomException;
import com.m1s.m1sserver.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberInterestService {
    @Autowired
    private MemberInterestRepository memberInterestRepository;

    @Autowired
    private RankingService rankingService;

    @Autowired
    private InterestService interestService;

    public MemberInterest createMemberInterest(MemberInterest memberInterest){
        Ranking ranking;
        interestService.getInterests().forEach(data-> {
            try {
                System.out.println(data.getSubject());
                rankingService.getRanking(memberInterest.getMember(),data);
            }catch (Exception e){
                rankingService.createRanking(memberInterest.getMember(),data);
            }
        });
        return save(memberInterest);
    }


    public boolean checkOwner(Member member, MemberInterest memberInterest){
        if(member.getId() != memberInterest.getMember().getId())throw new CustomException(ErrorCode.NO_AUTHENTICATION);
        return true;
    }

    public MemberInterest editLevel(Member member, MemberInterest memberInterest, String level){
        checkOwner(member, memberInterest);
        if(level != null)memberInterest.setLevel(level);
        return save(memberInterest);
    }

    public Iterable<MemberInterest> getMemberInterests(Member member){

        return memberInterestRepository.findAllByMember(member);
    }

    public MemberInterest getMemberInterest(Long member_interest_id){
        if(!memberInterestRepository.existsById(member_interest_id))throw new CustomException(ErrorCode.MEMBER_INTEREST_NOT_FOUND);
        return memberInterestRepository.findById(member_interest_id).get();
    }

    public void deleteMemberInterest(Member member, MemberInterest memberInterest){
        checkOwner(member, memberInterest);
        if(!memberInterestRepository.existsById(memberInterest.getId()))throw new CustomException(ErrorCode.MEMBER_INTEREST_NOT_FOUND);
        memberInterestRepository.deleteById(memberInterest.getId());
    }
    public MemberInterest save(MemberInterest memberInterest){
        return memberInterestRepository.save(memberInterest);
    }

    public void deleteMemberInterests(Member member){
        memberInterestRepository.deleteAllByMember(member);
    }

}
