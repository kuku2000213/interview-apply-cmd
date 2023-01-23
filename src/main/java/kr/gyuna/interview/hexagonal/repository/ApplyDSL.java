package kr.gyuna.interview.hexagonal.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.gyuna.interview.hexagonal.domain.Apply;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyId;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static kr.gyuna.interview.hexagonal.domain.QApply.apply;

@Transactional
@Repository
public class ApplyDSL {

    private final JPAQueryFactory jpaQueryFactory;

    public ApplyDSL(
        EntityManager entityManager
    ){
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public Optional<Apply> findApplyByJobVacancyIdAndResumeId(JobVacancyId jobVacancyId, ResumeId resumeId) {
        return Optional.ofNullable(this.jpaQueryFactory.selectFrom(apply)
                .where(apply.jobVacancyId.eq(jobVacancyId)
                        .and(apply.resumeId.eq(resumeId))
                )
                .fetchOne()
        );
    }
}
