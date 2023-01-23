package kr.gyuna.interview.hexagonal.repository.reference.jobvacancy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyId;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.QJobVacancy.jobVacancy;

@Transactional
@Repository
public class JobVacancyDSL {

    private final JPAQueryFactory jpaQueryFactory;

    public JobVacancyDSL(
            EntityManager entityManager
    ) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public Optional<JobVacancy> findCreatedJobVacancyById(JobVacancyId jobVacancyId) {
        return Optional.ofNullable(this.jpaQueryFactory
                .selectFrom(jobVacancy)
                .where(jobVacancy.jobVacancyId.eq(jobVacancyId)
                        .and(jobVacancy.jobVacancyStatus.eq(JobVacancyStatus.CREATED))
                )
                .fetchOne()
        );
    }
}
