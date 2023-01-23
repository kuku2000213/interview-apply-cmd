package kr.gyuna.interview.hexagonal.application.port.out.reference.jobVacancy;

import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.reference.jobVacancy.JobVacancyId;

public interface FindJobVacancyPort {
    JobVacancy findJobVacancyById(JobVacancyId jobVacancyId);
    JobVacancy findCreatedJobVacancyById(JobVacancyId jobVacancyId);
}
