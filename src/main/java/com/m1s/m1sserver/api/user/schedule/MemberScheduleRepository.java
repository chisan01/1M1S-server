package com.m1s.m1sserver.api.user.schedule;

import com.m1s.m1sserver.api.user.schedule.MemberSchedule;
import com.m1s.m1sserver.auth.member.Member;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberScheduleRepository extends JpaRepository<MemberSchedule, Long> {
    Iterable<MemberSchedule> findAllByMember(Member member, Sort sort);

    void deleteAllByMember(Member member);

    @Query(value = "SELECT *\n" +
            "FROM member_schedule\n" +
            "WHERE member_id = ?1\n" +
            "\tAND YEAR(start_time)=?2\n" +
            "\tAND MONTH(start_time)=?3\n" +
            "\tAND DAY(start_time)=?4\n" +
            "ORDER BY start_time;", nativeQuery = true)
    Iterable<MemberSchedule> findAllByMemberAndStartTime(Member member, int year, int month, int day);

}
