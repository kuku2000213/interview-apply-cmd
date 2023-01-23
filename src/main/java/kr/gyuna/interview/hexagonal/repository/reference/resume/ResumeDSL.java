package kr.gyuna.interview.hexagonal.repository.reference.resume;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.gyuna.interview.hexagonal.domain.reference.resume.Resume;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeId;
import kr.gyuna.interview.hexagonal.domain.reference.resume.ResumeStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static kr.gyuna.interview.hexagonal.domain.reference.resume.QResume.resume;

@Transactional
@Repository
public class ResumeDSL {

    private final JPAQueryFactory jpaQueryFactory;

    public ResumeDSL(
            EntityManager entityManager
    ) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public Optional<Resume> findCreatedResumeById(ResumeId resumeId) {
        return Optional.ofNullable(this.jpaQueryFactory
                .selectFrom(resume)
                .where(resume.resumeId.eq(resumeId)
                        .and(resume.resumeStatus.eq(ResumeStatus.CRATED))
                )
                .fetchOne()
        );
    }
}
