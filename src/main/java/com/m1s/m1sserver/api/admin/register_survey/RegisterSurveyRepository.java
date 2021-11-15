package com.m1s.m1sserver.api.admin.register_survey;

import com.m1s.m1sserver.api.admin.interest.Interest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface RegisterSurveyRepository extends JpaRepository<RegisterSurvey, Long> {
    Iterable<RegisterSurvey> findAllByInterestId(long interest_id, Sort sort);
}
