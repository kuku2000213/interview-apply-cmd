package kr.gyuna.interview.hexagonal.adapter.out.persistence.reference;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.hexagonal.application.port.out.reference.jobVacancy.CreateJobVacancyPort;
import kr.gyuna.interview.hexagonal.application.port.out.reference.jobVacancy.FindJobVacancyPort;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyId;
import kr.gyuna.interview.hexagonal.repository.reference.jobvacancy.JobVacancyDSL;
import kr.gyuna.interview.hexagonal.repository.reference.jobvacancy.JobVacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Component
public class JobVacancyPersistenceAdapter implements
        CreateJobVacancyPort,
        FindJobVacancyPort
{

    private final JobVacancyRepository jobVacancyRepository;
    private final JobVacancyDSL jobVacancyDSL;

    @Override
    public JobVacancy findJobVacancyById(JobVacancyId jobVacancyId) {

        Optional<JobVacancy> jobVacancyOpt =
                jobVacancyRepository.findById(jobVacancyId);

        return jobVacancyOpt.orElseThrow(() ->
                new NullPointerException("해당 채용공고가 존재하지 않습니다.")
        );
    }

    @Override
    public JobVacancy findCreatedJobVacancyById(JobVacancyId jobVacancyId) {
        Optional<JobVacancy> jobVacancyOpt =
                jobVacancyDSL.findCreatedJobVacancyById(jobVacancyId);

        return jobVacancyOpt.orElseThrow(() ->
                new NullPointerException("해당 채용공고가 등록되지 않았거나, 삭제되었습니다.")
        );
    }

    @Override
    public JobVacancy createJobVacancy(JobVacancy jobVacancy) {
        JobVacancy createdJobVacancy =
                jobVacancyRepository.save(jobVacancy);

        return createdJobVacancy;
    }
}
