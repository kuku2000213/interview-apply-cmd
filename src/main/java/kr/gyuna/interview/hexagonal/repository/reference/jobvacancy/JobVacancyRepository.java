package kr.gyuna.interview.hexagonal.repository.reference.jobvacancy;

import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyId;
import org.springframework.data.repository.CrudRepository;

public interface JobVacancyRepository extends CrudRepository<JobVacancy, JobVacancyId> {
}
